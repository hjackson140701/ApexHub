package eu.apexmc.hub.gui.admintool;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import eu.apexmc.hub.main.Main;
import net.md_5.bungee.api.ChatColor;

public class AdminTool implements Listener
{
	public AdminTool(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	public static Inventory AdminTool = Bukkit.createInventory(null, 45, ChatColor.DARK_GRAY + "Admin Tool");
	{
		ItemStack Day = new ItemStack(Material.GLOWSTONE);
		ItemMeta DayMeta = Day.getItemMeta();
		DayMeta.setDisplayName(ChatColor.DARK_RED + "» Set the time to day «");
		Day.setItemMeta(DayMeta);
		
		ItemStack Night = new ItemStack(Material.OBSIDIAN);
		ItemMeta NightMeta = Night.getItemMeta();
		NightMeta.setDisplayName(ChatColor.DARK_RED + "» Set the time to night «");
		Night.setItemMeta(NightMeta);
		
		ItemStack Survival = new ItemStack(Material.MOSSY_COBBLESTONE);
		ItemMeta SurvivalMeta = Survival.getItemMeta();
		SurvivalMeta.setDisplayName(ChatColor.DARK_RED + "» Set your gamemode to survival «");
		Survival.setItemMeta(SurvivalMeta);
		
		ItemStack Creative = new ItemStack(Material.SPONGE);
		ItemMeta CreativeMeta = Creative.getItemMeta();
		CreativeMeta.setDisplayName(ChatColor.DARK_RED + "» Set your gamemode to creative «");
		Creative.setItemMeta(CreativeMeta);
		
		ItemStack ClearChat = new ItemStack(Material.PAPER);
		ItemMeta ClearChatMeta = ClearChat.getItemMeta();
		ClearChatMeta.setDisplayName(ChatColor.DARK_RED + "» Clear the chat «");
		ClearChat.setItemMeta(ClearChatMeta);
		
		ItemStack KickAll = new ItemStack(Material.SKULL_ITEM);
		ItemMeta KickAllMeta = KickAll.getItemMeta();
		KickAllMeta.setDisplayName(ChatColor.DARK_RED + "» Kick all players from the server «");
		KickAll.setItemMeta(KickAllMeta);
		
		ItemStack SpawnTeleport = new ItemStack(Material.GRASS);
		ItemMeta SpawnTeleportMeta = SpawnTeleport.getItemMeta();
		SpawnTeleportMeta.setDisplayName(ChatColor.DARK_RED + "» Teleport to the spawn point «");
		SpawnTeleport.setItemMeta(SpawnTeleportMeta);
		
		AdminTool.setItem(10, Day);
		AdminTool.setItem(28, Night);
		AdminTool.setItem(12, Survival);
		AdminTool.setItem(30, Creative);
		AdminTool.setItem(14, ClearChat);
		AdminTool.setItem(32, KickAll);
		AdminTool.setItem(16, SpawnTeleport);
	
	}
}
