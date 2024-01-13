package br.com.centralandradina.servertools.Spawns;

import br.com.centralandradina.servertools.ServerTools;
import java.util.Random;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

/**
 * listener for spawn events
 */
public class SpawnListener implements Listener
{
	protected ServerTools plugin;
	private static final Random RANDOM = new Random();

	/**
	 * constructor
	 */
	public SpawnListener(ServerTools plugin)
	{
		this.plugin = plugin;
	}

	/**
	 * event when a creature spawn
	 */
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void nerfIronGolemSpawns(CreatureSpawnEvent event) 
	{
		// check is entity need to be nerfed
		String entityKey = "spawn.nerfs." + event.getEntityType().toString();
		if(this.plugin.getConfig().contains(entityKey)) {

			// loop reasons
			for(String reason : this.plugin.getConfig().getConfigurationSection(entityKey).getKeys(false)) {
				if(reason.equals(event.getSpawnReason().toString())) {
					// get chance
					Double chance = this.plugin.getConfig().getDouble(entityKey + "." + reason);

					// Check the spawn chance
					if (!(RANDOM.nextDouble() <= (chance / 100))) {
						event.getEntity().remove();
					}
				}
			}
		}
	}
}
