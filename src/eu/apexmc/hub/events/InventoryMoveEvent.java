package eu.apexmc.hub.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import eu.apexmc.hub.main.Main;

public class InventoryMoveEvent implements Listener
{
	public InventoryMoveEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void ApexHubInventoryMoveEvent(InventoryClickEvent event)
	{
			event.setCancelled(true);
	}
}
