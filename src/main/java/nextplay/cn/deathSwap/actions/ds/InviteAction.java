package nextplay.cn.deathSwap.actions.ds;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import nextplay.cn.deathSwap.Global;
import nextplay.cn.deathSwap.interfaces.Action;
import nextplay.cn.deathSwap.utils.GameUtils;
import org.bukkit.Bukkit;
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
public class InviteAction implements Action {

    @Override
    public boolean run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length < 2) {
            return false;
        }

        if (!GameUtils.isPlayerCreator(player)) {
            player.sendMessage(ChatColor.RED + "创建游戏后才能使用该命令");
            return true;
        }

        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            player.sendMessage(ChatColor.RED + "玩家不存在: ", args[1]);
            return true;
        }
        if (target == player) {
            player.sendMessage(ChatColor.RED + "你不能邀请你自己");
            return true;
        }

        // Send to target
        TextComponent accept = new TextComponent("同意");
        accept.setBold(true);
        accept.setColor(net.md_5.bungee.api.ChatColor.GREEN);
        accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ds accept " + player.getName()));
        accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("点击我同意邀请")));

        TextComponent denny = new TextComponent("拒绝");
        denny.setBold(true);
        denny.setColor(net.md_5.bungee.api.ChatColor.RED);
        denny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ds denny " + player.getName()));
        denny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("点击我拒绝邀请")));

        target.spigot().sendMessage(
                new ComponentBuilder()
                        .append(String.format("%s向你发送游戏请求", player.getName()))
                        .append("\n")
                        .append(accept).append(" ")
                        .append(denny)
                        .create()
        );
        Global.inviteRequest.put(target, player);

        player.sendMessage(ChatColor.YELLOW + String.format("成功向%s发送游戏邀请", target.getName()));
        return true;
    }
}
