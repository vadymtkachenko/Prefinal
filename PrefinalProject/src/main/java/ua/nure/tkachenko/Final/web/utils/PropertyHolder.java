package ua.nure.tkachenko.Final.web.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHolder {

    private static  PropertyHolder instance;
    public static synchronized PropertyHolder getInstance() {
        if(instance == null){
            instance = new PropertyHolder();;
        }
        return instance;
    }

    public String getCommandClass(String key) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            // load a properties file
            System.out.println(key);
            input = PropertyHolder.class.getClassLoader().getResourceAsStream("command_container.properties");
            System.out.println(input);
            prop.load(input);
            // get the property value and print it outs
            String numStr = prop.getProperty(key);
            System.out.println(numStr);
            return numStr;

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
