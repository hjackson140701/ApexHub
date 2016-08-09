package eu.apexmc.hub.gui.ownertool;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import eu.apexmc.hub.main.Main;
import net.md_5.bungee.api.ChatColor;

public class OwnerTool implements Listener
{
	public OwnerTool(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	public static Inventory OwnerTool = Bukkit.createInventory(null, 45, ChatColor.DARK_GRAY + "Owner Tool");
	{
		ItemStack MaintenanceModeEnable = new ItemStack(Material.WATER_BUCKET);
		ItemMeta MaintenanceModeEnableMeta = MaintenanceModeEnable.getItemMeta();
		MaintenanceModeEnableMeta.setDisplayName(ChatColor.DARK_RED + "» Enable maintenance mode «");
		MaintenanceModeEnable.setItemMeta(MaintenanceModeEnableMeta);
		
		ItemStack MaintenanceModeDisable = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta MaintenanceModeDisableMeta = MaintenanceModeDisable.getItemMeta();
		MaintenanceModeDisableMeta.setDisplayName(ChatColor.DARK_RED + "» Disable maintenance mode «");
		MaintenanceModeDisable.setItemMeta(MaintenanceModeDisableMeta);
		
		OwnerTool.setItem(20, MaintenanceModeEnable);
		OwnerTool.setItem(24, MaintenanceModeDisable);	
	}
}