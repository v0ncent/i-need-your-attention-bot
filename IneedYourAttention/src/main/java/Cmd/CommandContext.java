// I-Need-Your-Attention-Bot CommandContext class
// AUTH: v0ncent
package Cmd;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.sharding.ShardManager;
import java.util.List;

public final class CommandContext {
    /**Command from message to create context of*/
    private final MessageReceivedEvent event;
   /**Provided command arguments from message.*/
    private final List<String> args;

    /**
     * Creates an instance of CommandContext from the given message
     * and arguments.
     * @param event Command message to create context for.
     * @param args Arguments to create context for.
     */
    public CommandContext(MessageReceivedEvent event, List<String> args) {
        this.event = event;
        this.args = args;
    }

    public Guild getGuild() {
        return this.getEvent().getGuild();
    }

    public MessageReceivedEvent getEvent() {
        return this.event;
    }

    public JDA getJDA() {
        return this.event.getJDA();
    }

    public List<String> getArgs() {
        return this.args;
    }

    public TextChannel getTextChannel() {
        return this.getEvent().getChannel().asTextChannel();
    }

    public VoiceChannel getVoiceChannel() {
        return this.getEvent().getChannel().asVoiceChannel();
    }

    public Message getMessage() {
        return this.getEvent().getMessage();
    }

    public User getAuthor() {
        return this.getEvent().getAuthor();
    }

    public Member getMember() {
        return this.getEvent().getMember();
    }

    public ShardManager getShardManager() {
        return this.getJDA().getShardManager();
    }

    public User getSelfUser() {
        return this.getJDA().getSelfUser();
    }

    public Member getSelfMember() {
        return this.getGuild().getSelfMember();
    }
}
