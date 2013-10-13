package us.kpvpdev.easybans.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

import us.kpvpdev.easybans.EasyBans;

public class PlayerHandler implements Listener
{
    final EasyBans plugin;

    public PlayerHandler(EasyBans instance)
    {
        plugin = instance;
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onJoin(AsyncPlayerPreLoginEvent event)
    {
        String player = event.getName().toLowerCase();

        if (plugin.banconfig.getConfig().getString(player) !=null)
        {
            event.disallow(Result.KICK_BANNED, "You are banned from this server." + "\n" + "Reason: §c" + plugin.banconfig.getConfig().getString(player));
        }
    }
}
