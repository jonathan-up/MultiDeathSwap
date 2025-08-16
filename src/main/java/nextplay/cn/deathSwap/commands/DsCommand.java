package nextplay.cn.deathSwap.commands;

import nextplay.cn.deathSwap.actions.ds.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

/**
 * Life was like a box of chocolates
 * you never know what you're going to get.
 *
 * @author jonathan [admin@56fkj.cn]
 */
public class DsCommand implements CommandExecutor, TabCompleter {

    final List<String> root = Arrays.asList("create", "quit", "invite", "accept", "denny", "countdown", "readytime", "start", "stop", "list");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("该命令只能由玩家执行!");
            return true;
        }

        // create
        if (args[0].equals(root.get(0))) {
            return new CreateAction().run(sender, command, label, args);
        }
        // quit
        if (args[0].equals(root.get(1))) {
            return new QuitAction().run(sender, command, label, args);
        }
        // invite
        if (args[0].equals(root.get(2))) {
            return new InviteAction().run(sender, command, label, args);
        }
        // accept
        if (args[0].equals(root.get(3))) {
            return new AcceptAction().run(sender, command, label, args);
        }
        // denny
        if (args[0].equals(root.get(4))) {
            return new InviteAction().run(sender, command, label, args);
        }
        // list
        if (args[0].equals(root.get(9))) {
            return new ListAction().run(sender, command, label, args);
        }
//        //countdown
//        if (args[0].equals(root.get(2))) {
//            return new Countdown(plugin).run(sender, command, label, args);
//        }
//        //readytime
//        if (args[0].equals(root.get(3))) {
//            return new ReadyTime(plugin).run(sender, command, label, args);
//        }
//        //check
//        if (args[0].equals(root.get(4))) {
//            return new Check(plugin).run(sender, command, label, args);
//        }
//
//        //start
//        if (args[0].equals(root.get(5))) {
//            return new Start(plugin).run(sender, command, label, args);
//        }
//
//        //stop
//        if (args[0].equals(root.get(6))) {
//            return new Stop(plugin).run(sender, command, label, args);
//        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
//        if (args[0].equals(root.get(2)) || args[0].equals(root.get(3))) {
//            return Collections.singletonList("[sec]");
//        }
//        return null;
        switch (args.length) {
            case 1:  // arg1
                return root;
            case 2:  // arg2
                return null;
            default:
                return null;
        }
    }
}
