package eu.apexmc.hub.gui.admintool;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
	public void Day(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		World world = (World) event.getWhoClicked().getWorld();
		ItemStack clicked = event.getCurrentItem();
		if(clicked.getType() == Material.GLOWSTONE && clicked.getItemMeta().getDisplayName().contains(ChatColor.DARK_RED + "» Set the time to day «"))
		{
			event.setCancelled(true);
			player.closeInventory();
			world.setTime(0);
			player.sendMessage(ChatColor.DARK_AQUA + "Time has been set to day.");
			}
		}
	@EventHandler
	public void Night(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		World world = (World) event.getWhoClicked().getWorld();
		ItemStack clicked = event.getCurrentItem();
		if(clicked.getType() == Material.OBSIDIAN && clicked.getItemMeta().getDisplayName().contains(ChatColor.DARK_RED + "» Set the time to night «"))
		{
			event.setCancelled(true);
			player.closeInventory();
			world.setTime(14000);
			player.sendMessage(ChatColor.DARK_AQUA + "Time has been set to night.");
		}
	}
	@EventHandler
	public void Survival(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		if(clicked.getType() == Material.MOSSY_COBBLESTONE && clicked.getItemMeta().getDisplayName().contains(ChatColor.DARK_RED + "» Set your gamemode to survival «"))
		{
			event.setCancelled(true);
			player.closeInventory();
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage(ChatColor.DARK_AQUA + "Your gamemode has been changed to survival.");
		}
	}
	@EventHandler
	public void Creative(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		if(clicked.getType() == Material.SPONGE && clicked.getItemMeta().getDisplayName().contains(ChatColor.DARK_RED + "» Set your gamemode to creative «"))
		{
			event.setCancelled(true);
			player.closeInventory();
			player.setGameMode(GameMode.CREATIVE);
			player.sendMessage(ChatColor.DARK_AQUA + "Your gamemode has been changed to creative.");
		}
	}
	@EventHandler
	public void ClearChat(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		String playerName = player.getName(); 
		ItemStack clicked = event.getCurrentItem();
		if(clicked.getType() == Material.PAPER && clicked.getItemMeta().getDisplayName().contains(ChatColor.DARK_RED + "» Clear the chat «"))
		{
			event.setCancelled(true);
			player.closeInventory();
			for (int x = 0; x < 150; x++)
			{
		          Bukkit.broadcastMessage("");
			}
			Bukkit.broadcastMessage(ChatColor.RED + "Chat" + ChatColor.DARK_RED + " > " + ChatColor.RED + "Chat has been cleared by " + ChatColor.DARK_RED + ChatColor.UNDERLINE + ChatColor.ITALIC + playerName);
			player.sendMessage(ChatColor.DARK_AQUA + "Chat has been cleared.");
		}
	}
	@EventHandler
	public void SpawnTeleport(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		World world = (World) event.getWhoClicked().getWorld();
		Location spawnPoint = world.getSpawnLocation();
		ItemStack clicked = event.getCurrentItem();
		if(clicked.getType() == Material.GRASS && clicked.getItemMeta().getDisplayName().contains(ChatColor.DARK_RED + "» Teleport to the spawn point «"))
		{
			event.setCancelled(true);
			player.closeInventory();
			player.teleport(spawnPoint);
			player.sendMessage(ChatColor.DARK_AQUA + "You have been teleported to the spawn point.");
		}
	}
	@EventHandler
	public void KickAll(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		if(clicked.getType() == Material.SKULL_ITEM && clicked.getItemMeta().getDisplayName().contains(ChatColor.DARK_RED + "» Kick all players from the server «"))
		{
			event.setCancelled(true);
			player.closeInventory();			
			for(Player allOnline : Bukkit.getOnlinePlayers())
			{
				if(!(allOnline == player))
				{
				allOnline.kickPlayer(ChatColor.DARK_RED + "" + ChatColor.BOLD + ChatColor.ITALIC + "" + "\nApex Network\n" + ChatColor.RED + "All players were kicked from the server.\n" + ChatColor.GRAY + "(possible spambot attack?)");
			}
			player.sendMessage(ChatColor.DARK_AQUA + "All players have been kicked from the server.");
			}
		}	
	}
}
