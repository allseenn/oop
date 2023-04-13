// Маги - абстрактный класс расширяет высшый класс Актер
package ms.aoe.abstr;
import ms.aoe.Control;
import java.util.LinkedList;
public abstract class Magican extends Actor {

    @Override
    public int findFriend(LinkedList<Actor> units){
        int friendId = 999;
        int minHp = 999;
        for (int i = 0; i < units.size(); i++){
            if(units.get(i).getTeam() == this.getTeam() && units.get(i).getHp() > 0){
                if(units.get(i).getHp() < minHp){
                    minHp = units.get(i).getHp();
                    friendId = i;
                }
            }
        }
        return friendId;
    }

    @Override
    public void step(LinkedList<Actor> units){
        int enemyIndex = findEnemy(units);
        int friendIndex = findFriend(units);
        if(enemyIndex != 999 & friendIndex != 999){
            int enemyHp = units.get(enemyIndex).getHp();
            String enemyName = units.get(enemyIndex).getName();
            String enemyRank = units.get(enemyIndex).getRank();
            int magForce = this.getForce();
            String magName = this.getName();
            String magRank = this.getRank();
            int friendHp = units.get(friendIndex).getHp();
            String friendName = units.get(friendIndex).getName();
            String friendRank = units.get(friendIndex).getRank();
            units.get(enemyIndex).setHp(enemyHp-magForce);
            Control.console.append(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")));
            Control.console.append(magRank+" "+magName+" забрал "+magForce+" здоровья у "+enemyRank+" "+enemyName+", оставив ему "+enemyHp+"% жизни\n");
            units.get(friendIndex).setHp(friendHp+magForce);
            Control.console.append(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")));
            Control.console.append(magRank+" "+magName+" отдал "+magForce+" здоровья "+friendRank+" "+friendName+", вылечив его до "+friendHp+"% жизни\n");
        }
        return;
    }

    public Magican(boolean team, int priority, String icon, String rank, String name, int x, int y) {
        super(team, priority, icon, rank, name, x, y, MagicanAmmo, MagicanArmor, MagicanForce);

    }

}
