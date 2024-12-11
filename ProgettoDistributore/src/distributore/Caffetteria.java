package distributore;


public class Caffetteria extends Prodotto {
	// attributi
	protected int qtaZucchero;
	protected int qtaCucchiaini;
	
	public Caffetteria(String nome, int prezzo, int qta) {
		super(nome, prezzo, qta);
	}
	
	// metodo per erogazione dello zucchero
	public void erogaZucchero(int scelta) {
		/* controllo sulla quantità scelta dall'utente con la quantità presente
		 in magazzino di zucchero*/
		if (scelta<qtaZucchero) {
			for (int i = 1; i<scelta; i++) {
					qtaZucchero -= i;
			}
		}else{
			System.out.println("Impossibile erogare perché hai inserito un numero"
						+"maggiore rispetto alla quantità di zucchero.");	
		}
	}
	
	// metodo per erogare cucchiaini, simile al precedente
	public void erogaCucchiaini() {
		qtaCucchiaini--;
	}
}
