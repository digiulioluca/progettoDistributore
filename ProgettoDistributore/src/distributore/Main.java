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

import java.util.Scanner;

public class Main {
	public static final String ANSI_BRIGHTCYAN = "\u001B[96m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BRIGHTRED = "\u001B[91m";


	public static void main(String[] args) {

		System.out.println("Benvenuto o benvenuta ");
		Scanner scanner = new Scanner(System.in);
		menu(scanner);
		scanner.close();
		System.exit(0);
	}

	/*
	 * metodo menu: presenti un'istanza della Classe cliente e una variabile intera
	 * che utilizzeremo per la gestione do-while e switch
	 */
	public static void menu(Scanner scanner) {
		int scelta = 1;
		Cliente cliente = new Cliente(0);
		Admin.aggiunteStandard();
		do {
			System.out.println(ANSI_BRIGHTCYAN + "Cosa vuoi fare?" + ANSI_RESET +"\n1) Acquista \n2) Menù Admin \n3) Esci");
			try {
				scelta = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println(ANSI_BRIGHTRED + "Errore. Inserire un numero." + ANSI_RESET);
				scanner.nextLine();
				continue;
			}
			switch (scelta) {
			case 1:
				if (Admin.filtracat(scanner))
					cliente.gestioneAcquisto(scanner);
				break;
			case 2:
				if (Admin.accessoGestore(scanner))
					Admin.menuAdmin(scanner);
				break;
			case 3:
				System.out.println("Arrivederci");
				System.exit(0);
			default:
				System.out.println(ANSI_BRIGHTRED +"Codice errato.");
			}

		} while (scelta !=3);

	}

}
//Hello World