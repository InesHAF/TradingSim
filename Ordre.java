package tradingsim;

public class Ordre {

	private boolean contrepartie;

	private String entreprise;
	private double prixunitaire;
	private int quantite;
	private boolean achat;
	private int key = -1;

	public Ordre(String entreprise, double prixunitaire, boolean achat, int quantite) {
		this.entreprise = entreprise;
		this.prixunitaire = prixunitaire;
		this.achat = achat;
		this.quantite = quantite;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public double getPrixunitaire() {
		return prixunitaire;
	}

	public void setPrixunitaire(double prixunitaire) {
		this.prixunitaire = prixunitaire;
	}

	public boolean isAchat() {
		return achat;
	}

	public void setAchat(boolean achat) {
		this.achat = achat;
	}

	public String toString() {
		return "[" + entreprise + ";" + prixunitaire + "]";
	}

}
