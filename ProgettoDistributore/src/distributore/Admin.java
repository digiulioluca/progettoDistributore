package distributore;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * attributi di admin? codice, transazione,
 */
public class Admin {
	private final int pin = 1027;
	int transazione;
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
	ArrayList<Prodotto> lista = new ArrayList<Prodotto>();

	public void aggiungicaf(int qta) {

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

	public void rimozione(int codice) {
		boolean trovato = false;
		for (Prodotto rim : lista) {
			if (codice == rim.codice) {
				lista.remove(rim);
				trovato = true;

			}

		}
		if (trovato == false) {
			System.out.println("Prodotto non trovato");
		}

//<<<<<<< HEAD

//=======
	}

//>>>>>>> refs/heads/branch_LucaDG

	public void elencoop(int transazioni) {

	}

	public void cambiaprezzo(int codice, Scanner scanner) {
		for (Prodotto camb : lista) {
			if (codice == camb.codice) {
				System.out.println("Inserire nuovo prezzo");
				camb.prezzo = scanner.nextDouble();

			}

		}
	}

	public void cambiaqta(int codice, Scanner scanner) {
		for (Prodotto cqta : lista) {
			if (codice == cqta.codice) {
				System.out.println("Inserire nuovo prezzo");
				cqta.qta = scanner.nextInt(); 
			}
		}
	}
}
	
//>>>>>>> branch 'master' of https://github.com/digiulioluca/progettoDistributore