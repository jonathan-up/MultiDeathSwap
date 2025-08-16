package nextplay.cn.deathSwap.actions.ds;

import nextplay.cn.deathSwap.Game;
import nextplay.cn.deathSwap.Global;
import nextplay.cn.deathSwap.PluginInstance;
import nextplay.cn.deathSwap.events.PlayerQuitDsGameEvent;
import nextplay.cn.deathSwap.interfaces.Action;
import nextplay.cn.deathSwap.utils.GameUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Life was like a box of chocolates
 * you never know what you're going to get.
 *
 * @author jonathan [admin@56fkj.cn]
 */
public class QuitAction implements Action {

    @Override
    public boolean run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (!GameUtils.isPlayerInGame(player)) {
            player.sendMessage(ChatColor.RED + "你目前不在游戏中!");
            return true;
        }

        for (int i = 0; i < Global.games.size(); i++) {
            Game game = Global.games.get(i);
            Player creator = game.getCreator();
            Player player1 = game.getPlayer1();
            Player player2 = game.getPlayer2();

            // If
            if (GameUtils.isPlayerInGame(player, game)) {
                // Trigger the event
                PlayerQuitDsGameEvent event = new PlayerQuitDsGameEvent(
                        game,
                        player,
                        PlayerQuitDsGameEvent.QuitReason.QUIT_REASON_MANUAL
                );
                PluginInstance.get()
                        .getServer()
                        .getPluginManager()
                        .callEvent(event);

                // If not cancelled
                if (!event.isCancelled()) {
                    GameUtils.quit(player, game);
                    if (player != creator) {
                        player.sendMessage(ChatColor.YELLOW + String.format("你退出了%s的游戏房间!", creator.getName()));
                        creator.sendMessage(ChatColor.YELLOW + String.format("%s退出了你的游戏房间!", player.getName()));
                    }
                    // Check if the game should be removed
                    if (GameUtils.shouldGameBeRemoved(game)) {
                        Global.games.remove(i);
                        creator.sendMessage("你创建的游戏房间被移除了!");
                        if (player1 != creator) {
                            player1.sendMessage(ChatColor.YELLOW +"你退出了游戏房间 因为你所在的游戏房间被移除了!");
                        }
                        if (player2 != creator) {
                            player2.sendMessage(ChatColor.YELLOW +"你退出了游戏房间 因为你所在的游戏房间被移除了!");
                        }
                    }
                }
            }
        }

        return true;
    }
}
