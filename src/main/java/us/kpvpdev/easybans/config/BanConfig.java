package us.kpvpdev.easybans.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import us.kpvpdev.easybans.EasyBans;

public class BanConfig
{
    final EasyBans plugin;
    public FileConfiguration config = null;
    public File configFile = null;

    public BanConfig(EasyBans instance)
    {
        plugin = instance;
    }

    public void loadConfig()
    {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public FileConfiguration getConfig()
    {
        if (config == null)
        {
            reloadConfig();
        }

        return config;
    }

    public void reloadConfig()
    {
        if (configFile == null)
        {
            configFile = new File(plugin.getDataFolder(), "banned.yml");
        }

        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void saveConfig()
    {
        if ((config == null) || (configFile == null))
        {
            return;
        }

        try
        {
            config.save(configFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}