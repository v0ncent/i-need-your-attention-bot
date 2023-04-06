package Cmd;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageReader extends ListenerAdapter {
    private static User lastSpoken = null;
    private static TextChannel inChannel = null;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        lastSpoken = event.getAuthor();
        inChannel = event.getChannel().asTextChannel();
    }

    public static User getLastSpoken(){
        return lastSpoken;
    }

    public static Channel getInChannel() {
        return inChannel;
    }
}
