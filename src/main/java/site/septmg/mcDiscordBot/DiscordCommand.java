package site.septmg.mcDiscordBot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DiscordCommand implements CommandExecutor {
	
	private Main main;
	

	public DiscordCommand(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(!(sender.hasPermission(main.getPermission()) || sender.isOp())) return false;
		
		if (args.length == 0) {
			sender.sendMessage("§cUsage : /discord [message]");
			return false;
		}
		
		StringBuilder Msg = new StringBuilder();
		
		for(String argument : args) {
			Msg.append(argument + " ");
		}
		
		try {
			main.getJDA().getTextChannelById(main.getConfig().getString("TextChannelID")).canTalk();
		} catch (Exception e) {
			System.out.println(e);
			Main.sendToSender(sender, "§cA problem has arisen");
			return false;
		}
		
		
		main.getJDA().getTextChannelById(main.getConfig().getString("TextChannelID")).sendMessage(Msg).queue();
		Main.sendToSender(sender, "§aThe message was sent !");
		
		return true;
	}

}
