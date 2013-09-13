package us.kpvpdev.easybans.commands;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.kpvpdev.easybans.EasyBans;

public class Ban implements CommandExecutor {

    final EasyBans plugin;

    public Ban(EasyBans instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.isOp() || sender.hasPermission("easybans.ban")) {
            if(args.length == 0) {
                sender.sendMessage(plugin.prefix + "Usage: /" + label + " <player> <reason>");
            } else if(args.length == 1) {
                Player target = plugin.getServer().getPlayer(args[0]);
                OfflinePlayer offlineTarget = plugin.getServer().getOfflinePlayer(args[0]);

                if(target != null) {
                    String reason = "Banned!";

                    target.kickPlayer("You were banned from the server.\nReason: §c" + reason);
                    target.setBanned(true);

                    plugin.getServer().broadcastMessage("§7" + target.getName() + " was banned from the server by " + sender.getName());

                    plugin.banconfig.getConfig().set(target.getName().toLowerCase(), reason);
                    plugin.banconfig.saveConfig();
                } else {
                    String reason = "Banned!";

                    offlineTarget.setBanned(true);

                    plugin.getServer().broadcastMessage("§7" + offlineTarget.getName() + " was banned from the server by " + sender.getName());

                    plugin.banconfig.getConfig().set(offlineTarget.getName().toLowerCase(), reason);
                    plugin.banconfig.saveConfig();
                }
            } else if(args.length >= 2) {
                Player target = plugin.getServer().getPlayer(args[0]);
                OfflinePlayer offlineTarget = plugin.getServer().getOfflinePlayer(args[0]);

                if(target != null) {
                    String reason = "";

                    for(int i = 1; i < args.length; i++) {
                        reason = reason + args[i] + " ";
                    }

                    target.kickPlayer("You were banned from the server.\nReason: §c" + reason);
                    target.setBanned(true);

                    plugin.getServer().broadcastMessage("§7" + target.getName() + " was banned from the server by " + sender.getName() + " for " + reason);

                    plugin.banconfig.getConfig().set(target.getName().toLowerCase(), reason);
                    plugin.banconfig.saveConfig();
                } else {
                    String reason = "";

                    for(int i = 1; i < args.length; i++) {
                        reason = reason + args[i] + " ";
                    }

                    offlineTarget.setBanned(true);

                    plugin.getServer().broadcastMessage("§7" + offlineTarget.getName() + " was banned from the server by " + sender.getName() + " for " + reason);

                    plugin.banconfig.getConfig().set(offlineTarget.getName().toLowerCase(), reason);
                    plugin.banconfig.saveConfig();
                }
            }
        }

        return false;
    }

}
