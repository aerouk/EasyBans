package us.kpvpdev.easybans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import us.kpvpdev.easybans.EasyBans;

public class EasyBansCommand implements CommandExecutor
{
    final EasyBans plugin;

    public EasyBansCommand(EasyBans instance)
    {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        sender.sendMessage(plugin.prefix + "Plugin developed by §eiEpix");
        sender.sendMessage(plugin.prefix + "§7- http://dev.bukkit.org/server-mods/easybans/");
        sender.sendMessage(plugin.prefix + "§e§oCommands:");

        if (sender.isOp() || sender.hasPermission("easybans.help"))
        {
            sender.sendMessage(plugin.prefix + "/ban <player> [reason] - §oBans player with reason.");
            sender.sendMessage(plugin.prefix + "/unban <player - §oUnbans player.");
            sender.sendMessage(plugin.prefix + "/isbanned <player> - §oChecks whether a player is banned.");
        }

        sender.sendMessage(plugin.prefix + "/easybans - §oShows this screen.");
        return false;
    }
}
