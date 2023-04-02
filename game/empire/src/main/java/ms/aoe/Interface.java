// Основной интерфейс игры
package ms.aoe;

import ms.aoe.abstr.Actor;

import java.util.LinkedList;

public interface Interface {
    String step(LinkedList<Actor> units);
    String toString();
}
