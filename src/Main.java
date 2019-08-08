//  Design Patterns JAVA
//  Author: Michal Kotecki







/*//  Singleton

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

*//*

OUTPUT:
Value of Star: 3
Value of Star: 14

 *//*
//      END     SINGLETON*/







//  OBSERVER    -       *BEHAVIORAL*

/*

    Dla tego wzorca są potrzebne są klasy:

    * Observable - klasa centrum, która powiązuje ze sobą obiekty, które obserwują i te, które są obserwowane.
    Zawiera listę rzeczy obserwowanych. Taką klasą może być, np. gazeta (Washington Post).
    Gazeta ma różne tematy artykułów (topics), np. polityka, celebryci, morderstwa.
    Dany czytelnik gazety (NewsReader) jest zainteresowany tylko określonymi tematami, nie czyta wszystkiego.
    Z tego powodu, dla maniaka polityki będzie ciekawe, gdy pojawi się jakaś nowa afera PISu lub PO.
    Warto go wtedy o tym poinformować. Takie właśnie zachowanie przedstawia wzorzec OBSERVER - odpowiednie,
    "zainteresowane" obiekty są informowane o zmianach, gdy takowe się pojawią.

    Takie zachowanie wiąże się z pojęciem programowania reaktywnego. Możemy to zaobserwoać, np. w tabelkach
    w Excelu, gdy zawartość pewnej komórki to suma liczb z innych komórek. W momencie zmiany wartości w jakiejś komórce,
    która jest używana to policzenia sumy, wartość zostanie zmieniona, wówczas suma też natychmiast się zmieni - to jest
    programowanie reaktywne.


*/




//  Klasa Observable

import java.util.ArrayList;
import java.util.List;

public class WashingtonPost {
    private String news;
    private List<Topic> channels = new ArrayList<>();

    public void addObserver(Topic channel) {
        this.channels.add(channel);
    }

    public void removeObserver(Topic channel) {
        this.channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        for (Topic channel : this.channels) {
            channel.update(this.news);
        }
    }
}


interface ITopic {
    public void update(Object o);
}


public class Topic implements ITopic {
    private String news;

    @Override
    public void update(Object news) {
        this.setNews((String) news);
    }
}