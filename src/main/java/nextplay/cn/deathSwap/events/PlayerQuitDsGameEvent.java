package nextplay.cn.deathSwap.events;

import nextplay.cn.deathSwap.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Life was like a box of chocolates
 * you never know what you're going to get.
 *
 * @author jonathan [admin@56fkj.cn]
 */
public class PlayerQuitDsGameEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

    private boolean cancelled = false;

    /**
     * Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @return true if this event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins.
     *
     * @param cancel true if you wish to cancel this event
     */
    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    public enum QuitReason {
        QUIT_REASON_MANUAL,
        QUIT_REASON_KICKED,
    }

    private Game game;
    private Player player;
    private QuitReason quitReason;

    /**
     * The default constructor is defined for cleaner code. This constructor
     * assumes the event is synchronous.
     */
    public PlayerQuitDsGameEvent(Game game, Player player, QuitReason quitReason) {
        this.game = game;
        this.player = player;
        this.quitReason = quitReason;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public QuitReason getQuitReason() {
        return quitReason;
    }

    public void setQuitReason(QuitReason quitReason) {
        this.quitReason = quitReason;
    }
}
