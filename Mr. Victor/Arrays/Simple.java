import java.util.Scanner;

class Simple {
    public static void main(String[] args) {
        int numero = 4;
        Scanner scan = new Scanner(System.in);

        int[] numeros = new int[5];
        String[] noms = new String[5];

        
        for(int i = 0; i < 5; i++){
            numeros[i] = i * 2;
            System.out.println("Entre ton nom: ");
            noms[i] = scan.nextLine();

        }

         
        System.out.println("counteur\tValuer");

        for(int i = 0; i < 5; i++){
            System.out.printf("%s\t%d\n", noms[i], numeros[i]);
        }
        
    }
}