package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesManager.class);

    private final static String pathToPropertiesFile = "src\\main\\resources\\application.properties";

    private final String driverKey;
    private final String driverPath;
    private final String name;
    private final String password;
    private final String url;

    public PropertiesManager() {
        File file = new File(pathToPropertiesFile);
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(file));
        } catch (IOException e) {
            logger.info("File \"application.properties\" is not found");
        }

        driverKey = properties.getProperty("driverKey");
        driverPath = properties.getProperty("driverPath");
        name = properties.getProperty("name");
        password = properties.getProperty("password");
        url = properties.getProperty("url");

    }

    public String getDriverKey() {
        return driverKey;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
