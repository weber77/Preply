package src.main.modelle;

import java.util.ArrayList;
import src.main.modelle.Cours;

public class Person {
    private String dateNaissance;
    private String nom;
    private String prix;
    private String classe;
    private String mdp;
    private Boolean statue;
    private ArrayList<Cours> cours;
    
    public void Person() {

    }

    public void Person(String nom, String dateNaissance, String prix, String classe, String mdp, Boolean statue) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.prix = prix;
        this.classe = classe;
        this.mdp = mdp;
        this.statue = statue;
    }

    public void Person(String nom, String mdp, Boolean statue) {
        this.nom = nom;
        this.mdp = mdp;
        this.statue = statue;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ajouterCours(Cours crs) {
        this.cours.add(crs);
    }

    public void setMDP(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public String getMDP() {
        return mdp;
    }
}
