// Добрый Оруженосец - расширяет абстрактный класс Оруженосец
package ms.aoe.units;

import ms.aoe.abstr.Servant;

public class Squire extends Servant {

    public Squire(boolean team, int id, String name, int x, int y) {
        super(team, id, "Эсквайр", name, x, y);
    }

}

