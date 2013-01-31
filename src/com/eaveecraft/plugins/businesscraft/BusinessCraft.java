package com.eaveecraft.plugins.businesscraft;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

public class BusinessCraft extends JavaPlugin{
	public void onEnable(){
		this.saveDefaultConfig();
		
		if (this.getConfig().getBoolean("debug") == true) {
			getLogger().info("Debug is set to true");	
		}
		getServer().getPluginManager().registerEvents(new BusinessCraftListener(), this);
		BukkitTask task = getServer().getScheduler().runTaskTimerAsynchronously(this, new BusinessCraftTasks(), 60L, 200L);
		getCommand("createbusiness").setExecutor(new BusinessCraftCommands());
		getLogger().info("BusinessCraft has been enabled");
	}
	public void onDisable(){
		getLogger().info("BusinessCraft has been disabled");
	}
	 public static Permission permission = null;
	    public static Economy economy = null;
	    public static Chat chat = null;

	    private boolean setupPermissions()
	    {
	        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
	        if (permissionProvider != null) {
	            permission = permissionProvider.getProvider();
	        }
	        return (permission != null);
	    }

	    private boolean setupChat()
	    {
	        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
	        if (chatProvider != null) {
	            chat = chatProvider.getProvider();
	        }

	        return (chat != null);
	    }

	    private boolean setupEconomy()
	    {
	        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	        if (economyProvider != null) {
	            economy = economyProvider.getProvider();
	        }

	        return (economy != null);
	    }
}
