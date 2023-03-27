package ms.aoe;
import ms.aoe.units.BaseHero;

public final class App {
    private App() {
    }
    public static void main(String[] args) {
        BaseHero hero = new BaseHero();
        hero.print();
    }
}
