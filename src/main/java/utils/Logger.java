package utils;
import org.apache.log4j.BasicConfigurator;

public class Logger {

    public static final org.apache.log4j.Logger L = org.apache.log4j.Logger.getLogger(Logger.class);

    public static Logger instance = null;

    {
        BasicConfigurator.configure();
    }

    private Logger() {}


    public static Logger getInstance() {
        if (instance == null)
            synchronized (Logger.class) {
                instance = new Logger();
            }
        return instance;
    }


    public void info(String parameter) {
        L.info(parameter);
    }

    public void debug(String parameter) {
        L.debug(parameter);
    }

    public void warn(String parameter) {
        L.warn(parameter);
    }

    public void err(String parameter) {
        L.error(parameter);
    }


}