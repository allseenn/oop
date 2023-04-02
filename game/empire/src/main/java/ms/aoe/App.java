package ms.aoe;
import java.util.*;

import ms.aoe.abstr.Actor;
import ms.aoe.units.*;
public class App {
    public static void main(String[] args) {
        int teamSize = 10;
        LinkedList<Actor> units = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < teamSize; i++) {
            switch (random.nextInt(4)) {
                case 0:
                    units.add(new Bowman(false, i, BadNames(i), i, teamSize-1));
                    break;
                case 1:
                    units.add(new Butcher(false, i, BadNames(i), i, teamSize-1));
                    break;
                case 2:
                    units.add(new Witch(false, i, BadNames(i), i, teamSize-1));
                    break;
                default:
                    units.add(new Punk(false, i, BadNames(i), i, teamSize-1));
            }
        }
        for (int i = teamSize; i < teamSize*2; i++) {
            switch (random.nextInt(4)) {
                case 0:
                    units.add(new Crossbow(true, i, GoodNames(i), 0, i));
                    break;
                case 1:
                    units.add(new Pikeman(true, i, GoodNames(i), 0, i));
                    break;
                case 2:
                    units.add(new Wizard(true, i, GoodNames(i), 0, i));
                    break;
                default:
                    units.add(new Squire(true, i, GoodNames(i), 0, i));
            }
        }
       units.forEach(n -> System.out.println(n.step(units)));
       

    }
    public static String BadNames(int i)
    {
        NamesBad[] names = NamesBad.values();
        return names[i].toString();
    }
    public static String GoodNames(int i)
    {
        NamesGood[] names = NamesGood.values();
        return names[i].toString();
    }
}
