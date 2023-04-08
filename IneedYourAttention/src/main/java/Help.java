import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import java.awt.*;

public class Help implements Command {

    @Override
    public void handle(CommandContext ctx, LastMessaged lastMessaged) {
        final TextChannel channel = ctx.getTextChannel();
        final EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("Getting Attention");
        embedBuilder.setDescription(String.format("Usage %sgetattention @target",Config.get("prefix")));
        embedBuilder.addField("Spams the mentioned user until they send a message to the same channel command was executed in."," ",false);
        embedBuilder.setColor(Color.red);
        embedBuilder.setImage(ctx.getSelfMember().getAvatarUrl());

        channel.sendMessageEmbeds(embedBuilder.build()).queue();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getHelp() {
        return "Help command";
    }

    @Override
    public String getType() {
        return "help";
    }
}
