// I-Need-Your-Attention-Bot CommandManager class
// AUTH: v0ncent
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public final class CommandManager {
    /**List of all bot commands*/
    private final ArrayList<Command> commands = new ArrayList<>();

    /**
     * Creates an instance of Command Manager and populates
     * the list of commands to be invoked.
     */
    public CommandManager(){
        addCommand(
                new Ping(),
                new GetAttention()
        );
    }

    /**
     * Adds all passed command instances to the command list.
     * @param cmd Command Instances to be added to list and set up to be invoked.
     */
    private void addCommand(Command... cmd) {
        for (Command c : cmd) {
            boolean found = this.commands.stream().anyMatch( (command) -> command.getName().equalsIgnoreCase(c.getName()) );
            if (found) {
                throw new IllegalArgumentException("Command already present!");
            }
            commands.add(c);
        }
    }

    /**
     * Gets the wanted Command from the Command list.
     * @param query Name of Command
     * @return The Command stored within the Command list, Null if not found.
     */
    public Command getCommand(String query) {
        String parsedQuery = query.toLowerCase(Locale.ROOT);

        for (Command cmd : this.commands) {
            if (cmd.getName().equals(parsedQuery)) return cmd;
        }

        return null;
    }

    /**
     * Handles command invoking from message starting with prefix.
     * @param event Message containing wanted command to invoke.
     */
    public void handle(MessageReceivedEvent event, LastMessaged lastMessaged) {
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


        cmd.handle(new CommandContext(event, commandArgs), lastMessaged);
    }
}
