package distributore;

import java.util.Scanner;

public class Cliente {
	double credito = 0;
	Cliente(double credito){
		this.credito = credito;
		
	}
	
	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public void transazione(int codex, Scanner scanner, double credito){
			int scelta = 1;
			do {
				for(Prodotto i : Admin.lista) {
					if(codex == i.codice) {
						if(credito >= i.prezzo) {
							double resto = credito -= i.prezzo;
							if(resto >0 )
							System.out.println("Resto da erogare = " + " " + resto +"€");
							return;
						}	else {
							double differenza = i.prezzo - credito;
							System.out.println("Credito insufficiente, inserire " + differenza + "€");
							System.out.println("Continuare l'operazione? \n1) Continua \n2) No.");
							int cont = scanner.nextInt();
							if(cont == 1) {
								System.out.println("Bene! Inserire monete. ");
								credito += scanner.nextDouble();
							}
						}
					}
				}
			}	while(scelta != 2);
	}
	public void acquisto(Scanner scanner) {
		System.out.println("Inserisci codice: ");
		int codex = scanner.nextInt();
		System.out.println("Inserisci denaro: ");
		credito = scanner.nextDouble();
		for (Prodotto i : Admin.lista) {
			if (i.codice == codex && i.prezzo <= credito && i.qta > 0) {
				i.erogazione();
				i.nacquisti++;
				Admin.transazione += i.prezzo;
				credito -= i.prezzo;
				System.out.println("Acquisto effettuato con successo! Credito residuo: " + credito);
				return;
			} else if (i.codice != codex) {
				System.out.println("Codice errato, riprovare. ");
			} else if (i.prezzo > credito) {
				System.out.println("Credito insufficiente, inserire denaro. ");
			} else if (i.qta <= 0) {
				System.out.println("Prodotto esaurito. ");
			}
		}
	}
}
