// I-Need-Your-Attention-Bot Command interface
// AUTH: @v0ncent
package Cmd;

public interface Command {
    /**Execution of command.*/
    void handle(CommandContext ctx);
    /**Name of command.*/
    String getName();
    /**Help instructions of command.*/
    String getHelp();
    /**Command type.*/
    String getType();
}
