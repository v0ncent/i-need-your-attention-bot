// I-Need-Your-Attention-Bot Log class
// AUTH: @v0ncent
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Log {
    private Log(){
    }

    /**
     * Logging type.
     */
    enum LogType {
        ERROR,
        INFO,
        WARNING
    }

    /**
     * Logs to the console passed in info from the passed in class in the logging format
     * given from the passed type.
     * @param clazz Class to log from.
     * @param info Information to be sent to console.
     * @param logType Type of logging to be sent out.
     */
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
