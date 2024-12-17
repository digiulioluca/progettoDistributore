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

		/*
		 * FOR PER AGGIUNTA PRODOTTI
		 * 
		 * for(int i = 0; i< scelta; i++) { scanner.nextLine();
		 * System.out.println("Inserisci nome prodotto: "); String nome =
		 * scanner.nextLine(); bevande.setNome(nome);
		 * System.out.println("Inserisci categoria prodotto: "); String categoria =
		 * scanner.nextLine(); bevande.setCategoria(categoria);
		 * System.out.println("Inserisci codice prodotto: "); int codice =
		 * scanner.nextInt(); bevande.setCodice(codice);
		 * System.out.println("Inserisci prezzo prodotto: "); double prezzo =
		 * scanner.nextDouble(); bevande.setPrezzo(prezzo);
		 * System.out.println("Inserisci quantità prodotto: "); int qta =
		 * scanner.nextInt(); bevande.setQta(qta); prodotti.add(bevande);
		 * 
		 * }
		 */
	}

	// ARRAYLIST PER CONTENERE I PRODOTTI
	static ArrayList<Prodotto> lista = new ArrayList<Prodotto>();

	public void aggiungi(int qta) {

		// AGGIUNGIAMO IL PRODOTTO PREINSERITO NELLA QUANTITA'
		for (int a = 0; a < lista.size(); a++) {
			for (int b = 1; b < lista.size(); b++) {
				if (lista.get(a).getNome().equalsIgnoreCase(lista.get(b).getNome())) {
					System.out.println("Nomi uguali, aggiornamento quantità");
					lista.get(a).qta += qta;
					lista.remove(b);
				}
			}
		}
	}

	// AGGIUNGIAMO IL PRODOTTO NON ANCORA INSERITO IN ARRAYLIST

//<<<<<<< HEAD
//RIMOZIONE PRODOTTI DALLA MACCHINETTA
	public void rimozione(int codice) {
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
	public void elencoop() {
		for (Prodotto prodotti : lista) {
			if (prodotti.nacquisti > 0) {
				System.out.println(" " + prodotti.nome + " " + prodotti.nacquisti);
			}
		}
		System.out.println("Guadagno totale: " + " " + transazione);
	}

//METODO PER IMPOSTARE/CAMBIARE IL PREZZO
	public void cambiaprezzo(int codice, Scanner scanner) {
		for (Prodotto camb : lista) {
			if (codice == camb.codice) {
				System.out.println("Inserire nuovo prezzo");
				camb.prezzo = scanner.nextDouble();
				return;
			}
		}
	}

//METODO PER CAMBIARE/IMPOSTARE QTA PRODOTTO
	public void cambiaqta(int codice, Scanner scanner) {
		for (Prodotto cqta : lista) {
			if (codice == cqta.codice) {
				System.out.println("Inserire nuova quantità");
				cqta.qta = scanner.nextInt();
			}
		}
	}

//ELENCO PRODOTTI
	public void stampatot() {
		for (Prodotto m : lista) {
			System.out.println(m);
		}
	}

//FILTRO CATEGORIA
	public static void filtracat(Scanner scanner) {
		// \n1) Caffetteria \n2) Bevande fredde \n3) Alcolici: ");
		System.out.println("Inserire la categoria del codice da scegliere: \n1) Caffetteria \n2) Bevande fredde \n3) Alcolici ");
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
}

//>>>>>>> branch 'master' of https://github.com/digiulioluca/progettoDistributore