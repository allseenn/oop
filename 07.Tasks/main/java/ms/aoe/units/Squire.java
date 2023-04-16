// Добрый Эсквайр - расширяет абстрактный класс Оруженосец
package ms.aoe.units;

import ms.aoe.abstr.Servant;

public class Squire extends Servant {

    public Squire(boolean team, int priority, String name, int x, int y) {
        super(team, priority, SquireIcon, SquireRank, name, x, y);
    }

}

