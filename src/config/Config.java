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
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Config {

    public static Properties property;

    public static void load(String location) {

        InputStream in;

        property = new Properties();

        try {

            in = new FileInputStream(location);

            property.load(in);

            in.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void store(Map<String, String> map, String location) {

        OutputStream out;

        String key;

        property = new Properties();

        try {

            out = new FileOutputStream(location);

            Iterator<String> iterator = map.keySet().iterator();

            while (iterator.hasNext()) {

                key = iterator.next();

                property.setProperty(key, map.get(key));
            }

            property.store(out, null);

            out.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void storeConfig() {

        Map<String, String> map = new HashMap<String, String>();

        map.put("Mode", "Auto");

        store(map, "./config/CONFIG.txt");
    }

    public static void main(String[] args) {

        storeConfig();
    }
}
