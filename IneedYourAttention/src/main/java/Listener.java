// I-Need-Your-Attention-Bot Listener class
// AUTH: v0ncent
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listener extends ListenerAdapter {
    /**Prefix used for invoking commands*/
    private final String prefix = Config.get("prefix");
    /**Instance of CommandManager*/
    private final CommandManager manager = new CommandManager();

    private final Const constants = new Const();

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Log.log(Listener.class, "Bot ready and online.", Log.LogType.INFO);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User user = event.getAuthor();

        if (user.isBot() || event.isWebhookMessage() ) {
            return;
        }

        constants.getLastMessaged().setLastMessaged(user);
        constants.getLastMessaged().setInChannel(event.getChannel());

        String raw = event.getMessage().getContentRaw();
        if (raw.startsWith(prefix)) {
            manager.handle(event,this.constants.getLastMessaged());
        }
    }

}
