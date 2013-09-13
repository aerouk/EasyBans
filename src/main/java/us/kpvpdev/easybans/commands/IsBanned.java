package us.kpvpdev.easybans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import us.kpvpdev.easybans.EasyBans;

public class IsBanned implements CommandExecutor {

    final EasyBans plugin;

    public IsBanned(EasyBans instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp() || sender.hasPermission("easybans.check")) {
            if (args.length == 0) {
                sender.sendMessage(plugin.prefix + "Usage: /" + label + " <player>");
            } else if (args.length == 1) {
                if (plugin.banconfig.getConfig().contains(args[0].toLowerCase())) {
                    sender.sendMessage(plugin.prefix + args[0] + " is banned from the server for: §c" + plugin.banconfig.getConfig().getString(args[0].toLowerCase()));
                } else {
                    sender.sendMessage(plugin.prefix + "That player (§e" + args[0] + "§r) is not banned.");
                }
            }
        }

        return false;
    }

}
