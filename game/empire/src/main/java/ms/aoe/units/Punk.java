// Злой Шестерка - расширяет абстрактный класс Оруженосец
package ms.aoe.units;

import ms.aoe.abstr.Servant;

public class Punk extends Servant {
    public Punk(boolean team, int priority, String name, int x, int y) {
        super(team, priority, PunkIcon, PunkRank, name, x, y);
    }
}
