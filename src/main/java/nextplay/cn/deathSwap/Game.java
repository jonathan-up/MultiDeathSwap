package nextplay.cn.deathSwap;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

/**
 * Life was like a box of chocolates
 * you never know what you're going to get.
 *
 * @author jonathan [admin@56fkj.cn]
 */
@Getter
@Setter
public class Game {

    public enum GameState {
        NONE,
        IN_PROGRESS,
    }

    private GameState state;
    private Player player1;
    private Player player2;
    private Player creator;
    private int countdown;
    private int readyTime;
    private BossBar timeBar;

    public Game() {
        this.state = GameState.NONE;
        this.player1 = null;
        this.player2 = null;
        this.creator = null;
        this.countdown = 60;
        this.readyTime = 60;
        this.timeBar = Bukkit.createBossBar("DeathSwap", BarColor.GREEN, BarStyle.SEGMENTED_20);
    }
}
