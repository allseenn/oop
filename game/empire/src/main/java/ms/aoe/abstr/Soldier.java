// Солдат - абстрактный класс расширяет высшый класс Актер
package ms.aoe.abstr;

public abstract class Soldier extends Actor {
    int speed=5; // скорость ходьбы

    public Soldier(boolean team, int id, String staff, String name, int x, int y) {
        super(team, id, staff, name, x, y, 999, 100, 100);
    }

}
