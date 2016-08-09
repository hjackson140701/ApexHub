package eu.apexmc.hub.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import eu.apexmc.hub.main.Main;
import eu.apexmc.hub.variables.Variables;
import net.md_5.bungee.api.ChatColor;

public class ApexCommand implements CommandExecutor, Listener
{
	public ApexCommand(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if((cmd.getName().equalsIgnoreCase("apex")))
		{
			Player player = (Player) sender;
			if(!player.hasPermission("apexhub.commands.apex"))
			{
				player.sendMessage(ChatColor.RED + "Insufficient permission(s)" + ChatColor.GRAY + ChatColor.ITALIC + " (apexhub.commands.apex)");
				return true;
			}
			if(player.hasPermission("apexhub.commands.apex"))
			{
				if(args.length == 0)
				{
					player.sendMessage(ChatColor.RED + Variables.pluginName + " v" + Variables.pluginVersion + " by HeriPutr.");
					return true;
				}
				else if(args[0].equalsIgnoreCase("version"))
				{
					player.sendMessage(ChatColor.RED + Variables.pluginName + " v" + Variables.pluginVersion + " by HeriPutr.");
					return true;
				}
				else
				{
					player.sendMessage(ChatColor.RED + "Invalid subcommand.");
					return true;
				}
			}
		}
		return true;
	}
}
