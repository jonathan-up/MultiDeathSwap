package nextplay.cn.deathSwap.actions.ds;

import nextplay.cn.deathSwap.Game;
import nextplay.cn.deathSwap.Global;
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
public class CreateAction implements Action {

    @Override
    public boolean run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (GameUtils.isPlayerInGame(player)) {
            player.sendMessage(ChatColor.YELLOW + "你已经在游戏中!");
            return true;
        }

        Game game = new Game();
        game.setPlayer1(player);
        game.setCreator(player);

        Global.games.add(game);
        player.sendMessage(ChatColor.YELLOW + "创建游戏成功!");
        return true;
    }
}
