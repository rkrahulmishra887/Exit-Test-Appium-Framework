package com.demoApp.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;




public class PropertyFileReader {

    private static Properties properties;
    private static FileInputStream demofileInputStream;

    static {
        properties = new Properties();
        loadAppProperties();
        setSystemProperties();

    }

    public static void loadAppProperties() {
        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator +
                "java" + File.separator + "com" + File.separator + "demoApp" + File.separator + "config" + File.separator + "demoApp.properties");

        try {
            demofileInputStream = new FileInputStream(file);
            properties.load(demofileInputStream);
            demofileInputStream.close();
            Log.info("Info : Loading config properties");
        } catch (FileNotFoundException e) {
            Log.info("Error : config properties file missing or corrupted - " + e);
            throw new RuntimeException("Error : config properties file missing or corrupted - " + e);
        } catch (IOException e) {
            Log.info("Error : Loading config properties - " + e);
            throw new RuntimeException("Error : Loading config properties - " + e);
        }
    }


    public static void setSystemProperties() {
        System.setProperty("android_app", properties.getProperty("android_app"));
        System.setProperty("android_package_name", properties.getProperty("android_package_name"));
    }
}