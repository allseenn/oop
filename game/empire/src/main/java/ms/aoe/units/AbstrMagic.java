// Маги - абстрактный класс расширяет высшый класс Актер
package ms.aoe.units;

public abstract class AbstrMagic extends AbstrActor{

    boolean visibility = true;

    public AbstrMagic(String name, int x, int y, int ammo, int armor, int force) {
        super(name, x, y, ammo, armor, force);
        //TODO Auto-generated constructor stub
    }
    
}
