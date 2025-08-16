package nextplay.cn.deathSwap.actions.ds;

import nextplay.cn.deathSwap.Game;
import nextplay.cn.deathSwap.Global;
import nextplay.cn.deathSwap.interfaces.Action;
import nextplay.cn.deathSwap.utils.GameUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

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

        if (args.length < 2) {
            return false;
        }

        enum arg {action, inviter}

        // 检查邀请
        Player inviter = checkInvitation(player, Bukkit.getPlayer(args[arg.inviter.ordinal()]));
        if (inviter == null) {
            return true;
        }

        // 房间被移除了？
        Game game = GameUtils.getPlayersGame(inviter);
        if (game == null) {
            player.sendMessage(ChatColor.RED + "游戏房间不存在 也许创建者离开了他自己的房间.");
            return true;
        }

        // 房间人满了？
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
        player.sendMessage(ChatColor.YELLOW + String.format("你加入了%s的游戏房间!", inviter.getName()));

        return true;
    }

    /**
     * 检查邀请
     *
     * @param invitee 受邀者
     * @param inviter 邀请者
     * @return Player for inviter or null for break
     */
    public static Player checkInvitation(Player invitee, Player inviter) {
        // 哪些人邀请了我? 同意谁？
        List<Player> inviters = Global.inviteeAndInviters.get(invitee);

        if (inviter == null) {
            invitee.sendMessage(ChatColor.RED + "邀请者不存在.");
            return null;
        }
        if (!inviters.contains(inviter)) {
            invitee.sendMessage(ChatColor.RED + "目标玩家没有对你进行邀请.");
            return null;
        }
        inviters.remove(inviter);
        return inviter;
    }
}
