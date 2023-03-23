package site.septmg.mcDiscordBot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BukkitListener implements Listener {
	private Main main;
	
	public BukkitListener(Main main) {
		this.main = main;
	}
	
	@EventHandler
	 public void PlayerJoin(PlayerJoinEvent event) {
		Main.playerOnlineCount += 1;
		main.reloadStatus();
		
		
	}
	
	
	@EventHandler
	public void PlayerLeft(PlayerQuitEvent event) {
		Main.playerOnlineCount -= 1;
		main.reloadStatus();
	}
}
