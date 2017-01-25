package tradimsim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class OrdrePrix {
	private double prix;
	private int quantitetotale=0;
	private HashMap<Integer,Ordre> listeordre = new HashMap<Integer, Ordre>();
	private boolean achat;
	private int compteurcles=0;
	private int numeroexecution=0;
	private int clesodreexecuter=0;
	
	public OrdrePrix(Ordre ordre){
		quantitetotale=ordre.getQuantite();
		prix=ordre.getPrixunitaire();
		achat=ordre.isAchat();
		ordre.setKey(compteurcles++);
		listeordre.put(ordre.getKey(), ordre);
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantitetotale() {
		return quantitetotale;
	}

	public void setQuantitetotale(int quantitetotal) {
		this.quantitetotale = quantitetotal;
	}



	public HashMap<Integer, Ordre> getListeordre() {
		return listeordre;
	}

	public void setListeordre(HashMap<Integer, Ordre> listeordre) {
		this.listeordre = listeordre;
	}

	public int getCompteurcles() {
		return compteurcles;
	}

	public void setCompteurcles(int compteurcles) {
		this.compteurcles = compteurcles;
	}

	public int getClesodreexecuter() {
		return clesodreexecuter;
	}

	public void setClesodreexecuter(int clesodreexecuter) {
		this.clesodreexecuter = clesodreexecuter;
	}

	public boolean isAchat() {
		return achat;
	}

	public void setAchat(boolean achat) {
		this.achat = achat;
	}
	public void actualiserQuantite(){
		quantitetotale=0;
		Collection<Ordre> values = listeordre.values();
		for(Ordre ordre : values){
			quantitetotale+= ordre.getQuantite();
		}
	}
	
	public int addOrdre(Ordre ordre){
		if ((ordre.getPrixunitaire()==prix)&&(ordre.isAchat()==achat)&&(!listeordre.containsValue(ordre))){
			ordre.setKey(compteurcles++);
			listeordre.put(ordre.getKey(), ordre);
			quantitetotale+=ordre.getQuantite();
			return 1;
		}
		return 0;
	}
	
	public String toString(){
		return "[Qt:"+quantitetotale+" Prix:"+prix+"]";
	}

	
	public int removeQuantite(int quantite){
		if(quantite>quantitetotale){
			return 0;
		}
		while(quantite>0){
			System.err.println("retirer> numeroexecution:"+numeroexecution);
			Ordre ordre =listeordre.get(numeroexecution);
			int dif= ordre.getQuantite() - quantite;
			quantite=-dif;
			//Si Utilisateur
			if(dif<=0){
				System.err.println("retirer + supp> numeroexecution:"+numeroexecution);
				listeordre.remove(numeroexecution++);
			}else{
				ordre.setQuantite(dif);
			}
		}
		actualiserQuantite();
		if (quantitetotale<=0){
			return -1;
		}
		return 1;
	}
}
