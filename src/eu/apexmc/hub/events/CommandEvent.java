package eu.apexmc.hub.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import eu.apexmc.hub.main.Main;

public class CommandEvent implements Listener
{
	public CommandEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void ApexHubChatEvent(PlayerCommandPreprocessEvent event)
	{
		event.setCancelled(true);
		}
	}
