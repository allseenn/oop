package ms.aoe;
import ms.aoe.units.*;
import ms.aoe.abstr.Actor;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {
    static LinkedList<Actor> units = new LinkedList<>();
    public static String log = "";
    public static int xX; // внешне изменяемая X для того чтобы изменять положение пехоты на поле
    public static int yY; // внешне изменяемая У для того чтобы изменять положение пехоты на поле
   // public static void main(String[] args) {
    public static void play() {
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
        // Sorting by priority
        units.sort((t1, t2) -> t1.getPriority() - t2.getPriority());
        // Создаем главный фрейм (Заголовок окна)
        Frame frame = new Frame("Империя");
        // Верхнее окно консоли
        TextArea console = new TextArea();
        //View console = new View(1, 15, 12, 2, "Courier New", 4, 0);
        // Создаем поле в виде таблицы (полей, строк, размерШрифта, цветТекста, текстовыйШрифт, заливка, видимостьЛиний)
        View table = new View(teamSize, teamSize, 40, 4, "Serif", 0, 1);
        // Левое окно
        View left = new View(1, teamSize, 15, 4, "Bookman Old Style", 0, 1);
        // Правое окно
        View right = new View(1, teamSize, 15, 4, "Arial", 0, 1);
        // Панель с кнопками
        Panel panel = new Panel();
        Panel panel2 = new Panel();
        Button buttonStep = new Button("ХОДИТЬ");
        Button buttonConsole = new Button("КОНСОЛЬ");
        Button buttonWings = new Button("ВОИНЫ");
        Button buttonExit = new Button("ВЫХОД");
        AtomicInteger count = new AtomicInteger();
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
                    if(good > bad){ log += "ПОБЕДИЛО ДОБРО!\n"; }
                    else { log += "ПОБЕДИЛО ЗЛО!\n"; }
                }

                   console.append(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")));
                   console.append("ХОД № "+count.incrementAndGet()+"\n");
                   console.append(log);
                   log = ""; 

                units.sort((t1, t2) -> t1.getPriority() - t2.getPriority());
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        buttonConsole.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(console.isVisible() & right.isVisible()){
                    console.setVisible(false);
                    frame.setSize(1200, 500); 
                }
                else if(!console.isVisible() & right.isVisible()){
                    console.setVisible(true);
                    frame.setSize(1200, 750); 
                }
                else if(!console.isVisible() & !right.isVisible()){
                    console.setVisible(true);
                    frame.setSize(500, 750); 
                }
                else if(console.isVisible() & !right.isVisible()){
                    console.setVisible(false);
                    frame.setSize(500, 500); 
                }
                
            }
        });

        buttonWings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!right.isVisible()){
                    right.setVisible(true);
                    left.setVisible(true);
                    frame.setSize(1200, 500); 
                }
                else if(right.isVisible()){
                    right.setVisible(false);
                    left.setVisible(false);
                    frame.setSize(500, 500); 
                }
            }
        });

        table.setSize(500, 500);
        panel.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout());
        right.setSize(349,500);
        right.setVisible(false);
        left.setSize(349, 500);
        left.setVisible(false);
        console.setVisible(false);
        frame.add(table, BorderLayout.CENTER);
        frame.add(left, BorderLayout.WEST);
        frame.add(right, BorderLayout.EAST);
        panel.add(buttonStep, BorderLayout.WEST);
        panel2.add(buttonWings, BorderLayout.WEST);
        panel2.add(buttonConsole, BorderLayout.EAST);
        panel.add(panel2, BorderLayout.CENTER);
        panel.add(buttonExit, BorderLayout.EAST);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(console, BorderLayout.SOUTH);
        frame.setSize(500, 500);
        frame.setExtendedState((int) Frame.CENTER_ALIGNMENT);
        frame.setVisible(true);
       
        for (Actor n : units) {
            table.setValue(n.getX(), n.getY(), n.getIcon());
            if(n.getTeam()==true){left.setValue(0, n.getY(), n.getInfo());}
            if(n.getTeam()==false){right.setValue(0, n.getY(), n.getInfo());}
        }
        //console.setValue(0, 0, "Добро пожаловать в игру Снежный Барс ))");
        console.setBackground(Color.BLACK);
        console.setForeground(Color.GREEN);
        console.setText("Добро пожаловать в игру!\n");
        console.setEditable(false);
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
