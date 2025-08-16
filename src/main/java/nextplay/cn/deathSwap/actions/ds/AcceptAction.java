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
public class AcceptAction implements Action {

    @Override
    public boolean run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        Player inviter = Global.inviteRequest.get(player);
        Global.inviteRequest.remove(player);
        if (inviter == null) {
            player.sendMessage(ChatColor.RED + "您没有邀请请求需要处理.");
            return true;
        }

        Game game = GameUtils.getPlayersGame(inviter);
        if (game == null) {
            player.sendMessage(ChatColor.RED + "游戏房间不存在 也许创建者离开了他自己的房间.");
            return true;
        }

        if (game.getPlayer1() != null && game.getPlayer2() != null) {
            player.sendMessage(ChatColor.RED + "来晚了一步 游戏房间已经没有位置了.");
            return true;
        }

        // 一定会有位置
        if (game.getPlayer1() == null) {
            game.setPlayer1(player);
        } else {
            game.setPlayer2(player);
        }

        inviter.sendMessage(ChatColor.YELLOW + String.format("%s加入了你的游戏房间!", player.getName()));
        player.sendMessage(ChatColor.YELLOW +String.format("你加入了%s的游戏房间!", inviter.getName()));

        return true;
    }
}
