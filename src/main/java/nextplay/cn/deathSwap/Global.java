package nextplay.cn.deathSwap;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Life was like a box of chocolates
 * you never know what you're going to get.
 *
 * @author jonathan [admin@56fkj.cn]
 */
public class Global {
    public static List<Game> games = new ArrayList<>();

    // <Invitee, Inviter>
    public static Map<Player, Player> inviteRequest = new HashMap<>();
}
