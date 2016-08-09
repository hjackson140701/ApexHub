package eu.apexmc.hub.gui.ownertool;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.ItemStack;

import eu.apexmc.hub.main.Main;
import net.md_5.bungee.api.ChatColor;

public class ItemClickEvent implements Listener
{
	public ItemClickEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void MaintenanceModeEnable(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		if(clicked.getType() == Material.WATER_BUCKET && clicked.getItemMeta().getDisplayName().contains(ChatColor.DARK_RED + "» Enable maintenance mode «"))
		{
			event.setCancelled(true);
			player.closeInventory();
			Bukkit.setWhitelist(true);
			player.sendMessage(ChatColor.DARK_AQUA + "Maintenance Mode has been enabled.");
			}
		}
	@EventHandler
	public void MaintenanceModeDisable(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		if(clicked.getType() == Material.LAVA_BUCKET && clicked.getItemMeta().getDisplayName().contains(ChatColor.DARK_RED + "» Disable maintenance mode «"))
		{
			event.setCancelled(true);
			player.closeInventory();
			Bukkit.setWhitelist(false);
			player.sendMessage(ChatColor.DARK_AQUA + "Maintenance Mode has been disabled.");
		}
	}
	@EventHandler
	public void whitelistOn(PlayerLoginEvent event)
	{
		Player p = event.getPlayer();
		if(!p.isWhitelisted())
		{
			if(!p.isOp())
			{
				if(Bukkit.hasWhitelist())
				{
					event.disallow(Result.KICK_WHITELIST, ChatColor.DARK_RED + "" + ChatColor.BOLD + ChatColor.ITALIC + "" + "\nApex Network\n" + ChatColor.RED + "The server is currently under maintenance\nPlease attempt to connect later!");
				}
			}
		}
	}
}

