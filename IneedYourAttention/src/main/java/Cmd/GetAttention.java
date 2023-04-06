package Cmd;

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

            if (MessageReader.getLastSpoken() == target.getUser() && MessageReader.getInChannel() == channel) {
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
