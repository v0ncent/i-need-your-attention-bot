// I-Need-Your-Attention-Bot GetAttention class
// AUTH: @v0ncent
// This command has to be in the default package in order to use the Listener class ( so much bruh shit in this project I swear )
// I have no idea why ¯\_(ツ)_/¯
// ignore the above comment actually fucking everything needs to be in one package. Why? I HAVE NO FUCKING IDEA !!!
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import java.util.List;

public class GetAttention implements Command {
    // spams targeted user until they respond in same channel that command was invoked
    @Override
    public void handle(CommandContext ctx, LastMessaged lastMessaged) {
        final TextChannel channel = ctx.getTextChannel();
        final List<Member> mentionedMembers = ctx.getMessage().getMentions().getMembers();

        if (mentionedMembers.isEmpty()) {
            channel.sendMessage("You must mention a user to get the attention of!").queue();
            return;
        }

        final Member target = mentionedMembers.get(0);



    }

    @Override
    public String getName() {
        return "getattention";
    }

    @Override
    public String getHelp() {
        return "Spams the mentioned user until they respond in same channel that the command was invoked.";
    }

    @Override
    public String getType() {
        return "Spam";
    }
}
