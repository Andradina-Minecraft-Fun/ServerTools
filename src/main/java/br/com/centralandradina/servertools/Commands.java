package br.com.centralandradina.servertools;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor
{
	protected ServerTools plugin;

	/**
	 * constructor
	 */
	public Commands(ServerTools plugin)
	{
		this.plugin = plugin;
	}

	/**
	 * on command execution
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		// reload
		if(args[0].equals("reload")) {
			this.plugin.reloadConfig();
			sender.sendMessage("ServerTools config reloaded");
			return true;
		}

		return false;
	}
}
