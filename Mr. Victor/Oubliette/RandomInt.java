import java.util.Random;

class RandomInt {
    public static void main(String[] args) {
        Random rand = new Random();

        int facette;

        for(int i=1 ; i <= 30; i++){
            facette = 1 + rand.nextInt(6); 

            System.out.printf("%d ", facette);

            if( i % 5 == 0) 
                System.out.println();
        }

    }
}

// 1 4 2 5 
//14/3 = 4 r 2
//14%3 = 2