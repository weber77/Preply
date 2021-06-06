import java.util.Scanner;

class Switch {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.print(" Age: ");
        int age = scan.nextInt();

        switch (age) {
            case 10:
                System.out.println(" T'as deja " + age + " ans.");
                break;
            case 20:
                System.out.println(" T'es majeur " );
                break;
            case 60:
                System.out.println(" T'es veteran ");
                break;
        
            default:
                 System.out.println(" T'es vivant. Bonne anniversaire ");
                break;
        }

        
    }
}

// Pour demain : switch, break et continue