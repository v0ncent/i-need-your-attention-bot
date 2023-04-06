// I-Need-Your-Attention-Bot Config class
// AUTH: @v0ncent
import io.github.cdimascio.dotenv.Dotenv;
import java.util.Locale;

public final class Config {
    private Config(){
    }

    private static final Dotenv ENV = Dotenv.load();

    /**
     * Retrieves information from the .env file based upon the given key.
     * @param key Field to be retrieved.
     * @return The .env information stored in the given key.
     */
    public static String get(String key){
        return ENV.get(key.toUpperCase(Locale.ROOT));
    }
}
