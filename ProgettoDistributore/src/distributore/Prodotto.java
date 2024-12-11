package distributore;

public class Prodotto {
	// attributi
	protected String nome;
	protected int prezzo;
	protected int qta;
	protected int id;
	
	public Prodotto(String nome, int prezzo, int qta, int id) {
		// costruttore
		this.nome = nome;
		this.prezzo = prezzo;
		this.qta = qta;
		this.id = id;
	}
	
	public void erogazione() {
		// metodo erogazione. Sottraggo 1 uno all'attributo quantità
		qta--;
	}
}
