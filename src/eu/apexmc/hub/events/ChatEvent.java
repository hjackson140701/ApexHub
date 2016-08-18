package eu.apexmc.hub.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import eu.apexmc.hub.main.Main;
import net.md_5.bungee.api.ChatColor;

public class ChatEvent implements Listener
{
	public ChatEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void ApexHubChatEvent(AsyncPlayerChatEvent event)
	{
		event.setFormat(ChatColor.GRAY + "%s" + ChatColor.DARK_GRAY +  " > " + ChatColor.WHITE + "%s");
		}
	}
