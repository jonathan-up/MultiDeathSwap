package nextplay.cn.deathSwap;

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

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getCreator() {
        return creator;
    }

    public void setCreator(Player creator) {
        this.creator = creator;
    }

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }

    public int getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(int readyTime) {
        this.readyTime = readyTime;
    }

    public BossBar getTimeBar() {
        return timeBar;
    }

    public void setTimeBar(BossBar timeBar) {
        this.timeBar = timeBar;
    }
}
