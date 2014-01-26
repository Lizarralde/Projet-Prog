package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Store and load configuration files.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Config {

    // Default property.
    public static Properties property;

    /**
     * Load the property in the location parameter.
     * 
     * @author Dorian LIZARRALDE
     * @param location
     *            The location of the configuration file.
     */
    public static void load(String location) {

        InputStream in;

        property = new Properties();

        try {

            // Open a buffer.
            in = new FileInputStream(location);

            // Load.
            property.load(in);

            // Close the buffer.
            in.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Store the property in the location parameter.
     * 
     * @author Dorian LIZARRALDE
     * @param map
     *            The map to store.
     * @param location
     *            The location of the configuration file.
     */
    public static void store(Map<String, String> map, String location) {

        OutputStream out;

        String key;

        property = new Properties();

        try {

            // Open a buffer.
            out = new FileOutputStream(location);

            Iterator<String> iterator = map.keySet().iterator();

            // Add properties.
            while (iterator.hasNext()) {

                key = iterator.next();

                property.setProperty(key, map.get(key));
            }

            // Store.
            property.store(out, null);

            // Close the buffer.
            out.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Store the program's configuration.
     * 
     * @author Dorian LIZARRALDE
     * 
     */
    public static void storeConfig() {

        Map<String, String> map = new HashMap<String, String>();

        map.put("Mode", "Manual");
        map.put("Durability", "0.05");

        store(map, "./config/CONFIG.txt");
    }

    /**
     * Store the program's configuration.
     * 
     * @author Dorian LIZARRALDE
     * @param args
     */
    public static void main(String[] args) {

        storeConfig();
    }
}
