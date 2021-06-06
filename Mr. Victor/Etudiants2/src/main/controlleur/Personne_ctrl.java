package src.main.controlleur;
import java.util.ArrayList;
import src.main.modelle.Person;

public class Personne_ctrl {
    ArrayList<Person> personnels = new ArrayList<Person>();
    ArrayList<Person> etudiants = new ArrayList<Person>();

    public Boolean verifierMDP(String MDP, String prenom, Boolean estProf) {
        Boolean vrai = false;
        if(estProf){
            for (int i = 0; i < personnels.size(); i++) {
                
                if (personnels.get(i).getNom().equals(prenom)  && personnels.get(i).getMDP().equals(MDP)) {
                    System.out.println("Bienvenue, mr/mme " + prenom);
                    vrai = true;
                }
            }

        }
        else
        {
            for (int i = 0; i < etudiants.size(); i++) {
                if (etudiants.get(i).getNom().equals(prenom)  && etudiants.get(i).getMDP().equals(MDP)) {
                    System.out.println("Bienvenue, mr/mme " + prenom);
                    vrai = true;
                }
            }

        }

        return vrai;
    }

    public void retirerEleve(Person eleve) {
        Boolean vrai = false;
        for (int i = 0; i < etudiants.size(); i++) {
            if (etudiants.get(i).getNom().equals(eleve.getNom())) {
                etudiants.remove(i);
                System.out.println("Changement enregistré.");
            }
        }

        if (vrai == false) {
            System.out.println("Désolé, cet étudiant n'existe pas.");
        }
    }

    public void ajouterEleve(Person eleve) {
        etudiants.add(eleve);
    }

    public void changerEleve(Person eleve, String nom) {
        Boolean vrai = false;
        for (int i = 0; i < etudiants.size(); i++) {
            if (etudiants.get(i).getNom().equals(eleve.getNom())) {
                etudiants.remove(i);
                etudiants.add(eleve);
                System.out.println("Changement enregistré.");
            }
        }

        if (vrai == false) {
            System.out.println("Désolé, cet étudiant n'existe pas.");
        }
    }
}
