import Cmd.Command;
import Cmd.CommandContext;
import Cmd.Ping;
import Cmd.SpamTest;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public final class CommandManager {
    private final ArrayList<Command> commands = new ArrayList<>();
    public CommandManager(){
        addCommand(
                new Ping(),
                new SpamTest()
        );
    }

    private void addCommand(Command... cmd) {
        for (Command c : cmd) {
            boolean found = this.commands.stream().anyMatch( (command) -> command.getName().equalsIgnoreCase(c.getName()) );
            if (found) {
                throw new IllegalArgumentException("Command already present!");
            }
            commands.add(c);
        }
    }

    public Command getCommand(String query) {
        String parsedQuery = query.toLowerCase(Locale.ROOT);

        for (Command cmd : this.commands) {
            if (cmd.getName().equals(parsedQuery)) return cmd;
        }

        return null;
    }

    public void handle(MessageReceivedEvent event) {
        // Bruh argument parsing
        String[] args = event.getMessage().getContentRaw().replaceFirst("(?i)" + Pattern.quote(Config.get("prefix")),"").split("\\s+");
        String toInvoke = args[0].toLowerCase(Locale.ROOT);
        Command cmd = this.getCommand(toInvoke);

        if (cmd == null) {
            event.getChannel().sendMessage("Command does not exist!").queue();
            return;
        }

        event.getChannel().sendTyping().queue();

        // More bruh arg parsing
        List<String> commandArgs = Arrays.asList(args).subList(1,args.length);

        cmd.handle(new CommandContext(event, commandArgs));
    }
}
