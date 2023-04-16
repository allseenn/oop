
package ms.eoa;

import ms.eoa.units.*;
import ms.eoa.abstr.Actor;

import java.util.LinkedList;
import java.util.Random;

public class Game {
    public static LinkedList<Actor> units = new LinkedList<>();
   // public static String log = "";
   Integer good = 0;
   Integer bad = 0;
   Integer step = 0;
    public void create() {
        // Создание двух армий (случайно)
        int teamSize = Interface.teamSize; // размер команды берем из интерфейса

        Random random = new Random();
        for (int i = 0; i < teamSize; i++) {
            switch (random.nextInt(4)) {
                case 0: // (команда, индекс, плохое имя, X, Y)
                    units.add(new Bowman(false, 20, BadNames(i), teamSize - 1, i));
                    break;
                case 1:
                    units.add(new Butcher(false, 21, BadNames(i), teamSize - 1, i));
                    break;
                case 2:
                    units.add(new Witch(false, 22, BadNames(i), teamSize - 1, i));
                    break;
                default:
                    units.add(new Punk(false, 23, BadNames(i), teamSize - 1, i));
            }
        }
        for (int i = 0; i < teamSize; i++) {
            switch (random.nextInt(4)) {
                case 0:
                    units.add(new Crossbow(true, 20, GoodNames(i), 0, i));
                    break;
                case 1:
                    units.add(new Pikeman(true, 21, GoodNames(i), 0, i));
                    break;
                case 2:
                    units.add(new Wizard(true, 22, GoodNames(i), 0, i));
                    break;
                default:
                    units.add(new Squire(true, 23, GoodNames(i), 0, i));
            }
        }
    }
    public void turn() {
        step++;
        for (Actor n : units) { if (n.getHp() > 0) {n.step(units);}}
    }
    public String score() {
        good = 0;
        bad = 0;
        for (Actor n: units) {
            if (n.getHp()>0){

                if (n.getTeam() == true) {
                    good++;
                }
                if (n.getTeam() == false) {
                    bad++;
                }
            }
        }
        if (good == 0 || bad == 0) {
            return (good > bad) ? "Победило ДОБРО!" : "Побидило зло!";
        }
        return "Ход № "+step+" Добро: "+good+" & Зло: "+bad;
    }
    public  String BadNames(int i) {
        NamesBad[] names = NamesBad.values();
        return names[i].toString();
    }

    public  String GoodNames(int i) {
        NamesGood[] names = NamesGood.values();
        return names[i].toString();
    }
}
