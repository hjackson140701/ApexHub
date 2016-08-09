package eu.apexmc.hub.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import eu.apexmc.hub.main.Main;

public class ItemDropEvent implements Listener
{
	public ItemDropEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void ApexHubItemDropEvent(PlayerDropItemEvent event)
	{
			event.setCancelled(true);
	}
}
