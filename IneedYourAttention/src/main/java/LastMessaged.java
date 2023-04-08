import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;

/**
 * Object for reading incoming messages in Guild channels.
 */
public final class LastMessaged {
    /**The user who has sent the most recent message to the Guild.*/
    private User lastMessaged;
    /**The TextChannel that the most recent message was sent in.*/
    private Channel inChannel;

    public LastMessaged(){
        lastMessaged = null;
        inChannel = null;
    }

    public void setInChannel(Channel inChannel) {
        this.inChannel = inChannel;
    }

    public void setLastMessaged(User lastMessaged) {
        this.lastMessaged = lastMessaged;
    }

    public User getLastMessaged() {
        return lastMessaged;
    }

    public Channel getInChannel() {
        return inChannel;
    }

}
