package model;

import java.util.*;
import java.time.temporal.*;

public class Hotel {
    public String nom;
    public Vector<Client> clients;
    public Vector<Chambre> chambres;
    public Vector<Reservation> reservations;
    public Vector<Sejour> sejours;
    public Vector<Extra> extras;

    public Hotel(String nom) {
        this.nom = nom;
        this.clients = new Vector<Client>();
        this.chambres = new Vector<Chambre>();
        this.reservations = new Vector<Reservation>();
        this.sejours = new Vector<Sejour>();
        this.extras = new Vector<Extra>();
    }

    public void validerReservation(Vector<Reservation> reservations, Vector<Sejour> sejours, Reservation reservation,
            Hotel hotel) {
        if (!reservation.verifAll(reservations)) {
            reservations.remove(reservation);
            Sejour sejour = new Sejour(reservation.getClient(), reservation.getChambre(), reservation.getDateDebut(),
                    reservation.getDateFin());
            hotel.ajouterSejour(sejour);
        }
    }

    public double arreterSejour(Sejour sejour) {
        double factureTotale = sejour.calculerMontantTotalExtras() + sejour.getChambre().getCatégorie().getPrix()
                * ChronoUnit.DAYS.between(sejour.getDateDebut(), sejour.getDateFin());
        this.supprimerSejour(sejour);
        sejour.getChambre().setOccuper(false);
        this.supprimerClient(sejour.getClient());
        return factureTotale; 
    }

    public Chambre rechercherChambre(int numChambre) {
        for (Chambre chambre : chambres) {
            if (chambre.getNumero() == numChambre) {
                return chambre;
            }
        }
        return null; // si aucune chambre ne correspond au numéro donné
    }

    public Client rechercherClient(String nom, String prenom) {
        for (Client client : clients) {
            if (client.getNom().equals(nom) && client.getPrenom().equals(prenom)) {
                return client;
            }
        }
        return null; // si aucun client ne correspond aux noms donnés
    }

    public Sejour rechercherSejour(String nom, int numero_chambre) {
        for (Sejour sejour : sejours) {
            if (sejour.getClient().getPrenom().equals(nom)) {
                return sejour;
            }
        }
        return null; // si aucun sejour ne correspond aux noms donnés
    }

    public Vector<Sejour> getSejours() {
        return this.sejours;
    }

    public void ajouterClient(Client client) {
        this.clients.add(client);
    }

    public void supprimerClient(Client client) {
        this.clients.remove(client);
    }

    public void ajouterChambre(Chambre chambre) {
        this.chambres.add(chambre);
    }

    public void supprimerChambre(Chambre chambre) {
        this.chambres.remove(chambre);
    }

    public void ajouterReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void supprimerReservation(Reservation reservation) {
        this.reservations.remove(reservation);
    }

    public void ajouterSejour(Sejour sejour) {
        this.sejours.add(sejour);
    }

    public void supprimerSejour(Sejour sejour) {
        this.sejours.remove(sejour);
    }

    public void ajouterExtra(Extra extra) {
        this.extras.add(extra);
    }

    public void supprimerExtra(Extra extra) {
        this.extras.remove(extra);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Vector<Reservation> getReservation() {
        return reservations;
    }

    public Vector<Sejour> getSejour() {
        return sejours;
    }

    public Vector<Client> getClient() {
        return clients;
    }

    public Vector<Extra> getExtra() {
        return extras;
    }

    public Vector<Chambre> getChambre() {
        return chambres;
    }
}