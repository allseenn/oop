// Оруженосец - абстрактный класс расширяет высшый класс Актер
package ms.aoe.units;

public abstract class AbstrSquire extends AbstrActor{
    int pickupSpeed = 1; // Скорость подбирания стрел
    public AbstrSquire(String name, int x, int y, int ammo, int armor, int force) {
        super(name, x, y, ammo, armor, force);
        //TODO Auto-generated constructor stub
    }
    
}
