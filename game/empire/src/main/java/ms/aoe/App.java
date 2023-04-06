package ms.aoe;
import java.util.*;
import ms.aoe.abstr.Actor;
import ms.aoe.units.*;
public class App implements Colorit{
    public static void main(String[] args) {
        // Создание двух армий
        // int teamSize = 10; // количество воинов в одной команде
        LinkedList<Actor> units = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < teamSize; i++) {
            switch (random.nextInt(4)) {
                case 0: // (команда, индекс, плохое имя, X, Y)
                    units.add(new Bowman(false, 20, BadNames(i), i, teamSize-1));
                    break;
                case 1:
                    units.add(new Butcher(false, 21, BadNames(i), i, teamSize-1));
                    break;
                case 2:
                    units.add(new Witch(false, 22, BadNames(i), i, teamSize-1));
                    break;
                default:
                    units.add(new Punk(false, 23, BadNames(i), i, teamSize-1));
            }
        }
        for (int i = teamSize; i < teamSize*2; i++) {
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
        units.sort((t1, t2) -> t1.getPriority()-t2.getPriority());
        // Цигл игры (ядро)
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        int good, bad;
        String help =
        YELLOW+
        "Стратегическая игра Mortal Control\n"+
        "Справочная информация по клавишам\n"+
        "q - выход из игры и завершение\n"+
        "u - отобразить список всех юнитов\n"+
        "s - совершить ход всеми живыми юнитами\n"+
        "h - эта справка\n"+
        RST;
        System.out.printf(CLEAN + help + "Скорее начинай, жми желанную клавишу: ");
        do
        {
            good = 0; // сбрасываем счетчик хороших в каждом цикле
            bad = 0; // сброс счетчика плохих в новом цикле перед новым ходом
            for (Actor n : units) {
                if (n.getTeam() == true && n.getHp() > 0) {good++;}  // Подсчет хороших
                else if(n.getTeam() == false && n.getHp() > 0) {bad++; } // Подсчет плохих
            } // Вывод меню с результатами игры и (в)ыходом и (х)одом
            String user = input.nextLine(); // Выбор пользователя с клавы
            System.out.println(CLEAN); System.out.flush();
            if (good == 0 || bad == 0) {quit = true;} // если хорошие или плохие мертвы, то выход
            else if (user.equals("q")) {quit = true;} // выход если юзер ввел q
            else if (user.equals("u")) {units.forEach(n-> {if(n.getHp()>0) {System.out.println(n);}});} // вывод списка живых units
            else if (user.equals("s")) {units.forEach(n -> {if(n.getHp()>0) {n.step(units);}});}
            else if (user.equals("h")) {System.out.println(help);}
            else {System.out.println("Ввод не соответствует образцу!");}
            System.out.printf(BLUE+"Good: "+good+RST+RED+" BadAs: "+bad+RST+" q(uit), u(nits), s(tep), h(elp): ");
        } // выход из цикла игры
        while(!quit);
        // Определение помедителя
        if(good > bad){ System.out.println("\nПобедило "+BLUE+"ДОБРО!"+RST); }
        else { System.out.println("\nПобедило "+RED+"ЗЛО!"+RST); }

    }
    public static String BadNames(int i)
    {
        NamesBad[] names = NamesBad.values();
        return RED+names[i].toString()+RST;
    }
    public static String GoodNames(int i)
    {
        NamesGood[] names = NamesGood.values();
        return BLUE+names[i].toString()+RST;
    }
}
