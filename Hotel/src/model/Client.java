package model;

public class Client {
	public String nom;
	public String prenom;
	public String anniv;
	public String email;
	public String telephone;

    public Client(String nom, String prenom, String anniv, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.anniv = anniv;
        this.email = email;
        this.telephone = telephone;
    }
    
    // Getters et Setters pour tous les attributs
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAnniv() {
        return anniv;
    }

    public void setAnniv(String anniv) {
        this.anniv = anniv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}