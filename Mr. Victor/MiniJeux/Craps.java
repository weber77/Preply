import java.util.Random;

class Craps {
    private static final Random rand = new Random();

    //Statues
    private enum Statue { CONTINUE, GAGNE, PERDU }; // les possible statue

    //contants
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;


    public static void main(String[] args) {
        int premierPoint = 0;
        Statue jeuStatue; // Statue du jeu

        int sumDesD = genereFacettes();

        switch( sumDesD)
        {
            case SEVEN: // 7
            case YO_LEVEN: // 11
                jeuStatue = Statue.GAGNE;
                break;

            case SNAKE_EYES: // 2
            case TREY: // 3
            case BOX_CARS: // 12
                jeuStatue = Statue.PERDU;
                break;

            default:
                jeuStatue = Statue.CONTINUE;
                premierPoint = sumDesD;
                break;
        }

        while( jeuStatue == Statue.CONTINUE)
        {
            sumDesD = genereFacettes();

            if( sumDesD == premierPoint)
            {
                jeuStatue = Statue.GAGNE;
            }
            else if( sumDesD == SEVEN )
            {
                jeuStatue = Statue.PERDU;
            }
        }

        if( jeuStatue == Statue.GAGNE)
            System.out.println("Tu Gagne!");
        else
            System.out.println("Tu Pardu!");
        
    }

    public static int genereFacettes() {
        int d1 = 1 + rand.nextInt(6);
        int d2 = 1 + rand.nextInt(6);

        int sum = d1 + d2;

        System.out.printf("Tu a joué %d + %d = %d\n", d1, d2, sum);

        return sum;
        
    }
}


/**
 *  C'est un jeu a deux dés
 * Condition pour WIN:
 * - sum  du premier lancé = 7 ou 11
 * - sinon la sum des prochain lancé = la sum du premier lancé
 * Condition pour LOST:
 * - sum du premier lancé = 12 ou 2 ou 3
 * - sinon la sum des lancés successif = 7
 */