package me.temaflux.cactusdd;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
extends JavaPlugin
implements Listener {
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		HandlerList.unregisterAll((Listener) this);
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onDamage(EntityDamageEvent e) {
		if (e instanceof EntityDamageByBlockEvent) {
			EntityDamageByBlockEvent be = (EntityDamageByBlockEvent) e;
			if (be.getDamager().getType().name().toUpperCase().indexOf("CACTUS") != -1 ? true : false) {
				e.setDamage(0D);
				e.setCancelled(true);
			}
		}
	}
}
