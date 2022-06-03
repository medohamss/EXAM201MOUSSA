package com.example.exam201moussa;

public class Societe {
    int ID;
    String Nom;
    String Secteur;
    int NbEmployee;
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getSecteur() {
        return Secteur;
    }

    public void setSecteur(String secteur) {
        Secteur = secteur;
    }

    public int getNbEmployee() {
        return NbEmployee;
    }

    public void setNbEmployee(int nbEmployee) {
        NbEmployee = nbEmployee;
    }

    public Societe(int ID, String nom, String secteur, int nbEmployee) {
        this.ID = ID;
        Nom = nom;
        Secteur = secteur;
        NbEmployee = nbEmployee;
    }
    public Societe(){

    }
}
