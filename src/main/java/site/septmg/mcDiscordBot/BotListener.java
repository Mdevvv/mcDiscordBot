package site.septmg.mcDiscordBot;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class BotListener implements EventListener{

	@Override
	public void onEvent(GenericEvent event) {
		if(event instanceof MessageReceivedEvent) onMessage((MessageReceivedEvent) event);
	}
	
	
	public void onMessage(MessageReceivedEvent event) {
		
		
	}

}
