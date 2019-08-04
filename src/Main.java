//  Design Patterns JAVA
//  Author: Michal Kotecki







//  Singleton

class Universe {

    private static Universe universe;
    private Universe(){};

    private int Star;

    public static Universe getUniverse(){
        if (universe == null){
            universe = new Universe();
        }
        return universe;
    }

    public int getStar() {
        return Star;
    }

    public void setStar(int star) {
        Star = star;
    }
};

public class Main {

    public static void main(String[] args) {

        Universe.getUniverse().setStar(3);
        System.out.println("Value of Star: "  + Universe.getUniverse().getStar());

        Universe.getUniverse().setStar(14);
        System.out.println("Value of Star: "  + Universe.getUniverse().getStar());
    }
}

/*

OUTPUT:
Value of Star: 3
Value of Star: 14

 */
//      END     SINGLETON