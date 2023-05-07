package model;

public class Chambre {
    public int numero;
    public int etage;
    public Catégorie catégorie;
    public boolean occuper;

    public Chambre(int numero, int etage, Catégorie catégorie, boolean occuper) {
        this.numero = numero;
        this.etage = etage;
        this.catégorie = catégorie;
        this.occuper = occuper;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public Catégorie getCatégorie() {
        return catégorie;
    }

    public void setCatégorie(Catégorie catégorie) {
        this.catégorie = catégorie;
    }

    public boolean getOccuper() {
        return occuper;
    }
    public void setOccuper(Boolean occuper) {
        this.occuper = occuper;
    }
}
