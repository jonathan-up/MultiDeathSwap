package nextplay.cn.deathSwap.listeners;

import net.md_5.bungee.api.ChatColor;
import nextplay.cn.deathSwap.events.PlayerQuitDsGameEvent;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * Life was like a box of chocolates
 * you never know what you're going to get.
 *
 * @author jonathan [admin@56fkj.cn]
 */
public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        String itemName = "空手";
        if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
            itemName = player.getInventory().getItemInMainHand().getType().name();
        }
        player.sendMessage(ChatColor.YELLOW + String.format(
                "你破坏了%s使用%s",
                block.getType(),
                itemName
        ));
    }

    @EventHandler
    public void onPlayerQuitDsGame(PlayerQuitDsGameEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);
        player.sendMessage(ChatColor.RED + "LISTENER: QUITED FROM " + event.getGame().getCreator().getName() + ", BUT CANCELLED.");
    }
}
