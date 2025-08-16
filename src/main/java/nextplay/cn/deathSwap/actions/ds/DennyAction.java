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
public class DennyAction implements Action {

    @Override
    public boolean run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length < 2) {
            return false;
        }

        enum arg {action, inviter}

        // 检查邀请
        Player inviter = AcceptAction.checkInvitation(player, Bukkit.getPlayer(args[arg.inviter.ordinal()]));
        if (inviter == null) {
            return true;
        }

        inviter.sendMessage(ChatColor.RED + String.format("%s拒绝了你的邀请请求", player.getName()));
        player.sendMessage(ChatColor.YELLOW + String.format("你拒绝了%s的邀请请求", inviter.getName()));
        return true;
    }
}
