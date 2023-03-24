package Cmd;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class SpamTest implements Command {

    @Override
    public void handle(CommandContext ctx) {
        TextChannel channel = ctx.getChannel();
        String desiredUser = ctx.getArgs().get(0);

        for (int i  = 0; i < 1500; i++) {
            channel.sendMessage(desiredUser).queue();
        }

    }

    @Override
    public String getName() {
        return "spam";
    }

    @Override
    public String getHelp() {
        return "Just a test";
    }

    @Override
    public String getType() {
        return "test";
    }
}
