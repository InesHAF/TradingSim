package tradimsim;

public class Entreprise {
    private String raisonSociale;

    private String isin;

    private String secteur;

    private double prixAction;

    private PrixDate prixHistorique;

    private EvenementEntreprise listeEvenement;

    private String description;

    private double prixAnticipé;

    private double pourcentageA;

    private double tauxDactualisation;

    public PrixDate prixDate;

    public CarnetOrdre carnetOrdre;

    public EvenementEntreprise evenementEntreprise;

    public boolean passerOrdre(double prix, int qte, boolean type) {
    }

    public boolean genererEvenement() {
    }

    public void actualiserPourcentageA() {
    }

}
