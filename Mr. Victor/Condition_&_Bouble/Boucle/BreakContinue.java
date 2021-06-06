class BreakContinue {
    public static void main(String[] args) {
        int i = 0, j = 0;

        for( ; i < 10; i++){
            if(i == 5){
                break;
            }
            System.out.println("I = " + i);
        }
        System.out.println("Je suis sorti et I = " + i);
        System.out.println("\n===============================\n");
        
        for( ; j < 10; j++){ 
            if(j == 5){
                continue;
            }
            System.out.println("J = " + j);
        }



        
    }
}