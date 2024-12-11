package distributore;

<<<<<<< HEAD
public class Alcolici {
	
=======
public class Alcolici extends Prodotto{
	// attributi
	private final int etaMinima = 18;
	
	// costruttore
	public Alcolici (String nome, int prezzo, int qta) {
		super(nome, prezzo, qta);
	}
	
	/* controllo età per l'erogazione dei prodotti alcolici:
	 if-else che verrà richiamato a priori per stabilire o meno se erogare il prodotto (tramite
	 il metodo della super-class)*/
	public void erogazioneAlc(int inputEta) {
		if (inputEta>=etaMinima) {
			System.out.println("Erogazione del prodotto alcolico acconsentita.");
			erogazione();
		} else {
			System.out.println("Età non valida.");
		}
	}
>>>>>>> branch 'master' of https://github.com/digiulioluca/progettoDistributore
}
