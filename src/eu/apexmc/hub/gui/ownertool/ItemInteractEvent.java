package eu.apexmc.hub.gui.ownertool;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import eu.apexmc.hub.main.Main;

public class ItemInteractEvent implements Listener
{
	public ItemInteractEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void ApexHubPlayerInteractEvent(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if(player.getItemInHand().getType() == Material.BEDROCK)
		{
			player.openInventory(OwnerTool.OwnerTool);
		}
	}
}
