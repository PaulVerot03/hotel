package model;

import java.time.*;
import java.util.*;

public class Reservation {
    public static int nextId = 1;
    public int id;
    public Client client;
    public Chambre chambre;
    public LocalDate dateDebut;
    public LocalDate dateFin;

    public Reservation(Client client, Chambre chambre, LocalDate dateDebut, LocalDate dateFin) {
        this.id = nextId++;
        this.client = client;
        this.chambre = chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public static void annulerReservation(Vector<Reservation> reservations, Reservation reservation) {
        reservations.remove(reservation);
        reservation.getChambre().setOccuper(false);
    }

    public boolean verifChambre() {
        return !chambre.getOccuper(); // Retourne vrai si la chambre n'est pas occupée
    }
    
    public boolean verifDate(Reservation autreReservation) {
        // Vérifie si les dates de réservation se superposent avec une autre réservation
        LocalDate dateDebutAutreRes = autreReservation.getDateDebut();
        LocalDate dateFinAutreRes = autreReservation.getDateFin();
        return !(dateDebut.isAfter(dateFinAutreRes) || dateFin.isBefore(dateDebutAutreRes));
    }
    
    public boolean verifAll(Vector<Reservation> reservations) {
        for (Reservation autreReservation : reservations) {
            if (this != autreReservation && verifDate(autreReservation) && verifChambre()) {
                annulerReservation(reservations, autreReservation); // Annule la réservation concurrente
                return true;
            }
        }
        return false;
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
}