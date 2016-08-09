package eu.apexmc.hub.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import eu.apexmc.hub.main.Main;

public class WeatherEvent implements Listener
{
	public WeatherEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void ApexWeatherChangeEvent(WeatherChangeEvent event)
	{
		event.setCancelled(true);
	}
}
