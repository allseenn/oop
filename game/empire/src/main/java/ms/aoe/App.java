package ms.aoe;

import java.util.LinkedList;
import java.util.Random;
import ms.aoe.abstr.Actor;
import ms.aoe.units.*;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Button;

public class App implements Colorit {
    static LinkedList<Actor> units = new LinkedList<>();
    public static LinkedList<String> log = new LinkedList<>();
    public static int xX;
    public static int yY;
   // public static void main(String[] args) {
    public static void play() {
        // Создание двух армий
        int teamSize = Interface.teamSize;
        
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
        // Sorting by priority
        units.sort((t1, t2) -> t1.getPriority() - t2.getPriority());
        Frame frame = new Frame("Viewer");
        Viewer table = new Viewer(teamSize, teamSize, 40);
        Viewer right = new Viewer(1, teamSize, 15);
        Viewer left = new Viewer(1, teamSize, 15);
        Viewer console = new Viewer(1, 15, 12);
        Button buttonStep = new Button("step");
        Button buttonExit = new Button("exit");
        
        buttonStep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer good = 0;
                Integer bad = 0;
                for (Actor n : units) {
                    if (n.getHp() > 0) {
                        xX = 999;
                        yY = 999;
                        n.step(units);
                        table.setValue(n.getX(), n.getY(), n.getIcon());
                        if (n.getTeam() == true) {
                            left.setValue(0, n.getY(), n.getInfo());
                            good++;
                        }
                        if (n.getTeam() == false) {
                            right.setValue(0, n.getY(), n.getInfo());
                            bad++;
                        }
                    } else {
                        table.setValue(n.getX(), n.getY(), "");
                       if(n.getTeam()==true){left.setValue(0, n.getY(), n.getInfo());}
                       if(n.getTeam()==false){right.setValue(0, n.getY(), n.getInfo());}
                    }
                    if(xX!=999 || yY!=999){table.setValue(xX, yY, "");}
                }
                if (good == 0 || bad == 0) {
                    buttonStep.setEnabled(false);
                    if(good > bad){ log.add("ПОБЕДИЛО ДОБРО!"); }
                    else { log.add("ПОБЕДИЛО ЗЛО!"); }
                }
                int count = 0;
                for (int i = log.size()-15; i < log.size(); i++) {
                    console.setValue(0, count, log.get(i));
                    count++;
                }
                units.sort((t1, t2) -> t1.getPriority() - t2.getPriority());
            }
        });
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        Panel panel = new Panel();
        panel.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout());
        right.setSize(350,500);
        left.setSize(350, 500);
        console.setSize(1200, 250);
        frame.add(table, BorderLayout.CENTER);
        frame.add(left, BorderLayout.WEST);
        frame.add(right, BorderLayout.EAST);
        panel.add(buttonStep, BorderLayout.WEST);
        panel.add(buttonExit, BorderLayout.EAST);
        frame.add(panel, BorderLayout.SOUTH);
        frame.add(console, BorderLayout.NORTH);
        frame.setSize(1200, 750);
        frame.setVisible(true);
        for (Actor n : units) {
            table.setValue(n.getX(), n.getY(), n.getIcon());
            if(n.getTeam()==true){left.setValue(0, n.getY(), n.getInfo());}
            if(n.getTeam()==false){right.setValue(0, n.getY(), n.getInfo());}
        }
        console.setValue(0, 0, "Добро пожаловать в игру Снежный Барс ))");

    }

    public static String BadNames(int i) {
        NamesBad[] names = NamesBad.values();
        return names[i].toString();
    }

    public static String GoodNames(int i) {
        NamesGood[] names = NamesGood.values();
        return names[i].toString();
    }
}
