package src.main.modelle;

public class Cours {
    private String code;
    private String nom;
    private Person prof;
    private String salle;

    public Cours(){

    }
    public Cours(String code, String nom, Person prof, String salle) {
        this.code = code;
        this.nom = nom;
        this.prof = prof;
        this.salle = salle;
    }
}
