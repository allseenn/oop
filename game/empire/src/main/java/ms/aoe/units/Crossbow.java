// Добрый Стрелок - расширяет абстрактный класс Стрелок
package ms.aoe.units;
import ms.aoe.abstr.Actor;
import ms.aoe.abstr.Bower;
import ms.aoe.Control;
import java.util.LinkedList;

public class Crossbow extends Bower {
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
                if (damage[2] == 0){
                    units.get(enemyIndex).setArmor(0);
                    units.get(enemyIndex).setHp(0);
                    this.setArmor(damage[0]);
                    Control.log += myRank+" "+myName+" убил "+enemyRank+" "+enemyName+", забрав броню имеет "+damage[0]+"\n";
                    return;
                }
                else {
                    units.get(enemyIndex).setArmor(damage[1]);
                    units.get(enemyIndex).setHp(damage[2]);
                    Control.log += myRank+" "+myName+" ранил " +enemyRank+" "+enemyName+", осталось брони "+damage[1]+", здоровья "+damage[2]+"\n";
                    return;
                }

            }
            else if (enemyIndex == 999) {
                Control.log += "Нет живого зла"+"\n";
                return;
            }
        }
        Control.log += this.getRank()+" "+this.getName()+" Не может найти стрел :-("+"\n";
    }

    // функция проверки стрел у Эскваеров
    public int getArrow(LinkedList<Actor> units){
        int arrow = 0;
        for (int i = 0; i < units.size(); i++) {                // Пробегаем всех юнитов
            // Если Эскваера И есть стрелы И он живой
            if(units.get(i).getRank().equals(SquireRank) && units.get(i).getAmmo()> 0 && units.get(i).getHp() > 0){
                units.get(i).setAmmo(units.get(i).getAmmo()-1); // Забираем одну стрелу
                Control.log += CrossbowRank+" "+units.get(i).getName()+" передал стрелу "+this.getRank()+" "+this.getName()+", оствив "+ units.get(i).getAmmo()+"\n";
                arrow = 1;                                      // Зажимаем в руке
                return arrow;                                   // Возвращаем в фнкцию step
            }
        }
        // Случай когда у Эсквайера нет стрел
        if(this.getAmmo() > 0) {                // Проверяем свой колчан
            this.setAmmo(this.getAmmo()-1);     // Достаем из колчана стрелу
            Control.log += this.getRank()+" "+this.getName()+" не нашел "+CrossbowRank+" взял свою из колчана, в нем осталось "+this.getAmmo()+"\n";
            arrow = 1;                          // Зажимаем в кулак
            return arrow;                       // Возвращаем в функцию step
        }
        // Если стрел нигде нет, то возвращаем ноль
        return 0;
    }
    public Crossbow(boolean team, int priority, String name, int x, int y) {
        super(team, priority, CrossbowIcon, CrossbowRank, name, x, y);
    }

}
