package Cmd;

public interface Command {
    void handle(CommandContext ctx);
    String getName();
    String getHelp();
    String getType();
}
