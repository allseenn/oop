// Злой Колдун - расширяет абстрактный класс Волшебник

package ms.aoe.units;

import ms.aoe.abstr.Magican;

public class Witch extends Magican {

    public Witch(boolean team, int priority, String name, int x, int y) {
        super(team, priority, WitchIcon, WitchRank, name, x, y);
    }

}

