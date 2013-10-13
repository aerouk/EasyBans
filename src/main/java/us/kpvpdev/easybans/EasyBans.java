package us.kpvpdev.easybans;

import org.bukkit.plugin.java.JavaPlugin;

import us.kpvpdev.easybans.commands.Ban;
import us.kpvpdev.easybans.commands.EasyBansCommand;
import us.kpvpdev.easybans.commands.IsBanned;
import us.kpvpdev.easybans.commands.Unban;
import us.kpvpdev.easybans.config.BanConfig;
import us.kpvpdev.easybans.listeners.PlayerHandler;

public class EasyBans extends JavaPlugin
{
    public static EasyBans plugin;
    public String prefix = "§eEB §7> §r ";
    public BanConfig banconfig;

    public EasyBans()
    {
        this.banconfig = new BanConfig(this);
    }

    @Override
    public void onEnable()
    {
        setup();
        getServer().getLogger().info("EasyBans is enabled.");
    }

    @Override
    public void onDisable()
    {
        getServer().getLogger().info("EasyBans is disabled.");
    }

    void setup()
    {
        getCommand("eban").setExecutor(new Ban(this));
        getCommand("eunban").setExecutor(new Unban(this));
        getCommand("easybans").setExecutor(new EasyBansCommand(this));
        getCommand("isbanned").setExecutor(new IsBanned(this));

        getServer().getPluginManager().registerEvents(new PlayerHandler(this), this);		
    }
}
