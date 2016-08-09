package eu.apexmc.hub.events;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import eu.apexmc.hub.main.Main;
import net.md_5.bungee.api.ChatColor;

public class JoinEvent implements Listener
{
	public JoinEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void ApexHubJoinEvent(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		String playerName = event.getPlayer().getName();
		World playerWorld = event.getPlayer().getWorld();
		Location playerLocation = event.getPlayer().getLocation();
		PlayerInventory playerInventory = event.getPlayer().getInventory();
		Location spawnLocation = Bukkit.getServer().getWorld("hub").getSpawnLocation();
				
		playerInventory.clear();
		player.teleport(spawnLocation);
		player.setGameMode(GameMode.ADVENTURE);
		playerInventory.setHeldItemSlot(4);
		player.sendTitle(ChatColor.RED + "Welcome to the Apex Network!", ChatColor.RED + "Enter a portal to start.");
		playerWorld.playEffect(playerLocation, Effect.MOBSPAWNER_FLAMES, 1);
		
		event.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + playerName);
		
		ItemStack ServerSelector = new ItemStack(Material.COMPASS);
		ItemMeta ServerSelectorMeta = ServerSelector.getItemMeta();
		ServerSelectorMeta.setDisplayName(ChatColor.RED + "Server Selector" + ChatColor.GRAY + ChatColor.ITALIC + " (right click)");
		ServerSelector.setItemMeta(ServerSelectorMeta);
		playerInventory.setItem(4, ServerSelector);
		
		ItemStack AdminTool = new ItemStack(Material.NETHER_STAR);
		ItemMeta AdminToolMeta = AdminTool.getItemMeta();
		AdminToolMeta.setDisplayName(ChatColor.RED + "Admin Tool" + ChatColor.GRAY + ChatColor.ITALIC + " (right click)");
		AdminTool.setItemMeta(AdminToolMeta);
		
		ItemStack OwnerTool = new ItemStack(Material.BEDROCK);
		ItemMeta OwnerToolMeta = OwnerTool.getItemMeta();
		OwnerToolMeta.setDisplayName(ChatColor.RED + "Owner Tool" + ChatColor.GRAY + ChatColor.ITALIC + " (right click)");
		OwnerTool.setItemMeta(OwnerToolMeta);
		
		if(playerName.equalsIgnoreCase("HeriPutr"))
				{
					playerInventory.setItem(0, OwnerTool);
					playerInventory.setItem(8, AdminTool);
				}
		if(playerName.equalsIgnoreCase("4p3x"))
		{
			playerInventory.setItem(0, OwnerTool);
			playerInventory.setItem(8, AdminTool);
		}
		if(playerName.equalsIgnoreCase("miffster333"))
		{
			playerInventory.setItem(8, AdminTool);
		}
	}
}
