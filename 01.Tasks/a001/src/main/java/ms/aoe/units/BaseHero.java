package ms.aoe.units;

import java.util.*;

public class BaseHero {
    int x, y;
    int id;
    String name;
    public BaseHero () {
        id = new Random().nextInt();
        name = this.getClass().getSimpleName() + id;
    }
    public void print(){
        System.out.println(name);
    }
}
