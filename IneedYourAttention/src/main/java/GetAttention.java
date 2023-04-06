// I-Need-Your-Attention-Bot GetAttention class
// AUTH: @v0ncent
// This command has to be in the default package in order to use the Listener class
// I have no idea why ¯\_(ツ)_/¯
import Cmd.Command;
import Cmd.CommandContext;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import java.util.List;

public class GetAttention implements Command {

    // spams targeted user until they respond in same channel that command was invoked
    @Override
    public void handle(CommandContext ctx) {
        final TextChannel channel = ctx.getTextChannel();
        boolean hasMessaged = false;
        final List<Member> mentionedMembers = ctx.getMessage().getMentions().getMembers();


        if (mentionedMembers.isEmpty()) {
            channel.sendMessage("You must mention a user to get the attention of!").queue();
            return;
        }

        final Member target = mentionedMembers.get(0);
        while (!hasMessaged) {
            channel.sendMessage("Need your attention " + target.getUser().getAsMention()  + " !").queue();

            if (LastMessenger.getLastMessenger() == target.getIdLong()) {
                hasMessaged = true;
            }

        }

        channel.sendMessage("Attention received!").queue();
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
