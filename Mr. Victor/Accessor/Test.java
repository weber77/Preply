class Test {

    protected int voila;

    public static void main(String[] args) {
        rien();
        

        int a = 5;
        int b = 0;
        name(a, b );
        
    }

    private static void name(int a, int b) {
        System.out.println("Je suis un homme.");
        a += 5;


        b -= a;
        ///
    }

    public static void rien() {
        name(1,3 );
    }
}

//Static : une seul autre methode peux avoir access a cette function a la fois