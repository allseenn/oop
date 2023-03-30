// Актер - Высший абстрактный класс
package ms.aoe.units;
import java.util.Random;
public abstract class AbstrActor implements ActInterface{
    private int id, x, y, hp, ammo, armor, force;
    private String name;

    @Override
    public String toString() {
        return "Name:"+name+", id:"+id+", x:"+x+", y:"+y+", hp:"+hp+", ammo:"+ammo+", armor:"+armor+", force:"+force;
    }
    
    @Override
    public void step() {}

    public String getName(){return this.name;}
    public int getId(){ return this.id;}
    public int getX(){ return this.x;}
    public int getY(){ return this.y;}
    public int getHp(){ return this.hp;}
    public int getAmmo(){ return this.ammo;}
    public int getArmor(){ return this.armor;}
    public int getForce(){ return this.force;}
    
    public void setName(String name){this.name=name;}
    public void getId(int id){this.id=id;}
    public void getX(int x){this.x=x;}
    public void getY(int y){this.y=y;}
    public void getHp(int hp){this.hp=hp;}
    public void getAmmo(int ammo){this.ammo=ammo;}
    public void getArmor(int armor){this.armor=armor;}
    public void getForce(int force){this.force=force;}

    public AbstrActor(String name, int x, int y, int ammo, int armor, int force){
        this.name = name;
        this.id = new Random().nextInt(9999);
        this.x = x;
        this.y = y;
        this.hp = 100;
        this.ammo = ammo;
        this.armor = armor;
        this.force = force;
    }

}
