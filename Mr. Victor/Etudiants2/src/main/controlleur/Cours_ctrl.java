package src.main.controlleur;
import java.util.ArrayList;
import src.main.modelle.Cours;


public class Cours_ctrl {
    ArrayList<Cours> cours = new ArrayList<Cours>();

    
    public void retirerCour(Cours crs) {
        Boolean vrai = false;
        for (int i = 0; i < cours.size(); i++) {
            if (cours.get(i).getNom().equals(crs.getNom())) {
                cours.remove(i);
                System.out.println("Changement enregistré.");
            }
        }

        if (vrai == false) {
            System.out.println("Désolé, cet cours n'existe pas.");
        }
    }

    public void ajouterCours(Cours crs) {
        cours.add(crs);
    }

    public void changerCours(Cours crs, String nom) {
        Boolean vrai = false;
        for (int i = 0; i < cours.size(); i++) {
            if (cours.get(i).getNom().equals(crs.getNom())) {
                cours.remove(i);
                cours.add(eleve);
                System.out.println("Changement enregistré.");
            }
        }

        if (vrai == false) {
            System.out.println("Désolé, cet étudiant n'existe pas.");
        }
    }
}
