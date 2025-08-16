package nextplay.cn.deathSwap.utils;

import nextplay.cn.deathSwap.Game;
import nextplay.cn.deathSwap.Global;
import org.bukkit.entity.Player;

/**
 * Life was like a box of chocolates
 * you never know what you're going to get.
 *
 * @author jonathan [admin@56fkj.cn]
 */
public class GameUtils {

    public static Game getPlayersGame(Player player) {
        for (Game game : Global.games) {
            if (game.getCreator() == player) {
                return game;
            }
        }
        return null;
    }

    public static boolean isPlayerCreator(Player player) {
        for (Game game : Global.games) {
            if (player == game.getCreator()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPlayerInGame(Player player) {
        for (Game game : Global.games) {
            if (game.getCreator() == player || game.getPlayer1() == player || game.getPlayer2() == player) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPlayerInGame(Player player, Game game) {
        return game.getCreator() == player || game.getPlayer1() == player || game.getPlayer2() == player;
    }

    public static boolean shouldGameBeRemoved(Game game) {
        if (game.getCreator() == null) {
            return true;
        }
        return game.getPlayer1() == null && game.getPlayer2() == null;
    }

    /**
     * Make player quit from a game
     *
     * @param player player
     * @param game   game
     */
    public static void quit(Player player, Game game) {
        // 创建者退出: 删除游戏
        if (game.getCreator() == player) {
            game.setCreator(null);
            // 一个创建者很有可能是也是其中的玩家 所以不返回
        }

        // 玩家退出: 游戏把玩家置空
        if (game.getPlayer1() == player) {
            game.setPlayer1(null);
        }
        if (game.getPlayer2() == player) {
            game.setPlayer2(null);
        }
    }
}
