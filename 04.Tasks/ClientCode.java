import org.example.units.BaseHero;
import java.util.ArrayList;
import java.util.Comparator;
public class ClientCode  {
    public static void main(String[] args) {
        ArrayList<BaseHero> teamOwn = new ArrayList<>();
        ArrayList<BaseHero> teamEnemy = new ArrayList<>();
        System.out.println("    Список своих ==========");
        Additionally.getListOwn(teamOwn);//вызов статического метода, обращаемся к классу!
        teamOwn.forEach(n -> System.out.println(n.getInfo() + " " + n.getName()));
        System.out.println("    Список противников ===========");
        Additionally.getListEnemy(teamEnemy);
        teamEnemy.forEach(n -> System.out.println(n.getInfo() + " " + n.getName()));
        System.out.println("    ====Начало игры====");
        teamOwn.forEach(n -> n.step(teamOwn,teamEnemy));
        teamEnemy.forEach(n -> n.step(teamEnemy, teamOwn));
        ArrayList<BaseHero> teamAll = new ArrayList<>();
        teamAll.addAll(teamOwn);
        teamAll.addAll(teamEnemy);
        // сортировка по приоритету
        teamAll.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                if (o1.getPriority() == o2.getPriority()) {
                    return (int)(o1.getHp()/o1.getMaxhp() - o2.getHp()/o2.getMaxhp());
                }
                return o1.getPriority() - o2.getPriority();
            }
        });
        teamAll.forEach(n -> System.out.println(n.getInfo() + " " + n.getName()));
        teamAll.forEach(n -> n.step(teamOwn,teamEnemy));
        System.out.println("=================");
        teamAll.forEach(n -> System.out.println(n.getInfo() + " " + n.getName()));

    }



}