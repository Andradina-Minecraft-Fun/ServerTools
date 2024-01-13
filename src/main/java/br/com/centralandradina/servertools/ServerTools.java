package br.com.centralandradina.servertools;

import br.com.centralandradina.servertools.Spawns.SpawnListener;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;




public class ServerTools extends JavaPlugin
{
	@Override
	public void onLoad() { }

	@Override
	public void onEnable()
	{
		// save default config
		if (!new File(getDataFolder(), "config.yml").exists()) {
    		saveResource("config.yml", false);
		}

		// register listeners
		getServer().getPluginManager().registerEvents(new SpawnListener(this), this);

		// commands
		this.getCommand("servertools").setExecutor(new Commands(this));
	}

	@Override
	public void onDisable() { }
}