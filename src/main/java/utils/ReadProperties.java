package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    private static Logger L;
    private Properties properties;
    private InputStream inputStream;
    private String resourceName;
    private final ClassLoader loader = Thread.currentThread().getContextClassLoader();


    public ReadProperties() {
        this.init();
    }

    public ReadProperties(Properties properties, InputStream inputStream) {
        this.properties = properties;
        this.inputStream = inputStream;
    }

    public static Logger getL() {
        return L;
    }

    public void init() {
        L = Logger.getInstance();
        this.properties = new Properties();
    }

    public void read(String name) throws IOException {
        this.resourceName = name;
        inputStream = new FileInputStream("src/main/resources/" + this.resourceName);
        this.properties.load(inputStream);
    }

    public Properties getProperties() {
        return properties;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getResourceName() {
        return resourceName;
    }

}
