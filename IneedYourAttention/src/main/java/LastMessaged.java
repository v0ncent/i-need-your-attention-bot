import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;

public final class LastMessaged {
    private User lastMessaged;
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
