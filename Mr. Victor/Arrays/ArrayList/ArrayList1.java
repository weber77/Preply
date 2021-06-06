import java.util.ArrayList;

class ArrayList1 {
    public static void main(String[] args) {
        int a =0;
        int[] etudiants = new int[500]; //16kb

        

        ArrayList<String> c = new ArrayList<String>(); // zero element
        c.add("Victor");
        c.add("Sasha");
        c.add("Victor1");
        c.add("Sasha1");
        c.add(0, "Weber");
        System.out.println("Size c: " + c.size());
        for(int i = 0; i < c.size(); i++)
            System.out.printf(" %s", c.get(i));
        System.out.println();
        c.remove(2);
        System.out.println("Size c: " + c.size());
        for(int i = 0; i < c.size(); i++)
            System.out.printf(" %s", c.get(i));

        System.out.println();

    }
}