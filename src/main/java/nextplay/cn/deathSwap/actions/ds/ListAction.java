package nextplay.cn.deathSwap.actions.ds;

import nextplay.cn.deathSwap.Game;
import nextplay.cn.deathSwap.Global;
import nextplay.cn.deathSwap.interfaces.Action;
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
public class ListAction implements Action {

    @Override
    public boolean run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        // Todo: perms
        player.sendMessage("------------------------------");
        int count = 0;
        for (Game game : Global.games) {
            player.sendMessage(String.format("State: %s", game.getState().name()));
            player.sendMessage(String.format("Player1: %s", game.getPlayer1() == null ? "None" : game.getPlayer1().getName()));
            player.sendMessage(String.format("Player2: %s", game.getPlayer2() == null ? "None" : game.getPlayer2().getName()));
            player.sendMessage(String.format("Creator: %s", game.getCreator() == null ? "None" : game.getCreator().getName()));
            player.sendMessage(String.format("ReadyTime: %d, SwapTime: %d", game.getReadyTime(), game.getCountdown()));
            player.sendMessage("------------------------------");
            count++;
        }

        // no record
        if (count == 0) {
            player.sendMessage(ChatColor.RED + "Nothing here!");
            player.sendMessage("------------------------------");
        }
        return true;
    }
}
