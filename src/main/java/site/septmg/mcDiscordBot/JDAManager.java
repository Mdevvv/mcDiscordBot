package site.septmg.mcDiscordBot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.exceptions.InvalidTokenException;

public class JDAManager {
	
	public static JDA buildJDA(String token) {
		
		try {
			return JDABuilder.createDefault(token)
					.addEventListeners()
					.setStatus(OnlineStatus.ONLINE)
					.build().awaitReady();
					
					
					/*.setToken()
					.setShardsTotal(1)
					.addEventListeners(new BotListener())
					.build();*/
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidTokenException e) {
			Main.sendConsole("§cdiscord token not work");
		}
		
		return null;
	}

}
