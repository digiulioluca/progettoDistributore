package distributore;
import java.util.ArrayList;
/*
 * attributi di admin? codice, transazione,
 */
public class Admin {
	int codice;
	int transazione;
	int importo;
	String prodotto;
	
	
	//COSTRUTTORE
	public Admin(int codice){
		this.codice = codice;
	}
	//ARRAYLIST PER CONTENERE I PRODOTTI
	ArrayList <Prodotto> prodotti = new ArrayList<Prodotto>();
	
	public void aggiungicaf (int prezzo, char codice, String nome, int qta) {
		Alcolici alcolici = new Alcolici( nome,  prezzo,  qta);
		Caffetteria caffetteria = new Caffetteria(nome, prezzo,  qta);
		Prodotto bevande = new Prodotto(nome, prezzo, qta);
		
		//AGGIUNGIAMO IL PRODOTTO PREINSERITO NELLA QUANTITA'
		boolean add = false;
		for(Prodotto agg: prodotti) {
			if(agg.nome.equalsIgnoreCase(caffetteria.nome) ) {
				add = true;
				agg.qta += caffetteria.qta;
				System.out.println("Prodotto esistente, aggiornamento quantità: " + agg.qta);
				
			}
		}
		//AGGIUNGIAMO IL PRODOTTO NON ANCORA INSERITO IN ARRAYLIST
		if(add == false) {
			prodotti.add(caffetteria);
		}
		}
 

//<<<<<<< HEAD
		
	
	public void selezionato(int importo, int codice) {
		for(int i = 0; i<prodotti.size(); i++) {
			
		}
		
	}
	public void elencoop(int transazioni) {
	
		
	}
}


//>>>>>>> branch 'master' of https://github.com/digiulioluca/progettoDistributore
