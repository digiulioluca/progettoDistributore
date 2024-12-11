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
	
	public void aggiungi (Prodotto prod) {
	
		//AGGIUNGIAMO IL PRODOTTO PREINSERITO NELLA QUANTITA'
		boolean add = false;
		for(Prodotto agg: prodotti) {
			if(agg.nome.equalsIgnoreCase(prod.nome) ) {
				add = true;
				agg.qta += prod.qta;
				System.out.println("Prodotto esistente, aggiornamento quantità: " + agg.qta);
				
			}
		}
		//AGGIUNGIAMO IL PRODOTTO NON ANCORA INSERITO IN ARRAYLIST
		if(add == false) {
			prodotti.add(prod);
		}
		}
 

//<<<<<<< HEAD
		
	
	public void selezionato(int importo, int codice) {
		
		
	}
	public void elencoop(int transazioni) {
	
		
	}
}


//>>>>>>> branch 'master' of https://github.com/digiulioluca/progettoDistributore
