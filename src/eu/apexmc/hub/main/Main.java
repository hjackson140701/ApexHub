package eu.apexmc.hub.main;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import eu.apexmc.hub.commands.ApexCommand;
import eu.apexmc.hub.events.ChatEvent;
import eu.apexmc.hub.events.CommandEvent;
import eu.apexmc.hub.events.HungerEvent;
import eu.apexmc.hub.events.InventoryMoveEvent;
import eu.apexmc.hub.events.ItemDropEvent;
import eu.apexmc.hub.events.JoinEvent;
import eu.apexmc.hub.events.QuitEvent;
import eu.apexmc.hub.events.WeatherEvent;
import eu.apexmc.hub.gui.admintool.AdminTool;
import eu.apexmc.hub.gui.ownertool.OwnerTool;
import eu.apexmc.hub.gui.serverselector.ServerSelector;
import eu.apexmc.hub.variables.Variables;

public class Main extends JavaPlugin
{
	
	public Permission apexCommandPermission = new Permission("apexhub.commands.apex");
	public Permission chatAllowPermission = new Permission("apexhub.events.chat.allow");
	public Permission commandAllowPermission = new Permission("apexhub.events.command.allow");
	
	public void onEnable()
	{
		getLogger().info(Variables.pluginName + " v" + Variables.pluginVersion + " has been enabled!");
		
		getCommand("apex").setExecutor(new ApexCommand(this));
		
		new ApexCommand(this);
		
		new ChatEvent(this);
		new CommandEvent(this);
		new HungerEvent(this);
		new InventoryMoveEvent(this);
		new ItemDropEvent(this);
		new JoinEvent(this);
		new QuitEvent(this);
		new WeatherEvent(this);
		
		new ServerSelector(this);
		new eu.apexmc.hub.gui.serverselector.ItemClickEvent(this);
		new eu.apexmc.hub.gui.serverselector.ItemInteractEvent(this);
		
		new AdminTool(this);
		new eu.apexmc.hub.gui.admintool.ItemClickEvent(this);
		new eu.apexmc.hub.gui.admintool.ItemInteractEvent(this);
		
		new OwnerTool(this);
		new eu.apexmc.hub.gui.ownertool.ItemClickEvent(this);
		new eu.apexmc.hub.gui.ownertool.ItemInteractEvent(this);
		
	}
	public void onDisable()
	{
		getLogger().info(Variables.pluginName + " v" + Variables.pluginVersion + " has been disabled!");
	}
}
