// Маги - абстрактный класс расширяет высшый класс Актер
package ms.aoe.abstr;

public abstract class Magican extends Actor {

    boolean visibility = true;

    public Magican(boolean team, int id, String staff, String name, int x, int y) {
        super(team, id, staff, name, x, y, 100, 0, 0);

    }

}
