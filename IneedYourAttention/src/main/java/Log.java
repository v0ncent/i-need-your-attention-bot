import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Log {
    private Log(){
    }

    enum LogType {
        ERROR,
        INFO,
        WARNING
    }

    public static void log(Class<?> clazz, String info, LogType logType) {
        Logger LOGGER = LoggerFactory.getLogger(clazz);

        if (logType == LogType.ERROR) {
            LOGGER.error(info);
            return;
        }

        if (logType == LogType.WARNING) {
            LOGGER.warn(info);
            return;
        }

        LOGGER.info(info);
    }
}
