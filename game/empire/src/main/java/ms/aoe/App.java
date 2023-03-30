package ms.aoe;
import java.util.*;
import ms.aoe.units.*;
public class App {
    public static void main(String[] args) {
        System.out.println("THE GOOD GUYS:");
        ArrayList<AbstrActor> good = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            switch (random.nextInt(5)) {
                case 0:
                    good.add(new Crossbow(GoodNames(), 1, 5));
                    break;
                case 1:
                    good.add(new Pikeman(GoodNames(), 2, 8));
                    break;
                case 2:
                    good.add(new Wizard(GoodNames(), 3, 5));
                    break;
                default:
                    good.add(new Servant(GoodNames(), 2, 10));
            }
        }
        good.forEach(n -> System.out.println(n));

        System.out.println("THE EVIL SIDE:");
        ArrayList<AbstrActor> evil = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            switch (random.nextInt(5)) {
                case 0:
                    evil.add(new Bowman(BadNames(), 1, 5));
                    break;
                case 1:
                    evil.add(new Butcher(BadNames(), 2, 8));
                    break;
                case 2:
                    evil.add(new Witch(BadNames(), 3, 5));
                    break;
                default:
                    evil.add(new Punk(BadNames(), 2, 10));
            }
        }
        evil.forEach(n -> System.out.println(n));  

    }
    public static String BadNames()
    {
        return NamesBad.values()[new Random().nextInt(NamesBad.values().length)].toString();
    }
    public static String GoodNames()
    {
        return NamesGood.values()[new Random().nextInt(NamesGood.values().length)].toString();
    }
}
