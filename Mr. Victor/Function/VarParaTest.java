class VarParaTest {
    public static void main(String[] args) {
        int a =1;
        int b =2;
        int c = 4;
        int d = 8;

        System.out.printf("a = %d\nb = %d\nc = %d\n\n", a, b, c);

        System.out.printf("Moyenne (a,b) = %.1f\n", moyenne(a,b));
        System.out.printf("Moyenne (a,b,c) = %.1f\n", moyenne(a,b,c));
        System.out.printf("Moyenne (a,b,c,d) = %.2f\n", moyenne(a,b,c,d));


    }
    
    public static double moyenne(int... numero) {
        int total = 0;
        for(int i: numero){
            total += i;
        }
        return (double) total/numero.length;
    }
}
