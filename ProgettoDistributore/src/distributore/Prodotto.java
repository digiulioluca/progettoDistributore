package distributore;

public class Prodotto {
	// attributi
	protected String nome;
	protected int prezzo;
	protected int qta;
	
	public Prodotto(String nome, int prezzo, int qta) {
		// costruttore
		this.nome = nome;
		this.prezzo = prezzo;
		this.qta = qta;
	}
	
	public void erogazione() {
		qta--;
	}
}
