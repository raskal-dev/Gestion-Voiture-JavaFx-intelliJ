package mg.coursjavafx.coursjavafx.Models.Voitures;

public class Voitures {
    private int id;
    private String matricule;
    private String marque;
    private int nbplace;
    private double prix;
    private boolean isvendu;

    public Voitures(){
        super();
    }

    public Voitures(String marque, int nbplace, double prix) {
        this.marque = marque;
        this.nbplace = nbplace;
        this.prix = prix;
    }

    public Voitures(int id, String matricule, String marque, int nbplace, double prix) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
        this.nbplace = nbplace;
        this.prix = prix;
    }

    public Voitures(String matricule, String marque, int nbplace, double prix) {
        this.matricule = matricule;
        this.marque = marque;
        this.nbplace = nbplace;
        this.prix = prix;
    }

    public Voitures(int id, String matricule, String marque, int nbplace, double prix, boolean isvendu) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
        this.nbplace = nbplace;
        this.prix = prix;
        this.isvendu = isvendu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getNbplace() {
        return nbplace;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isIsvendu() {
        return isvendu;
    }

    public void setIsvendu(boolean isvendu) {
        this.isvendu = isvendu;
    }
}
