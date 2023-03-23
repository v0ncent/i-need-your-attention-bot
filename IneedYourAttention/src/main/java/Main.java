import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public final class Main {
    private Main(){
    }

    private static final JDABuilder BOT = JDABuilder.createDefault(Config.get("token"));

    public static void main(String[] args) {
        // gateway intent stuff - Set event listeners and statuses - Build the bot
        BOT.setActivity(Activity.competing("Getting your attention the right way"));
        BOT.setStatus(OnlineStatus.ONLINE);

        BOT.addEventListeners(new Listener());

        BOT.setChunkingFilter(ChunkingFilter.ALL);
        BOT.setMemberCachePolicy(MemberCachePolicy.ALL);
        BOT.enableIntents(GatewayIntent.GUILD_MEMBERS);
        BOT.enableCache(CacheFlag.VOICE_STATE);
        BOT.enableIntents(GatewayIntent.GUILD_MEMBERS);

        BOT.build();
    }
}
