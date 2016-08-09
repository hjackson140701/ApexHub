package eu.apexmc.hub.gui.serverselector;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
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
	public void Prison(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		World world = event.getWhoClicked().getWorld();
		Location prisonPortal = new Location(world, 0, 31, -18);
		if(clicked.getType() == Material.DIAMOND_PICKAXE && clicked.getItemMeta().getDisplayName().contains(ChatColor.DARK_RED + "» OP Prison «"))
		{
			event.setCancelled(true);
			player.closeInventory();
			player.teleport(prisonPortal);
			}
		}
	@EventHandler
	public void Survival(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		World world = event.getWhoClicked().getWorld();
		Location survivalPortal = new Location(world, 19, 31, 0);
		if(clicked.getType() == Material.GRASS && clicked.getItemMeta().getDisplayName().contains(ChatColor.DARK_RED + "» Survival «" + ChatColor.GRAY + ChatColor.ITALIC + " (whitelisted)"))
		{
			event.setCancelled(true);
			player.closeInventory();
			player.teleport(survivalPortal);
			}
		}
	@EventHandler
	public void Practice(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		World world = event.getWhoClicked().getWorld();
		Location practicePortal = new Location(world, 0, 31, 18);
		if(clicked.getType() == Material.POTION && clicked.getItemMeta().getDisplayName().contains(ChatColor.DARK_RED + "» PvP Practice «"))
		{
			event.setCancelled(true);
			player.closeInventory();
			player.teleport(practicePortal);
			}
		}
	}

