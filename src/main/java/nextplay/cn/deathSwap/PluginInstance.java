package nextplay.cn.deathSwap;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Life was like a box of chocolates
 * you never know what you're going to get.
 *
 * @author jonathan [admin@56fkj.cn]
 */
public class PluginInstance {
    private static JavaPlugin instance;

    public static JavaPlugin get() {
        return JavaPlugin.getPlugin(DeathSwap.class);
    }
}
