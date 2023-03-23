package site.septmg.mcDiscordBot;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;

public class Main extends JavaPlugin {
	
	private JDA jda;
	private String permission;
	public static int playerOnlineCount = 0;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		permission = getConfig().getString("Command-permission");
		playerOnlineCount = Bukkit.getOnlinePlayers().size();
		jda = JDAManager.buildJDA(getConfig().getString("Token"));
		reloadStatus();
		getCommand("discord").setExecutor(new DiscordCommand(this));
		getCommand("discordReload").setExecutor(new RlCommand());
		Bukkit.getPluginManager().registerEvents(new BukkitListener(this), this);
		
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		jda.getVoiceChannelById(getConfig().getString("VocalChannelInfoID")).getManager().setName("Server offline").queue();
		super.onDisable();
	}
	
	
	public JDA getJDA() {
		if(jda == null) Main.sendConsole("§6[MCDiscordBot]§c discord bot not connected");
		return jda;
	}
	
	public class RlCommand implements CommandExecutor {

		@Override
		public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
			if(!(sender.hasPermission(getPermission()) || sender.isOp())) return false;
			reloadConfig();
			permission = getConfig().getString("Command-permission");
			sendToSender(sender,"§aConfig.yml Reload !");
			return true;
		}
	}
	
	public String getPermission() {
		return permission;
	}
	
	public static void sendConsole(String arg) {
		Bukkit.getConsoleSender().sendMessage("§6[MCDiscordBot] " + arg);
		
	}
	
	public static void sendToSender(CommandSender sender, String arg) {
		sender.sendMessage("§6[MCDiscordBot] " + arg);
	}
	
	public void reloadStatus() {
		String status = playerOnlineCount + "/"+ Bukkit.getMaxPlayers() +" player(s)";
		jda.getPresence().setActivity(Activity.playing(status));
		if(!getConfig().get("OnableVocalChannelInfoID").equals("false")) {
			jda.getVoiceChannelById(getConfig().getString("VocalChannelInfoID")).getManager().setName(playerOnlineCount +" player(s) online" ).queue();
		}
		else {
			sendConsole(jda.getVoiceChannelById(getConfig().getString("VocalChannelInfoID")).getName());
			if(!jda.getVoiceChannelById(getConfig().getString("VocalChannelInfoID")).getName().equals("Server Online")) {
				jda.getVoiceChannelById(getConfig().getString("VocalChannelInfoID")).getManager().setName("Server Online").queue();
			}
		}
	}

}
