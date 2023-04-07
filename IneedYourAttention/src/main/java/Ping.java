// I-Need-Your-Attention-Bot Ping class
// AUTH: v0ncent

import net.dv8tion.jda.api.JDA;

public class Ping implements Command{

    @Override
    public void handle(CommandContext ctx, LastMessaged lastMessaged) {
        JDA jda = ctx.getJDA();
        jda.getRestPing().queue(
                (ping) -> ctx.getTextChannel()
                        .sendMessageFormat("Reset ping: %sms\nWS ping: %sms", ping, jda.getGatewayPing()).queue()
        );
    }

    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public String getHelp() {
        return "Shows bots current ping.";
    }

    @Override
    public String getType() {
        return "utility";
    }
}
