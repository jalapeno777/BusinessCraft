package com.eaveecraft.plugins.businesscraft;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BusinessCraftCommands implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if (cmd.getName().equalsIgnoreCase("createbusiness")){
			if (!(sender instanceof Player)) {
				sender.sendMessage("You cannot use this command from Console");
			}
			if(args.length == 1){
				sender.sendMessage(args[0]);
			} else {
				sender.sendMessage("Incorrect Number of Arguments");
			}
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("checkfunds")){
			Player p = (Player) sender;
			sender.sendMessage("Attempting command");
			//sender.sendMessage("You currently have $" + BusinessCraft.economy.getBalance(p.getName()));
			return true;
		}
		else { sender.sendMessage("it failed"); }
		return false;
	}
}
