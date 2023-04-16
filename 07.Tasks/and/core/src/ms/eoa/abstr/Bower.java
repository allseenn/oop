// Стрелок - абстрактный класс расширяет высшый класс Актер
package ms.eoa.abstr;

import java.util.LinkedList;

public abstract class Bower extends Actor {

    @Override
    public void step(LinkedList<Actor>units) {}


    public Bower(boolean team, int priority, String icon, String rank, String name, int x, int y) {
        super(team, priority, icon, rank, name, x, y, BowerAmmo, BowerArmor, BowerForce);

    }

}
