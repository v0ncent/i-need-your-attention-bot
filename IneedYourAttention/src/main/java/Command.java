// I-Need-Your-Attention-Bot Command interface
// AUTH: @v0ncent
public interface Command {
    // an instance of LastMessaged object is needed in order to see incoming messaged while commands are being executed because Java is fucking retarded

    /**
     * Commands execution.
     * @param ctx Context to command instance.
     * @param lastMessaged instance of LastMessaged object is needed in order to see incoming messaged while commands are being executed.
     */
    void handle(CommandContext ctx, LastMessaged lastMessaged);
    /**Name of command.*/
    String getName();
    /**Help instructions of command.*/
    String getHelp();
    /**Command type.*/
    String getType();
}
