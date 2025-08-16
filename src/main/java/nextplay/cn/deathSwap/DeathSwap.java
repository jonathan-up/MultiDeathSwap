package nextplay.cn.deathSwap;

import nextplay.cn.deathSwap.commands.DsCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

/**
 * Life was like a box of chocolates
 * you never know what you're going to get.
 *
 * @author jonathan [admin@56fkj.cn]
 */
public final class DeathSwap extends JavaPlugin {

    @Override
    public void onEnable() {
//        this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        Objects.requireNonNull(this.getCommand("ds")).setExecutor(new DsCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
