import io.github.cdimascio.dotenv.Dotenv;

import java.util.Locale;

public final class Config {
    private Config(){
    }

    private static final Dotenv ENV = Dotenv.load();

    public static String get(String key){
        return ENV.get(key.toUpperCase(Locale.ROOT));
    }
}
