package distributore;

import java.util.Scanner;

public class Caffetteria extends Prodotto {
	protected int qtaZucchero;
	protected int qtaCucchiaini;
	
	public Caffetteria(String nome, int prezzo, int qta) {
		super(nome, prezzo, qta);
	}
	
	public void erogaZucchero(int scelta, Scanner scanner) {
		
		for (int i = 1; i<scelta; i++) {
			qtaZucchero -= i;
		}
	}
}
