package src.main;
import java.util.Scanner;
import src.main.controlleur.Personne_ctrl;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static Personne_ctrl person_ctrl = new Personne_ctrl();
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("Etes vous un enseignant (1) ou un étudiant (2) ?");
        int statue = scan.nextInt();
        scan.nextLine();
        System.out.println("Veuillez entrer votre prénom");
        String prenom = scan.nextLine();
        System.out.println("Veuillez entrer votre mot de passe");
        String MDP = scan.nextLine();

        Boolean authentifier = false;
        if (statue == 1) {
            authentifier = person_ctrl.verifierMDP(MDP, prenom, true);
            if(!authentifier)
            System.out.println("Desole vous n'etes pas dans notre ecole");
        } else if (statue == 2) {
            authentifier = person_ctrl.verifierMDP(MDP, prenom, false);
            if(!authentifier)
            System.out.println("Desole vous n'etes pas dans notre ecole");
        }
        
    }
}