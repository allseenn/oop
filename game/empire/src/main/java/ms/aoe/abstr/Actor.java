// Актер - Высший абстрактный класс
package ms.aoe.abstr;
import ms.aoe.Interface;
import java.util.LinkedList;

public abstract class Actor implements Interface {
    private Boolean team;
    private Integer priority, x, y, hp, ammo, armor, force;
    private String name, rank;
    
    @Override
    public String toString() {
        return priority +" "+rank+" "+name+", ("+x+"; "+y+"), Здоров "+hp+", БП "+ammo+", Броня "+armor+", Сила "+force;
    }

    @Override
    public void step(LinkedList<Actor> units) { }

    @Override
    public int findFriend(LinkedList<Actor> units) { return 0; }

    @Override
    public int findEnemy(LinkedList<Actor> units){
        int closeEnemy = 999;         // Индекс ближайшего врага
        double minDist = 999;         // минимальная дистанция до врага
        double curDist = 999;         // Текущая проверочная дистанция до врага
        for (int i = 0; i < units.size(); i++){     // Пробегаем всех юнитов
            // Если это враг(добрый) и его здоровье больше 0, т.е. он живой
            if(units.get(i).getTeam() != this.getTeam() && units.get(i).getHp() > 0){
                // то рассчитываем расстояние от себя до текущего врага и заносим результат в текущею дистанцию
                curDist = Math.sqrt((this.getX() - units.get(i).getX())*(this.getX() - units.get(i).getX()) + (this.getY() - units.get(i).getY())*(this.getY() - units.get(i).getY()));
                if(curDist < minDist){minDist = curDist; closeEnemy = i;}
            }
        }
       return closeEnemy;
    }
    @Override
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

    public boolean getTeam(){return this.team;}
    public int getPriority(){return this.priority;}
    public String getRank(){return this.rank;}
    public String getName(){return this.name;}
    public int getX(){ return this.x;}
    public int getY(){ return this.y;}
    public int getHp(){ return this.hp;}
    public int getAmmo(){ return this.ammo;}
    public int getArmor(){ return this.armor;}
    public int getForce(){ return this.force;}
    public void setTeam(boolean team){this.team=team;}
    public void setPriority(int priority){this.priority = priority;}
    public void setRank(String rank){this.name=rank;}
    public void setName(String name){this.name=name;}
    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}
    public void setHp(int hp){this.hp=hp;}
    public void setAmmo(int ammo){this.ammo=ammo;}
    public void setArmor(int armor){this.armor=armor;}
    public void setForce(int force){this.force=force;}

    public Actor(boolean team, int priority, String rank, String name, int x, int y, int ammo, int armor, int force){
        this.team = team;
        this.priority = priority;
        this.rank = rank;
        this.name = name;
        this.x = x;
        this.y = y;
        this.hp = 100;
        this.ammo = ammo;
        this.armor = armor;
        this.force = force;

    }

}
