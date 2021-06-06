import java.util.Scanner;

class Function3 {
    public static void main(String[] args) {
        String salutation = " Bonjour j'suis weber";
        acceptInfo(salutation,12);
    }

    public static void recoitInfo() { // 
        Scanner scan = new Scanner(System.in);
        String nom = scan.nextLine();
        int age = scan.nextInt();

        acceptInfo(nom, age);
    }

    public static String acceptInfo(String donne, int age) { // declare que la function recoit un String et int en parametre
       String reponseFinal = donne +" "+ age;
       return reponseFinal;
    }

    
}