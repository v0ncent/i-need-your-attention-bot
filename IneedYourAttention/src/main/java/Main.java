// I-Need-Your-Attention-Bot Main class
// AUTH: @v0ncent
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
   /**Instance of discord bot from developer token.*/
    private static final JDABuilder BOT = JDABuilder.createDefault(Config.get("token"));

    /**
     * Enables all gateway intents and cache policies
     * needed for bot functionality.
     */
    private static void enableAllIntents() {
        BOT.setChunkingFilter(ChunkingFilter.ALL);
        BOT.setMemberCachePolicy(MemberCachePolicy.ALL);
        BOT.enableIntents(GatewayIntent.GUILD_MEMBERS);
        BOT.enableCache(CacheFlag.VOICE_STATE);
        BOT.enableIntents(GatewayIntent.GUILD_MEMBERS);
        BOT.enableIntents(GatewayIntent.GUILD_MESSAGES);
        BOT.enableIntents(GatewayIntent.GUILD_VOICE_STATES);
        BOT.enableIntents(GatewayIntent.GUILD_MEMBERS);
        BOT.enableIntents(GatewayIntent.DIRECT_MESSAGE_REACTIONS);
        BOT.enableIntents(GatewayIntent.DIRECT_MESSAGES);
        BOT.enableIntents(GatewayIntent.GUILD_EMOJIS_AND_STICKERS);
        BOT.enableIntents(GatewayIntent.GUILD_MESSAGE_TYPING);
        BOT.enableIntents(GatewayIntent.GUILD_PRESENCES);
        BOT.enableIntents(GatewayIntent.GUILD_INVITES);
        BOT.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        BOT.enableIntents(GatewayIntent.GUILD_MODERATION);
        BOT.enableIntents(GatewayIntent.SCHEDULED_EVENTS);
    }

    public static void main(String[] args) {
        // gateway intent stuff - Set event listeners and statuses - Build the bot (aka have it log in)
        BOT.setActivity(Activity.competing("Getting your attention the right way"));
        BOT.setStatus(OnlineStatus.ONLINE);

        BOT.addEventListeners(new Listener(), new LastMessenger());

        enableAllIntents();

        BOT.build();
    }
}
