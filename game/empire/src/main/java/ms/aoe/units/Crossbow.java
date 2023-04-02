// Добрый Стрелок - расширяет абстрактный класс Стрелок
package ms.aoe.units;
import ms.aoe.abstr.Actor;
import ms.aoe.abstr.Bower;

import java.util.LinkedList;

public class Crossbow extends Bower {
    // Переопределяем функцию хода
    @Override
    public void step(LinkedList<Actor> units) {
        if(getArrow(units)> 0){
            String myName = this.getName(); //Мое имя
            String myRank = this.getRank(); // Мой ранг
            int myForce = this.getForce(); // Моя сила
            int myArmor = this.getArmor(); // Моя броня

            int enemyIndex = findEnemy(units);  // Узнаем индекс ближайшего врага
            String enemyName = units.get(enemyIndex).getName(); // Имя врага
            String enemyRank = units.get(enemyIndex).getRank(); // Ранг врага
            int enemyArmor = units.get(enemyIndex).getArmor(); // Броня врага
            int enemyHp = units.get(enemyIndex).getHp(); // Здоровье врага
            int [] damage = damage(myForce, myArmor, enemyArmor, enemyHp);
            if(enemyIndex <Integer.MAX_VALUE-1){  // Если index врага меньше чем максимальное число, то стреляем
                if (damage[2] == 0){
                    units.get(enemyIndex).setArmor(0);
                    units.get(enemyIndex).setHp(0);
                    System.out.println(myRank+" "+myName+" убил "+enemyRank+" "+enemyName+", забрав броню имеет "+damage[0]);
                    return;
                }
                else {
                    units.get(enemyIndex).setArmor(damage[1]);
                    units.get(enemyIndex).setHp(damage[2]);
                    System.out.println(myRank+" "+myName+" ранил " +enemyRank+" "+enemyName+", осталось брони "+damage[1]+", здоровья "+damage[2]);
                    return;
                }

            }
            else if (enemyIndex > Integer.MAX_VALUE-5) {
                System.out.println("Нет живого врага");
                return;
            }
        }
        System.out.println(this.getRank()+" "+this.getName()+" Не может найти стрел :-(");
    }
    // Функция расчета ущерба врага
    public int[] damage(int myForce, int myArmor, int enemyArmor, int enemyHp){
        int[] numbers = new int[3];
        numbers[0] = myArmor;
        // Если моя сила меньше или равна брони противника, то повреждаем только броню
        if (myForce <= enemyArmor) {numbers[1]=(enemyArmor-myForce); numbers[2]=enemyHp;}
        // Если моя сила меньше суммы брони и здоровья противника, то обнуляем броню и уменьшаем здоровье на остаток сил
        else if (myForce < (enemyArmor+enemyHp)){
            numbers[1]=0;
            numbers[2]=enemyHp-(myForce-enemyArmor);
        }
        // Если моя сила больше суммы брони и здоровья противника, то обнуляем все, и бонус броней противника к моей броне
        else if (myForce >= (enemyArmor+enemyHp)){
            numbers[0] = myArmor+enemyArmor+10;
            numbers[1]=0;
            numbers[2]=0;
        }
        return numbers;
    }

    // Функция поиска и уничтожения цели
    public int findEnemy(LinkedList<Actor> units){
        int closeEnemy = Integer.MAX_VALUE;         // Индекс ближайшего врага
        double minDist = Integer.MAX_VALUE;         // минимальная дистанция до врага
        double curDist = Integer.MAX_VALUE;         // Текущая проверочная дистанция до врага
        for (int i = 0; i < units.size(); i++){     // Пробегаем всех юнитов
            // Если это враг(злой) и его здоровье больше 0, т.е. он живой
            if(units.get(i).getTeam() == false && units.get(i).getHp() > 0){
                // то рассчитываем расстояние от себя до текущего врага и заносим результат в текущею дистанцию
                curDist = Math.sqrt((this.getX() - units.get(i).getX())*(this.getX() - units.get(i).getX()) + (this.getY() - units.get(i).getY())*(this.getY() - units.get(i).getY()));
                if(curDist < minDist){minDist = curDist; closeEnemy = i;}
            }
        }
        return closeEnemy;
    }
    // функция проверки стрел у Эскваеров
    public int getArrow(LinkedList<Actor> units){
        int arrow = 0;
        for (int i = 0; i < units.size(); i++) {                // Пробегаем всех юнитов
            // Если Эскваера И есть стрелы И он живой
            if(units.get(i).getRank().equals(SquireRank) && units.get(i).getAmmo()> 0 && units.get(i).getHp() > 0){
                units.get(i).setAmmo(units.get(i).getAmmo()-1); // Забираем одну стрелу
                System.out.println(CrossbowRank+" "+units.get(i).getName()+" передал стрелу "+this.getRank()+" "+this.getName()+", оствив "+ units.get(i).getAmmo());
                arrow = 1;                                      // Зажимаем в руке
                return arrow;                                   // Возвращаем в фнкцию step
            }
        }
        // Случай когда у Эсквайера нет стрел
        if(this.getAmmo() > 0) {                // Проверяем свой колчан
            this.setAmmo(this.getAmmo()-1);     // Достаем из колчана стрелу
            System.out.println(this.getRank()+" "+this.getName()+" не нашел "+CrossbowRank+" взял свою из колчана, в нем осталось "+this.getAmmo());
            arrow = 1;                          // Зажимаем в кулак
            return arrow;                       // Возвращаем в функцию step
        }
        // Если стрел нигде нет, то возвращаем ноль
        return 0;
    }
    public Crossbow(boolean team, int id, String name, int x, int y) {
        super(team, id, CrossbowRank, name, x, y);
    }

}
