// Злой Шестерка - расширяет абстрактный класс Оруженосец
package ms.aoe.units;

import ms.aoe.abstr.Servant;

public class Punk extends Servant {
    public Punk(boolean team, int id, String name, int x, int y) {
        super(team, id, "Шестерка", name, x, y);
    }
}
