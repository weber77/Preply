import java.util.Scanner;

class Function2 {
    


    public static void main(String[] args) {        
        // String phrase = demandInfo();
        // System.out.println(phrase);

        System.out.println(demandInfo());
    }

    public static String demandInfo() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Vos info SVP");

        System.out.print("Votre nom: ");
        String name = scan.nextLine(); // Espere une chaine de charactere

        System.out.print("Votre age: ");
        int age = scan.nextInt(); // Espere un entier

        return "Il s'appel " + name + " et il a: " + age + " ans.";

        // J'suis Victor et j'ai 12
    }


    public static int demandI() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Vos info SVP");

        System.out.print("Votre nom: ");
        String name = scan.nextLine(); // Espere une chaine de charactere

        System.out.print("Votre age: ");
        int age = scan.nextInt(); // Espere un entier

        return age;
        // J'suis Victor et j'ai 12
    }

}