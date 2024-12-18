package distributore;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	/* attributi: 
	 * - pin per l'accesso dell'admin - double-counter per i guadagni del
	 * distributore
	 * - ArrayList di oggetti Prodotto per contenere tutti i prodotti
	 * del distributore
	 * - fondoCassa
	 */
	private static final int pin = 1027;
	static double totale = 0;
	static double fondoCassa = 100;
	public static final String ANSI_BRIGHTCYAN = "\u001B[96m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BRIGHTRED = "\u001B[91m";

	static ArrayList<Prodotto> lista = new ArrayList<Prodotto>();

	// costruttore
	public Admin() {
	}

	// getter e setter degli attributi
	public static double getTotale() {
		return totale;
	}
	
	public static double getFondoCassa() {
		return fondoCassa;
	}

	public static void setFondoCassa(double restoDisponibile) {
		Admin.fondoCassa = restoDisponibile;
	}

	// metodo che inizializza con dei prodotti "standard" il distributore
	static void aggiunteStandard() {
		Prodotto p1 = new Prodotto("Caffè", 1.50, 10, 101, 1);
		Prodotto p2 = new Prodotto("Acqua naturale", 1, 10, 201, 2);
		Prodotto p3 = new Prodotto("Coca cola", 2.50, 10, 202, 2);
		Prodotto p4 = new Prodotto("Ginseng", 1.80, 10, 102, 1);
		Prodotto p5 = new Prodotto("Decaffeinato", 2, 10, 103, 1);
		Prodotto p6 = new Prodotto("Birra 0,33cl", 3.50, 10, 301, 3);
		Prodotto p7 = new Prodotto("Birra 0,66cl", 5.00, 10, 302, 3);
		Prodotto p8 = new Prodotto("Rum", 8.50, 10, 303, 3);
		Prodotto p9 = new Prodotto("Liquore all'amarena", 1.50, 10, 304, 3);
		Prodotto p10 = new Prodotto("Tè alla pesca", 1.50, 10, 203, 2);
		Prodotto p11 = new Prodotto("Tè al limone", 1.50, 10, 204, 2);
		Prodotto p12 = new Prodotto("Zucchero", 0, 20, 1, 0);
		Prodotto p13 = new Prodotto("Palette", 0, 20, 2, 0);
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p4);
		lista.add(p5);
		lista.add(p6);
		lista.add(p7);
		lista.add(p8);
		lista.add(p9);
		lista.add(p10);
		lista.add(p11);
		lista.add(p12);
		lista.add(p13);
	}

	/*
	 * metodo per l'aggiunta di prodotti nell'ArrayList: come vedremo nel menù,
	 * andremo a creare un oggetto che diventerà argomento/parametro per il metodo
	 * che, prima di attivare l'add, scorrerà l'ArrayList alla ricerca di nomi di
	 * prodotti o codici già inseriti, per evitare ripetizioni all'interno
	 * dell'ArrayList.
	 */
	public static void aggiungi(Prodotto prod) {
		for (Prodotto prodotti : lista) {
			if (prod.getNome().equalsIgnoreCase(prodotti.getNome())) {
				System.out.println("Nomi uguali, aggiornamento quantità.");
				prodotti.qta += prod.qta;
				return;
			}
			if (prod.codice == prodotti.codice) {
				System.out.println("Codice già esistente, prodotto rifiutato");
				return;
			}
		}

		lista.add(prod);
		System.out.println("Operazione eseguita");
	}

	/*
	 * metodo rimozione: in input riceveremo il codice del prodotto e lo cercheremo
	 * con un for-each. Una volta trovato il codice ricercato useremo il return per
	 * uscire dal metodo.
	 */
	public static void rimozione(int codice) {
		for (Prodotto prodotti : lista) {
			if (codice == prodotti.codice) {
				lista.remove(prodotti);
				return;
			}
		}
		System.out.println("Prodotto non trovato");
	}

	/*
	 * metodo che stampa i prodotti acquistati, grazie all'attributo nacquisti (che
	 * si aggiornerà dopo ogni acquisto)
	 */
	public static void elencoop() {
		System.out.println("Prodotti acquistati: ");
		for (Prodotto prodotti : lista) {
			if (prodotti.nacquisti > 0) {
				System.out.println("Nome prodotto: " + prodotti.nome + ", Acquisti: " + prodotti.nacquisti);
			}
		}

	}

	/*
	 * metodo cambio prezzo: come nel metodo "rimozione", riceviamo in input il
	 * codice del prodotto interessato e lo ricerchiamo tramite il for-each. Una
	 * volta trovato, chiediamo l'inserimento del nuovo prezzo.
	 */
	public static void cambiaprezzo(int codice, Scanner scanner) {
		for (Prodotto camb : lista) {
			if (codice == camb.codice) {
				System.out.println("Inserire nuovo prezzo");
				camb.prezzo = scanner.nextDouble();
				return;
			}
		}
	}

	/*
	 * metodo cambio quantità: stesso discorso del metodo precedente
	 */
	public static void cambiaqta(int codice, Scanner scanner) {
		for (Prodotto prodotti : lista) {
			if (codice == prodotti.codice) {
				System.out.println("Inserire nuova quantità");
				prodotti.qta += scanner.nextInt();
			}
		}
	}

	// stampa dell'ArrayList contenente tutti i prodotti inseriti nel distributore
	public static void stampatot() {
		if (lista.isEmpty()) {
			System.out.println("Distributore vuoto");
		} else {
			for (Prodotto prodotti : lista) {
				System.out.println(prodotti);
			}
		}
	}

	/*
	 * metodo filtro: primo step, raccogliere l'input della categoria. Ricevuto
	 * l'input, viene effettuata una ricerca all'interno dell'ArrayList
	 * per stampare tutti i prodotti di una particolare categoria. Inoltre, viene
	 * impiegato un boolean che tenga conto della presenza o meno di una determinata
	 * categoria. Se, alla fine del ciclo, questa variabile resta su 'false', allora
	 * viene stampato un messaggio d'errore.
	 */
	public static boolean filtracat(Scanner scanner) {
		System.out.println("Inserire il numero della categoria: \n1) Caffetteria \n2) Bevande fredde \n3) Alcolici ");
		int filtro = scanner.nextInt();
		boolean trovato = false;
		for (Prodotto prodotti : lista) {
			if (filtro==prodotti.getCategoria()) {
				System.out.println(prodotti);
				trovato = true;
			}
		}
		if (trovato == false)
			System.out.println("Categoria non trovata.");
		return trovato;
	}

	/*
	 * metodo con return boolean per l'accesso al menù admin con for per ciclare tre
	 * volte la richiesta di accesso. Quando l'esito del tentativo è positivo il
	 * ciclo si interrompe.
	 */
	public static boolean accessoGestore(Scanner scanner) {
		boolean accesso = false;
		for (int tentativi = 1; tentativi <= 3; tentativi++) {
			System.out.println("Inserire pin");
			int i = scanner.nextInt();
			if (i == pin) {
				System.out.println("Accesso consentito.");
				accesso = true;
				break;
			} else if (tentativi == 3) {
				System.out.println("Accesso bloccato.");
			} else {
				System.out.println("Codice errato. Riprovare: ");
			}
		}

		return accesso;
	}

	/*metodo per l'erogazione dello zucchero:
	 * assieme al metodo successivo, viene richiamato solo se l'utente cercherà di acquistare
	 * un prodotto dal reparto caffetteria. Metodo int perché abbiamo bisogno, in uscita, di un valore
	 * che regolerà l'erogazione della palette (qtaZucchero>0). Una volta inserita una quantità consentita
	 * (da 1 a 5), ricercheremo il prodotto Zucchero nell'ArrayList per aggiornare le quantità. Tutte le operazioni
	 * si svolgono all'interno di un do-while per prevenire input errati da parte dell'utente. */
	public static int gestioneZucchero(Scanner scanner) {
		int qtaZucchero = 0;
		do {
			System.out.println("Stai cercando di acquistare una bevanda calda, vuoi aggiungere dello zucchero?"
					+ "\nScegliere quantità (da 1 a 5)");
			if (lista.get(11).getQta()<5) {
				System.out.println("Quantità disponibile: "+lista.get(11).getQta());
			}
			qtaZucchero = scanner.nextInt();
			if (qtaZucchero >= 0 && qtaZucchero < 6) {
				for (Prodotto prodotti : lista) {
					if (prodotti.nome.equalsIgnoreCase("Zucchero")) {
						if (qtaZucchero<=prodotti.qta) {
							prodotti.qta -= qtaZucchero;
							System.out.println(ANSI_GREEN+"Erogazione zucchero..."+ANSI_RESET);
							break;
						}
						else {
							System.out.println(ANSI_BRIGHTRED+"Zucchero non disponibile"+ANSI_RESET);
							qtaZucchero=7;
						}
					}
				}
			} else {
				System.out.println(ANSI_BRIGHTRED+"Scelta non consentita."+ANSI_RESET);
			}
		} while (!(qtaZucchero > -1 && qtaZucchero < 6));
		return qtaZucchero;

	}

	/*se dal metodo precedente ritornerà un valore superiore a 0, verrà eseguito il codice all'interno
	 * dell'if e verrà erogata una paletta per il prodotto selezionato. */
	public static void gestionePalette(Scanner scanner) {
		if (gestioneZucchero(scanner) >= 1) {
			for (Prodotto prodotti : lista) {
				if (prodotti.nome.equalsIgnoreCase("Palette")) {
					if (prodotti.qta > 0) {
						prodotti.qta--;
						System.out.println(ANSI_GREEN+"Erogazione paletta"+ANSI_RESET);
					} else {
						System.out.println(ANSI_BRIGHTRED+"Palette esaurite."+ANSI_RESET);
					}
				}
			}
		}
	}
	
	/* metodo per aumentare il prezzo dei prodotti in massa:
	 * dopo aver raccolto in input la percentuale da applicare ai prezzi, scorriamo l'ArrayList alla ricerca
	 * di tutti i prodotti che non siano zucchero o palette, per effettuare l'operazione sul prezzo*/
	public static void cambiaInMassa (double percentuale) {
		System.out.println("Percentuale: "+percentuale);
		for (Prodotto prodotti:lista) {
			if(prodotti.getCodice() != 1 && prodotti.getCodice() != 2) {
				prodotti.prezzo += ((prodotti.prezzo*percentuale)/100);
			}
		}
	}
	
	public static void riduciInMassa (double percentuale) {
		System.out.println("Percentuale: "+percentuale);
		for (Prodotto prodotti:lista) {
			if(prodotti.getCodice() != 1 && prodotti.getCodice() != 2) {
				prodotti.prezzo -= ((prodotti.prezzo*percentuale)/100);
			}
		}
	}

	public static void menuAdmin(Scanner scanner) {

		int scelta = 1;
		do {
			System.out.println(ANSI_BRIGHTCYAN+"Cosa vuoi fare? "+ANSI_RESET+"\n1) Aggiungi prodotti \n2) Rimuovi prodotti"
					+ " \n3) Cambia prezzo \n"
					+ "4) Cambia quantità \n5) Visualizza elenco prodotti \n6) Visualizza guadagni totali \n"
					+ "7) Visualizza lista dei prodotti acquistati \n8) Aumenta prezzi in massa\n"
					+ "9) Riduci prezzi in massa\n10) Cambia il valore del fondo cassa\n11) Torna indietro");
			try {
			scelta = scanner.nextInt();
			}catch(Exception e) {
				System.out.println(ANSI_BRIGHTRED+"Errore. Inserire un numero."+ANSI_RESET);
				scanner.nextLine();
				continue;
			}
			scanner.nextLine();
			switch (scelta) {
			case 1:
				System.out.println("Quanti prodotti vuoi inserire?");
				int numero = scanner.nextInt();
				for (int i = 0; i < numero; i++) {
					Prodotto prod = new Prodotto("", 0, 0, 0, 0);
					scanner.nextLine();
					System.out.println("Inserisci nome prodotto: ");
					String nome = scanner.nextLine();
					prod.setNome(nome);
					System.out.println("Inserisci categoria prodotto (Caffetteria, Bevande, Alcolici): ");
					int categoria = scanner.nextInt();
					prod.setCategoria(categoria);
					System.out.println(
							"Inserisci codice prodotto \nCaffetteria 100-199 \nBevande 200-299 \nAlcolici 300-399 ");
					int codice = scanner.nextInt();
					prod.setCodice(codice);
					System.out.println("Inserisci prezzo prodotto: ");
					double prezzo = scanner.nextDouble();
					prod.setPrezzo(prezzo);
					System.out.println("Inserisci quantità prodotto: ");
					int qta = scanner.nextInt();
					prod.setQta(qta);
					aggiungi(prod);
				}
				break;
			case 2:
				stampatot();
				System.out.println("Inserisci codice prodotto da rimuovere: ");
				int codice = scanner.nextInt();
				rimozione(codice);
				break;
			case 3:
				stampatot();
				System.out.println("Inserisci codice prodotto per cambiare il prezzo: ");
				int codPrezzo = scanner.nextInt();
				cambiaprezzo(codPrezzo, scanner);
				break;
			case 4:
				stampatot();
				System.out.println("Inserisci codice prodotto per cambiare la quantità: ");
				int codQta = scanner.nextInt();
				cambiaqta(codQta, scanner);
				break;
			case 5:
				stampatot();
				break;
			case 6:
				System.out.println("Guadagni dagli acquisti: € " + getTotale());
				break;
			case 7:
				elencoop();
				break;
			case 8:
				System.out.println("Inserire percentuale aumento costo prodotti: \nda 1 a 100");
				double percentuale = scanner.nextDouble();
				cambiaInMassa(percentuale);
				break;
			case 9:
				System.out.println("Inserire percentuale riduzione costo prodotti: \nda 1 a 100");
				double perc = scanner.nextDouble();
				riduciInMassa(perc);
				break;
			case 10:
				System.out.println("Inserisci il nuovo valore del fondo cassa: ");
				double nuovoFondo = scanner.nextDouble();
				setFondoCassa(nuovoFondo);
				break;
			case 11:
				System.out.println("Ritorno al menù principale");
				break;
			default:
				System.out.println("Codice errato.");
			}
		} while (scelta != 11);
	}
}