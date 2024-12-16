/*
Partendo dai diagrammi di flusso realizzati in precedenza, programmare il software per la gestione del distributore di bevande.

Nel progetto dovranno essere utilizzati tutti i concetti visti fino a questo momento, inoltre il codice dovrà essere integrato/migliorato
con i concetti della OOP che impareremo nei prossimi giorni.

New feature: gestione operatore. L'operatore può, inserendo un codice riservato, accedere ad un menu di selezione con cui
poter fare le seguenti operazioni:

aggiungere un nuovo prodotto
rimuovere un prodotto
cambiare la quantità disponibile di un prodotto
cambiare il prezzo di un prodotto
Inoltre, l'operatore potrà vedere:

totale incassato dal distributore
elenco dei prodotti acquistati con relative quantità (es: caffè 10, ginseng 18, coca 4)
 */
package distributore;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		System.out.println("Benvenuto o benvenuta ");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		menu(prodotti, scanner);
	}

	public void acquisto(Scanner scanner, double credito, int codex, ArrayList<Prodotto> prodotti) {
		System.out.println("Inserisci denaro ");
		credito = scanner.nextInt();
		for (Prodotto i : prodotti) {
			if (i.codice == codex && i.prezzo <= credito && i.qta > 0) {
				i.erogazione();
				i.nacquisti++;
				Admin.transazione += i.prezzo;
				credito -= i.prezzo;
				System.out.println("Acquisto effettuato con successo! Credito residuo: " + credito);
			} else if (i.codice != codex) {
				System.out.println("Codice errato, riprovare. ");
			} else if (i.prezzo > credito) {
				System.out.println("Credito insufficiente, inserire denaro. ");
			} else if (i.qta <= 0) {
				System.out.println("Prodotto esaurito. ");
			}

		}

	}

	public static void menu(ArrayList<Prodotto> prodotti, Scanner scanner) {
		int scelta;
		for (Prodotto x : prodotti) {
			System.out.println("stampo prodotti" + x.nome + x.getNome());
		}
		do {
			System.out.println("Che vuoi fare? \n 1) Acquista \n 2) Menù Admin \n 3) Esci");
			scelta = scanner.nextInt();
			scanner.nextLine();
			switch (scelta) {
			case 1:
				System.out.println("Selezionare il tipo di bevanda: \n1) Caffetteria \n2) Bevande fredde \n3) Alcolici: ");
				
				break;
			case 2:
				// admin();
				break;

			case 3:
				System.out.println("Arrivederci");
				System.exit(0);
			}
		} while (scelta <= 4);
		scanner.close();
	}

}
//Hello World