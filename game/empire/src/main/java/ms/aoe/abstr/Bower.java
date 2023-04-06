// Стрелок - абстрактный класс расширяет высшый класс Актер
package ms.aoe.abstr;

import java.util.LinkedList;

public abstract class Bower extends Actor {

    @Override
    public void step(LinkedList<Actor>units) {}


    public Bower(boolean team, int id, String staff, String name, int x, int y) {
        super(team, id, staff, name, x, y, BowerAmmo, BowerArmor, BowerForce);

    }

}
