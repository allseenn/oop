// Стрелок - абстрактный класс расширяет высшый класс Актер 
package ms.aoe.units;

public abstract class AbstrBow extends AbstrActor{
    int accuracy=75; // точность стрельбы
    int range=10; // дальность стрельбы



    public AbstrBow(String name, int x, int y, int ammo, int armor, int force) {
        super(name, x, y, ammo, armor, force);

    }
    
}
