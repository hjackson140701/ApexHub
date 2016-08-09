package eu.apexmc.hub.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import eu.apexmc.hub.main.Main;

public class HungerEvent implements Listener
{
	public HungerEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void ApexHubHungerEvent(FoodLevelChangeEvent event)
	{
			event.setCancelled(true);
	}
}
