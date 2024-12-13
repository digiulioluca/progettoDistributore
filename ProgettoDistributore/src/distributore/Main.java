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
import java.util.ArrayList;
import distributore.Admin;

public class Main {
	public static void main(String[] args) {
		
		
	}

}
/*public static void menu (ArrayList <Prodotto> prodotti, Scanner scanner) {
int scelta;

do {
    System.out.println("Che vuoi fare? \n 1) Caffetteria \n 2) Bevande \n 3) Menù Admin \n 4) Esci");
    scelta = scanner.nextInt();
    scanner.nextLine();
    switch (scelta) {
    case 1:
        //caffetteria();
        break;
    case 2:
        //bevande();
        break;
    case 3:
        //admin();
        break;
    case 4:
        System.out.println("Arrivederci");
        System.exit(0);
    }
} while (scelta <= 4);
scanner.close();*/
}/*