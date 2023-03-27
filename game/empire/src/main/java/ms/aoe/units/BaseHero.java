// Основной родительский класс
package ms.aoe.units;
import java.util.Random;
public class BaseHero {
    private int group, id, x, y, hp, ammo, armor, force;

    @Override
    public String toString() {
        return "group:"+group+", id:"+id+", x:"+x+", y:"+y+", hp:"+hp+", ammo:"+ammo+", armor:"+armor+", force:"+force;
    }

    public int[] getFields(){
        int[] fields = new int[8];
        fields[0] = this.group;
        fields[1] = this.id;
        fields[2] = this.x;
        fields[3] = this.y;
        fields[4] = this.hp;
        fields[5] = this.ammo;
        fields[6] = this.armor;
        fields[7] = this.force;
        return fields;
    }
    
    public BaseHero(int group, int x, int y, int ammo, int armor, int force){
        this.group = group;
        this.id = new Random().nextInt(9999);
        this.x = x;
        this.y = y;
        this.hp = 100;
        this.ammo = ammo;
        this.armor = armor;
        this.force = force;
    }

}
