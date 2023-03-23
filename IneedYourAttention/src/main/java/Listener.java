import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public final class Listener extends ListenerAdapter {
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
    }
}
