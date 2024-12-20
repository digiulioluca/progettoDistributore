package distributore;

import java.util.Scanner;

/* nella classe cliente andiamo a gestire le fasi di acquisto del prodotto, incluso
 il controllo sull'età per l'acquisto di prodotti alcolici*/

public class Cliente {
	
	public static final String ANSI_BRIGHTCYAN = "\u001B[96m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BRIGHTRED = "\u001B[91m";
	
	// attributi classe cliente
	double credito;
	
	// costrutttore
	Cliente(double credito) {
		this.credito = credito;

	}
	
	// getter and setter
	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}
	
	/* metodo per il controllo dell'età: 
	 con una boolean già settata su true (nel caso in cui si tratti di una bevanda non-alcolica),
	 scorriamo l'ArrayList con il codice della bevanda ricercata che passiamo via parametro, e una volta trovato
	 il prodotto alcolico selezionato, richiediamo via input l'età dell'utente.*/
	public boolean controlloEta(Scanner scanner, int codice) {
		boolean accesso=false;
		for (Prodotto prodotti:Admin.lista) {
			if (codice==prodotti.getCodice() && codice>300) {
				System.out.println("Stai cercando di acquistare un prodotto alcolico. Inserisci età:");
				int eta=scanner.nextInt();
				if (eta>=18) {
					System.out.println(ANSI_GREEN+"Acquisto consentito."+ANSI_RESET);
					accesso=true;
					break;
				} else {
					accesso=false;
					System.out.println(ANSI_BRIGHTRED+"Acquisto non consentito."+ANSI_RESET);
				}
			}
			if(codice==prodotti.getCodice() && codice<300) {
				accesso=true;
				break;
			}
		}
		return accesso;
	}
	
	/* metodo per la gestione del credito: 
	 il codice è incluso all'interno del do-while per gestire l'inserimento del credito in caso di
	 credito mancante. Di fronte a questo scenario, l'utente può anche rinunciare all'acquisto.*/
	public boolean gestioneCredito(Scanner scanner, int codice) {
		boolean acquisto=false;
		int continua=1;
		do {
			for (Prodotto prodotti:Admin.lista) {
				if (prodotti.getCodice()==codice) {
					if (credito>=prodotti.getPrezzo()) {
						credito -= prodotti.getPrezzo();
						if (credito>0) {
							if (Admin.fondoCassa>0 && credito<=Admin.fondoCassa) {
								Admin.fondoCassa -= credito;
								System.out.format("Resto: € %.2f\n", credito);
							} else {
								System.out.println(ANSI_BRIGHTRED+"Resto non disponibile."+ANSI_RESET);
							}
						}
						acquisto=true;
						continua=2;
					} else {
						System.out.println("Credito insufficiente. Vuoi continuare?: "
								+"\nPremi 1 per continuare, 2 per uscire.");
						continua = scanner.nextInt();
						if (continua==1) {
							System.out.format("Inserire altro credito (credito mancante: € %.2f): \n", (prodotti.getPrezzo()-credito));
							credito += scanner.nextDouble();
						} else {
							System.out.println(ANSI_BRIGHTRED+"Acquisto annullato."+ANSI_RESET);
						}
					}
				}
			}
		} while(continua!=2);
		return acquisto;
	}
	
	/* metodo per la gestione dell'acquisto:
	 dopo aver ottenuto TRUE nei due metodi boolean precedenti, scorriamo di nuovo l'ArrayList
	 per ricercare il codice inserito dall'utente, e, una volta trovato, vengono effettuate le varie operazioni
	 di erogazione e aggiornamento dei registri del gestore.*/
	public void gestioneAcquisto(Scanner scanner) {
		System.out.println("Inserisci codice: ");
		int codice=scanner.nextInt();
		if (controlloEta(scanner,codice)) {
			System.out.println("Inserisci credito: ");
			credito=scanner.nextDouble();
			// soluzione pigra per evitare numeri negativi
			if (credito<0) credito *= -1;
			
			if (gestioneCredito(scanner, codice)) {
				for (Prodotto prodotti:Admin.lista) {
					if (codice==prodotti.getCodice()) {
						if(prodotti.qta>0) {
							// aggiornamento registri
							prodotti.erogazione();
							prodotti.nacquisti++;
							Admin.fondoCassa+=prodotti.getPrezzo();
							Admin.totale+=prodotti.getPrezzo();
							if (prodotti.getCodice()<200 && codice==prodotti.getCodice()) {
								/* in questo passaggio, ovvero nel caso in cui la bevanda scelta sia calda,
								 * viene richiamato solo il metodo gestionePalette perché il metodo per la gestione
								 * dello zucchero verrà eseguito all'interno del primo metodo*/
								Admin.gestionePalette(scanner);
							}
							
							System.out.println(ANSI_GREEN+"Acquisto effettuato con successo!"+ANSI_RESET);
						} else {
							System.out.println(ANSI_BRIGHTRED+"Prodotto momentaneamente non disponibile. "
									+ "Acquisto annullato"+ANSI_RESET);
						}
					}
				}
			}
		} else {
			System.out.println("Codice non trovato.");
		}
	}
	
}
