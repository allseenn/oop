// Солдат - абстрактный класс расширяет высший класс Актер
package ms.aoe.abstr;
import java.util.LinkedList;

import ms.aoe.Control;

public abstract class Soldier extends Actor {
    String myName = this.getName(); // мое имя
    String myRank = this.getRank(); // мое звание
    int myForce = this.getForce(); // моя сила
    int myArmor = this.getArmor(); // мое оружие
    @Override
    public void step(LinkedList<Actor> units){
        int enemyIndex = findEnemy(units);
        int friendIndex = findFriend(units);
        if(enemyIndex < 999){

            Double X = Math.sqrt(((this.getX()+1) - units.get(enemyIndex).getX())*((this.getX()+1) - units.get(enemyIndex).getX()) + (this.getY() - units.get(enemyIndex).getY())*(this.getY() - units.get(enemyIndex).getY()));
            Double Y = Math.sqrt((this.getX() - units.get(enemyIndex).getX())*(this.getX() - units.get(enemyIndex).getX()) + ((this.getY()+1) - units.get(enemyIndex).getY())*((this.getY()+1) - units.get(enemyIndex).getY()));
            Double x = Math.sqrt(((this.getX()-1) - units.get(enemyIndex).getX())*((this.getX()-1) - units.get(enemyIndex).getX()) + (this.getY() - units.get(enemyIndex).getY())*(this.getY() - units.get(enemyIndex).getY()));
            Double y = Math.sqrt((this.getX() - units.get(enemyIndex).getX())*(this.getX() - units.get(enemyIndex).getX()) + ((this.getY()-1) - units.get(enemyIndex).getY())*((this.getY()-1) - units.get(enemyIndex).getY()));
            Double min = Math.min(Math.min(Math.min(X, Y), x), y);
            if(min.equals(X)){
                if (units.get(friendIndex).getX()==this.getX()+1){min = Y;} // если на пути друг, то обходим
                else{
                Control.console.append(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")));
                Control.console.append(myRank+" "+myName+" идет на восток\n");
                Control.table.setValue(this.getX(),this.getY(), "");
                this.setX(this.getX()+1);}}
            if(min.equals(Y)){
                if (units.get(friendIndex).getY()==this.getY()+1){min = x;} // если на пути друг, то обходим
                else{
                Control.console.append(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")));
                Control.console.append(myRank+" "+myName+" идет на север\n");
                Control.table.setValue(this.getX(),this.getY(), "");
                this.setY(this.getY()+1);}}
            if(min.equals(x)){
                if (units.get(friendIndex).getX()==this.getX()-1){min = y;} // если на пути друг, то обходим
                else{
                Control.console.append(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")));
                Control.console.append(myRank+" "+myName+" идет на запад\n");
                Control.table.setValue(this.getX(),this.getY(), "");
                this.setX(this.getX()-1);}}
            if(min.equals(y)){
                if (units.get(friendIndex).getY()==this.getY()-1){min = X;} // если на пути друг, то обходим
                else{
                Control.console.append(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")));
                Control.console.append(myRank+" "+myName+" идет на юг\n");
                Control.table.setValue(this.getX(),this.getY(), "");
                this.setY(this.getY()-1);}}
            min = Math.sqrt((this.getX() - units.get(enemyIndex).getX())*(this.getX() - units.get(enemyIndex).getX()) + (this.getY() - units.get(enemyIndex).getY())*(this.getY() - units.get(enemyIndex).getY()));
            if(min < 1.7){
              // Если index врага меньше чем максимальное число, то колем
                String enemyName = units.get(enemyIndex).getName(); // Имя врага
                String enemyRank = units.get(enemyIndex).getRank(); // Ранг врага
                int enemyArmor = units.get(enemyIndex).getArmor(); // Броня врага
                int enemyHp = units.get(enemyIndex).getHp(); // Здоровье врага
                int [] damage = damage(myForce, myArmor, enemyArmor, enemyHp);

                if (damage[2] == 0){ // Если hp равен нулю
                    units.get(enemyIndex).setArmor(0);
                    units.get(enemyIndex).setHp(0);
                    this.setArmor(damage[0]);
                    Control.console.append(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")));
                    Control.console.append(myRank+" "+myName+" зарубил "+enemyRank+" "+enemyName+", забрав броню имеет "+damage[0]+"\n");
                    return;
                }
                else { // если hp не равен нулю
                    units.get(enemyIndex).setArmor(damage[1]);
                    units.get(enemyIndex).setHp(damage[2]);
                    Control.console.append(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")));
                    Control.console.append(myRank+" "+myName+" ранил " +enemyRank+" "+enemyName+", осталось брони "+damage[1]+", здоровья "+damage[2]+"\n");
                    return;
                }

            }

        }
        else if (enemyIndex == 999){ // Если findEnemy вернул 999, то нет врага
            Control.console.append(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")));
            Control.console.append(myRank+" "+myName+" не нашел противника"+"\n");
            return;
        }
    }

    public Soldier(boolean team, int priority, String icon, String rank, String name, int x, int y) {
        super(team, priority, icon, rank, name, x, y, SoldierAmmo, SoldierArmor, SoldierForce);
    }

}
