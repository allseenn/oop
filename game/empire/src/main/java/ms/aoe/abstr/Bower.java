// Стрелок - абстрактный класс расширяет высшый класс Актер
package ms.aoe.abstr;

import java.util.LinkedList;

public abstract class Bower extends Actor {

    int accuracy=75; // точность стрельбы
    // int range=10; // дальность стрельбы
    @Override
    public String step(LinkedList<Actor>units) {return super.toString();}

    @Override
    public String toString() {
        return super.toString()+", Меткость "+accuracy;
    }

    public Bower(boolean team, int id, String staff, String name, int x, int y) {
        super(team, id, staff, name, x, y, 55, 50, 50);

    }

}
