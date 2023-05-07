package model;

import java.util.*;
import java.time.*;
import java.time.temporal.*;

public class Sejour {

    public static int nextId = 1;
    public int id;
    public Client client;
    public Chambre chambre;
    public LocalDate dateDebut;
    public LocalDate dateFin;
    public Vector<Extra> extras;
    public Hotel hotel;

    public Sejour(Client client, Chambre chambre, LocalDate dateDebut, LocalDate dateFin) {
        this.id = nextId++;
        this.client = client;
        this.chambre = chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.extras = new Vector<Extra>();
    }

    public double prixSejour() {
        double montantTotal = calculerMontantTotalExtras() + chambre.getCatégorie().getPrix() * ChronoUnit.DAYS.between(dateDebut, dateFin);
        return montantTotal;
    }

    public void supprimerSejour() {
        hotel.supprimerSejour(this);
    }

    public double calculerMontantTotalExtras() {
        double montantTotal = 0.0;
        for (Extra extra : extras) {
            montantTotal += extra.getPrix();
        }
        return montantTotal;
    }

    public void ajouterExtra(Extra extra) {
        extras.add(extra);
    }

    public void supprimerExtra(Extra extra) {
        extras.remove(extra);
    }

    // Getters et Setters pour tous les attributs
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Vector<Extra> getExtras() {
        return extras;
    }
}

