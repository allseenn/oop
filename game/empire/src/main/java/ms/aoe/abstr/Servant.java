// Оруженосец - абстрактный класс расширяет высшый класс Актер
package ms.aoe.abstr;

public abstract class Servant extends Actor {
    int pickupSpeed = 1; // Скорость подбирания стрел
    public Servant(boolean team, int id, String staff, String name, int x, int y) {
        super(team, id, staff, name, x, y, 10, 0, 0);
    }

}
