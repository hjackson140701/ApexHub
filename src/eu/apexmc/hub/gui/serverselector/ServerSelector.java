package eu.apexmc.hub.gui.serverselector;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import eu.apexmc.hub.main.Main;
import net.md_5.bungee.api.ChatColor;

public class ServerSelector implements Listener
{
	public ServerSelector(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	public static Inventory ServerSelector = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Server Selector");
	{
		ItemStack Prison = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta PrisonMeta = Prison.getItemMeta();
		PrisonMeta.setDisplayName(ChatColor.DARK_RED + "» OP Prison «");
		Prison.setItemMeta(PrisonMeta);

		ItemStack Practice = new ItemStack(Material.POTION);
		ItemMeta PracticeMeta = Practice.getItemMeta();
		PracticeMeta.setDisplayName(ChatColor.DARK_RED + "» PvP Practice «");
		Practice.setItemMeta(PracticeMeta);
		
		ItemStack Survival = new ItemStack(Material.GRASS);
		ItemMeta SurvivalMeta = Survival.getItemMeta();
		SurvivalMeta.setDisplayName(ChatColor.DARK_RED + "» Survival «" + ChatColor.GRAY + ChatColor.ITALIC + " (whitelisted)");
		Survival.setItemMeta(SurvivalMeta);
		
		ServerSelector.setItem(11, Prison);
		ServerSelector.setItem(13, Survival);
		ServerSelector.setItem(15, Practice);
	}
}