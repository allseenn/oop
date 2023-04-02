// Стрелок - абстрактный класс расширяет высшый класс Актер
package ms.aoe.abstr;

import java.util.LinkedList;

public abstract class Bower extends Actor {

    int accuracy=BowerAccuracy; // точность стрельбы
    // int range=10; // дальность стрельбы
    @Override
    public void step(LinkedList<Actor>units) {}

    @Override
    public String toString() {
        return super.toString()+", Меткость "+accuracy;
    }

    public Bower(boolean team, int id, String staff, String name, int x, int y) {
        super(team, id, staff, name, x, y, BowerAmmo, BowerArmor, BowerForce);

    }

}
