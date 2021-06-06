class TestTemps {
    public static void main(String[] args) {
        Temps time = new Temps();

        System.out.print("Le temps uni est:");
        System.out.println(time.universelle());
        System.out.print("Le temps Anglais est:");
        System.out.println(time.toString());
        System.out.println();

        time.setTime(18,0,0);
        System.out.print("Le temps uni est:");
        System.out.println(time.universelle());
        System.out.print("Le temps Anglais est:");
        System.out.println(time.toString());
        System.out.println();

        try{
            time.setTime(99,99,99);
        }
        catch( IllegalArgumentException e)
        {
            System.out.printf("Exception: %s\n\n", e.getMessage() );
        }

        System.out.println("Le temps Apres une erreur");
        System.out.print("Le temps uni est:");
        System.out.println(time.universelle());
        System.out.print("Le temps Anglais est:");
        System.out.println(time.toString());
        System.out.println();




    }
}