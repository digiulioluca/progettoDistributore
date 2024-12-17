package distributore;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * attributi di admin? codice, transazione,
 */
public class Admin {
	private final int pin = 1027;
	static double transazione = 0;
	int importo;
	String prodotto;

	// COSTRUTTORE
	public Admin() {
	}

	public static void menuAdmin(Scanner scanner) {
		
		int scelta=1;
		do {
			System.out.println("Che vuoi fare? \n 1) Aggiungi prodotti \n 2) Rimuovi prodotti \n 3) Cambia prezzo \n "
					+ "4) Cambia quantità \n 5) Visualizza elenco prodotti \n 6) Visualizza guadagni totali \n "
					+ "7) Visualizza lista dei prodotti acquistati \n 8) Torna indietro");
			scelta = scanner.nextInt();
			scanner.nextLine();
			switch (scelta) {
			case 1:	
				System.out.println("Quanti prodotti vuoi inserire?");	
				int numero=scanner.nextInt();
				for (int i = 0; i < numero; i++) {
					Prodotto bevande = new Prodotto("",0,0,0,"");
					scanner.nextLine();
					System.out.println("Inserisci nome prodotto: ");
					String nome = scanner.nextLine();
					bevande.setNome(nome);
					System.out.println("Inserisci categoria prodotto (Caffetteria, Bevande, Alcolici): ");
					String categoria = scanner.nextLine();
					bevande.setCategoria(categoria);
					System.out.println("Inserisci codice prodotto \nCaffetteria 100-199 \nBevande 200-299 \nAlcolici 300-399 ");
					int codice = scanner.nextInt();
					bevande.setCodice(codice);
					System.out.println("Inserisci prezzo prodotto: ");
					double prezzo = scanner.nextDouble();
					bevande.setPrezzo(prezzo);
					System.out.println("Inserisci quantità prodotto: ");
					int qta = scanner.nextInt();
					bevande.setQta(qta);
										
					aggiungi(bevande);
					
				} break;
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
				System.out.println(getTransazione());
				break;
			case 7:
				elencoop();
				break;
			case 8:
				System.out.println("Ritorno al menù principale");
				break;
			}
	} while (scelta != 8);
	}

	// ARRAYLIST PER CONTENERE I PRODOTTI
	static ArrayList<Prodotto> lista = new ArrayList<Prodotto>();

	public static void aggiungi(Prodotto bevande) {

		// AGGIUNGIAMO IL PRODOTTO PREINSERITO NELLA QUANTITA'
		for (Prodotto prodotti:lista) {
			if (bevande.getNome().equalsIgnoreCase(prodotti.getNome())) {
				System.out.println("Nomi uguali, aggiornamento quantità.");
				prodotti.qta+=bevande.qta;
				return;
			}
			if (bevande.codice==prodotti.codice) {
				System.out.println("Codice già esistente, prodotto rifiutato");
				return;
			}
		}
		lista.add(bevande);
		System.out.println("Operazione eseguita");
	}

	// AGGIUNGIAMO IL PRODOTTO NON ANCORA INSERITO IN ARRAYLIST

//<<<<<<< HEAD
//RIMOZIONE PRODOTTI DALLA MACCHINETTA
	public static void rimozione(int codice) {
		for (Prodotto rim : lista) {
			if (codice == rim.codice) {
				lista.remove(rim);
				return;
			}

		}

		System.out.println("Prodotto non trovato");

//<<<<<<< HEAD

//=======
	}

//>>>>>>> refs/heads/branch_LucaDG

//GESTIONE TOTALE TRANSAZIONI IN ADMIN 
	public static void elencoop() {
		for (Prodotto prodotti : lista) {
			if (prodotti.nacquisti > 0) {
				System.out.println(" " + prodotti.nome + " " + prodotti.nacquisti);
			}
		}
		
	}

//METODO PER IMPOSTARE/CAMBIARE IL PREZZO
	public static void cambiaprezzo(int codice, Scanner scanner) {
		for (Prodotto camb : lista) {
			if (codice == camb.codice) {
				System.out.println("Inserire nuovo prezzo");
				camb.prezzo = scanner.nextDouble();
				return;
			}
		}
	}

//METODO PER CAMBIARE/IMPOSTARE QTA PRODOTTO
	public static void cambiaqta(int codice, Scanner scanner) {
		for (Prodotto cqta : lista) {
			if (codice == cqta.codice) {
				System.out.println("Inserire nuova quantità");
				cqta.qta = scanner.nextInt();
			}
		}
	}

//ELENCO PRODOTTI
	public static void stampatot() {
		for (Prodotto m : lista) {
			System.out.println(m);
		}
	}

//FILTRO CATEGORIA
	public static void filtracat(Scanner scanner) {
		// \n1) Caffetteria \n2) Bevande fredde \n3) Alcolici: ");
		System.out.println("Inserire la categoria: \n1) Caffetteria \n2) Bevande fredde \n3) Alcolici ");
		int filtro = scanner.nextInt();
		for (Prodotto n : lista) {
			if (filtro == 1) {
				for (int i = 0; i <= 100; i++) {
					System.out.println(n);
				}
			} else if (filtro == 2) {
				for (int l = 101; l <= 200; l++) {
					System.out.println(n);
				}
			} else if (filtro == 3) {
				for (int m = 201; m <= 300; m++) {
					System.out.println(n);
				}
			} else {
				System.out.println("NUMERO ERRATO. ");

			}

		}
	}

	public static double getTransazione() {
		return transazione;
	}

	public static void setTransazione(double transazione) {
		Admin.transazione = transazione;
	}

}

//>>>>>>> branch 'master' of https://github.com/digiulioluca/progettoDistributore