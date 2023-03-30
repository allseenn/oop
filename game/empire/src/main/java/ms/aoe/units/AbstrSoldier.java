// Солдат - абстрактный класс расширяет высшый класс Актер
package ms.aoe.units;

public abstract class AbstrSoldier extends AbstrActor{
    int speed=5; // скорость ходьбы

    public AbstrSoldier(String name, int x, int y, int ammo, int armor, int force) {
        super(name, x, y, ammo, armor, force);
    }
    
}
