
import java.util.Scanner;
class While {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = 14;
        do{
            System.out.print("Nouvel age: ");
            age = scan.nextInt();
        }while(age < 10);

        // while(age < 20){
        //     System.out.print("Nouvel age: ");
        //     age = scan.nextInt();
        // }
    }
}