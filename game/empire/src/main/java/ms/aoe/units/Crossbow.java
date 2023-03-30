// Добрый Арбалетчик - расширяет абстрактный класс Стрелок
package ms.aoe.units;
public class Crossbow extends AbstrBow {

    public Crossbow(String name, int x, int y) {
        super(name, x, y, 30, 5, 70);
    }
    
}
