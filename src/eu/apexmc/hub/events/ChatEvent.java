package eu.apexmc.hub.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import eu.apexmc.hub.main.Main;

@SuppressWarnings("deprecation")
public class ChatEvent implements Listener
{
	public ChatEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void ApexHubChatEvent(PlayerChatEvent event)
	{
		if(!event.getPlayer().hasPermission("apexhub.events.chat.allow"))
		{
			event.setCancelled(true);
		}
	}
}
