package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class LoggerHandler {

    private static final Logger logger = Logger.getLogger(LoggerHandler.class);

    static {
        try {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String logFileName = "logs/logfile_" + timestamp + ".log";

            FileAppender fileAppender = new FileAppender(
                    new PatternLayout("%d{ISO8601} %-5p %c - %m%n"),
                    logFileName,
                    true);

            logger.addAppender(fileAppender);
            logger.setAdditivity(false);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }
}
