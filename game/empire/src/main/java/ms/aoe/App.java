package ms.aoe;
import java.util.ArrayList;

import ms.aoe.units.*;
public class App {
    public static void main(String[] args) {
        System.out.println("The good team:");
        ArrayList<BaseHero> good = new ArrayList<>();
        good.add(new Crossbow(1,1));
        good.add(new Pikeman(1,2));
        good.add(new Servant(1,3));
        good.add(new Wizard(1,4));
        good.forEach(n -> System.out.println(n));
        
        System.out.println();
        System.out.println("The evil team:");
        ArrayList<BaseHero> evil = new ArrayList<>();
        evil.add(new Bowman(2,1));
        evil.add(new Butcher(2,2));
        evil.add(new Punk(2,3));
        evil.add(new Witch(2,4));
        evil.forEach(n -> System.out.println(n));
    }
}
