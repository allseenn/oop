// Актер - Высший абстрактный класс
package ms.aoe.abstr;
import ms.aoe.Colorit;
import ms.aoe.Interface;
import java.util.LinkedList;

public abstract class Actor implements Interface {
    private Boolean team;
    private Integer id, x, y, hp, ammo, armor, force;
    private String name, rank;
    @Override
    public String toString() {
        return team.toString()+": "+id+"). "+rank+" "+name+", ("+x+"; "+y+"), Здоров "+hp+", БП "+ammo+", Броня "+armor+", Сила "+force;
    }

    @Override
    public void step(LinkedList<Actor> units) { }

    public boolean getTeam(){return this.team;}
    public int getId(){return this.id;}
    public String getRank(){return this.rank;}
    public String getName(){return this.name;}
    public int getX(){ return this.x;}
    public int getY(){ return this.y;}
    public int getHp(){ return this.hp;}
    public int getAmmo(){ return this.ammo;}
    public int getArmor(){ return this.armor;}
    public int getForce(){ return this.force;}
    public void setTeam(boolean team){this.team=team;}
    public void setId(int id){this.id=id;}
    public void setRank(String rank){this.name=rank;}
    public void setName(String name){this.name=name;}
    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}
    public void setHp(int hp){this.hp=hp;}
    public void setAmmo(int ammo){this.ammo=ammo;}
    public void setArmor(int armor){this.armor=armor;}
    public void setForce(int force){this.force=force;}

    public Actor(boolean team, int id, String rank, String name, int x, int y, int ammo, int armor, int force){
        this.team = team;
        this.id = id;
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
