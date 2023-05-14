package org.example;

import javafx.stage.Stage;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class handsDown extends ListenerAdapter{
    public static void main(String[] args) throws LoginException {
    {
        JDA jda = JDABuilder.createDefault("OTE2OTQ0Nzk4NDA4MTM0NzE2.Gujl4p.IQzPAAk1ovzpM0NrSQLHisUctfug7HvdmauiyY").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("삐그덕 손 내려 봇"));

        jda.addEventListener(new handsDown());
    }
}
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ",3);
        String prefix = "ping ";

        if (!event.getAuthor().isBot()) {
            if (args[0].equals(prefix+" ")) {
                if(args.length == 1) {  // want: 앞의 명령어 배열빼고 출력하기~
                    event.getChannel().sendMessage("ping <code>").queue();
                } else {
                    //String content = "```\n" + event.getMessage().getContentRaw() + "\n```";
                    for(int i = 1; i < args.length-1; i++){
                        event.getChannel().sendMessage("```\n"+args[i]+ "\n```").queue();
                    }
                }
            }
        }
    }
}

