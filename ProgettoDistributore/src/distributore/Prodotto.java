package distributore;

public class Prodotto {
	// attributi

	protected String nome;
	protected double prezzo;
	protected int qta;
	protected int codice;
	protected String categoria;
	protected int nacquisti;

	public Prodotto(String nome, double prezzo, int qta, int codice, String categoria) {
		// costruttore
		this.nome = nome;
		this.prezzo = prezzo;
		this.qta = qta;
		this.codice = codice;
		this.categoria = categoria;
		this.nacquisti = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQta() {
		return qta;
	}

	public void setQta(int qta) {
		this.qta = qta;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public void erogazione() {
		// metodo erogazione. Sottraggo 1 uno all'attributo quantità
		qta--;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Categoria: " + categoria + ", Codice: " + codice + ", Prezzo: " + prezzo
				+ ", Quantità: " + qta;
	}

	public int getNacquisti() {
		return nacquisti;
	}

	public void setNacquisti(int nacquisti) {
		this.nacquisti = nacquisti;
	}

}