// Солдат - абстрактный класс расширяет высшый класс Актер
package ms.aoe.abstr;
import java.util.LinkedList;

import ms.aoe.Control;

public abstract class Soldier extends Actor {
    @Override
    public void step(LinkedList<Actor> units){
        int i = findEnemy(units);
        if(i < 999){
            Double X = Math.sqrt(((this.getX()+1) - units.get(i).getX())*((this.getX()+1) - units.get(i).getX()) + (this.getY() - units.get(i).getY())*(this.getY() - units.get(i).getY()));
            Double Y = Math.sqrt((this.getX() - units.get(i).getX())*(this.getX() - units.get(i).getX()) + ((this.getY()+1) - units.get(i).getY())*((this.getY()+1) - units.get(i).getY()));
            Double x = Math.sqrt(((this.getX()-1) - units.get(i).getX())*((this.getX()-1) - units.get(i).getX()) + (this.getY() - units.get(i).getY())*(this.getY() - units.get(i).getY()));
            Double y = Math.sqrt((this.getX() - units.get(i).getX())*(this.getX() - units.get(i).getX()) + ((this.getY()-1) - units.get(i).getY())*((this.getY()-1) - units.get(i).getY()));
            Double min = Math.min(Math.min(Math.min(X, Y), x), y);
            if(min.equals(X)){
                Control.xX = this.getX();
                Control.yY = this.getY();
                this.setX(this.getX()+1);}
            if(min.equals(Y)){
                Control.xX = this.getX();
                Control.yY = this.getY();
                this.setY(this.getY()+1);}
            if(min.equals(x)){
                Control.xX = this.getX();
                Control.yY = this.getY();
                this.setX(this.getX()-1);}
            if(min.equals(y)){
                Control.xX = this.getX();
                Control.yY = this.getY();
                this.setY(this.getY()-1);}
            min = Math.sqrt((this.getX() - units.get(i).getX())*(this.getX() - units.get(i).getX()) + (this.getY() - units.get(i).getY())*(this.getY() - units.get(i).getY()));
            if(min < 2){
              // Если index врага меньше чем максимальное число, то стреляем
                String myName = this.getName();
                String myRank = this.getRank();
                int myForce = this.getForce();
                int myArmor = this.getArmor();
                String enemyName = units.get(i).getName(); // Имя врага
                String enemyRank = units.get(i).getRank(); // Ранг врага
                int enemyArmor = units.get(i).getArmor(); // Броня врага
                int enemyHp = units.get(i).getHp(); // Здоровье врага
                int [] damage = damage(myForce, myArmor, enemyArmor, enemyHp);

                if (damage[2] == 0){ // Если hp равен нулю
                    units.get(i).setArmor(0);
                    units.get(i).setHp(0);
                    this.setArmor(damage[0]);
                    Control.log += myRank+" "+myName+" зарубил "+enemyRank+" "+enemyName+", забрав броню имеет "+damage[0]+"\n";
                    return;
                }
                else { // если hp не равен нулю
                    units.get(i).setArmor(damage[1]);
                    units.get(i).setHp(damage[2]);
                    Control.log += myRank+" "+myName+" ранил " +enemyRank+" "+enemyName+", осталось брони "+damage[1]+", здоровья "+damage[2]+"\n";
                    return;
                }

            }

        }
        else if (i == 999){ // Если findEnemy вернул 999, то нет врага
            Control.log += "Нет живого противника"+"\n";
            return;
        }
    }

    public Soldier(boolean team, int priority, String icon, String rank, String name, int x, int y) {
        super(team, priority, icon, rank, name, x, y, SoldierAmmo, SoldierArmor, SoldierForce);
    }

}
