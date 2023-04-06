// Злой Снайпер - расширяет абстрактный класс Стрелок
package ms.aoe.units;
import java.util.LinkedList;
import ms.aoe.abstr.Actor;
import ms.aoe.abstr.Bower;

public class Bowman extends Bower {

    // Переопределяем функцию хода
    @Override
    public void step(LinkedList<Actor> units) {
        if(getArrow(units)> 0){ // Если нашли стрелу
            // Мои параметры
            String myName = this.getName(); //Мое имя
            String myRank = this.getRank(); // Мой ранг
            int myForce = this.getForce(); // Моя сила
            int myArmor = this.getArmor(); // Моя броня
            // Параметры врага
            int enemyIndex = findEnemy(units);  // Узнаем индекс ближайшего врага
            if(enemyIndex < 999){  // Если index врага меньше чем максимальное число, то стреляем
                String enemyName = units.get(enemyIndex).getName(); // Имя врага
                String enemyRank = units.get(enemyIndex).getRank(); // Ранг врага
                int enemyArmor = units.get(enemyIndex).getArmor(); // Броня врага
                int enemyHp = units.get(enemyIndex).getHp(); // Здоровье врага
                int [] damage = damage(myForce, myArmor, enemyArmor, enemyHp);

                if (damage[2] == 0){ // Если hp равен нулю
                    units.get(enemyIndex).setArmor(0);
                    units.get(enemyIndex).setHp(0);
                    System.out.println(myRank+" "+myName+" убил "+enemyRank+" "+enemyName+", забрав броню имеет "+damage[0]);
                    return;
                }
                else { // если hp не равен нулю
                    units.get(enemyIndex).setArmor(damage[1]);
                    units.get(enemyIndex).setHp(damage[2]);
                    System.out.println(myRank+" "+myName+" ранил " +enemyRank+" "+enemyName+", осталось брони "+damage[1]+", здоровья "+damage[2]);
                    return;
                }

            }
            else if (enemyIndex == 999){ // Если findEnemy вернул 999, то нет врага
                System.out.println("Нет живого врага");
                return;
            }
        } // Если нет стрел
        System.out.println(this.getRank()+" "+this.getName()+" Не может найти стрел :-(");
    }
    // Функция расчета ущерба врага


    // функция проверки стрел у Шестерок
    public int getArrow(LinkedList<Actor> units){
        int arrow = 0;
        for (int i = 0; i < units.size(); i++) {                // Пробегаем всех юнитов
            // Если Шестерка И есть стрелы И он живой
            if(units.get(i).getRank().equals(PunkRank) && units.get(i).getAmmo()> 0 && units.get(i).getHp() > 0){
                units.get(i).setAmmo(units.get(i).getAmmo()-1); // Забираем одну стрелу
                System.out.println(PunkRank+" "+units.get(i).getName()+" передал 1 стрелу "+this.getRank()+" "+this.getName()+", оствив "+ units.get(i).getAmmo());
                arrow = 1;                                      // Зажимаем в руке
                return arrow;                                   // Возвращаем в фнкцию step
            }
        }
        // Случай когда у Шестерок нет стрел
        if(this.getAmmo() > 0) {                // Проверяем свой колчан
            this.setAmmo(this.getAmmo()-1);     // Достаем из колчана стрелу
            System.out.println(this.getRank()+" "+this.getName()+" не нашел "+PunkRank+" взял свою из колчана, в нем осталось "+this.getAmmo());
            arrow = 1;                          // Зажимаем в кулак
            return arrow;                       // Возвращаем в функцию step
        }
        // Если стрел нигде нет, то возвращаем ноль
        return 0;
    }
    public Bowman(boolean team, int id, String name, int x, int y) {
        super(team, id, BowmanRank, name, x, y);

    }

}
