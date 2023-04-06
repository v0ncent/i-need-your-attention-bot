import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class LastMessenger extends ListenerAdapter {

    /**ID of last person who has sent a message to the discord, default is 0*/
    private static long lastMessenger = 0;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        setLastMessenger(event.getAuthor().getIdLong());
    }

    // utility
    public static long getLastMessenger() {
        return lastMessenger;
    }

    private static void setLastMessenger(long id) {
        lastMessenger = id;
    }

}
