package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import equipment.Equipment;
import equipment.OS;
import equipment.solid.Camera;
import equipment.solid.Headphones;
import equipment.solid.Phone;
import equipment.solid.Tablet;
import user.Administrator;
import user.Student;
import user.Teacher;
import user.User;

/**
 * Store and load objects on xml files.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Data {

    /**
     * Load the object located in the location parameter.
     * 
     * @author Dorian LIZARRALDE
     * @param location
     *            The location of the xml file.
     * @return
     */
    public static Object load(String location) {

        // Create a default Xstream.
        XStream xstream = new XStream(new DomDriver());

        Object o = null;

        try {

            // Open a buffer.
            FileInputStream in = new FileInputStream(location);

            // Load.
            o = xstream.fromXML(in);

            // Close the buffer.
            in.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return o;
    }

    /**
     * Store the object in the location parameter.
     * 
     * @author Dorian Lizarralde
     * @param o
     *            The object to store.
     * @param location
     *            The location of the xml file.
     */
    public static void store(Object o, String location) {

        // Create a default Xstream.
        XStream xstream = new XStream(new DomDriver());

        try {

            // Open a buffer.
            FileOutputStream out = new FileOutputStream(location);

            // Store.
            xstream.toXML(o, out);

            // Close the buffer.
            out.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Store the list of users in the location parameter.
     * 
     * @author Dorian LIZARRALDE
     * @param location
     *            The location of the xml file.
     */
    public static void storeUserList(String location) {

        // Create an empty list of users.
        List<User> users = new ArrayList<User>();

        // Add users.
        users.add(new Administrator("KHA", "Jean-Philippe"));
        users.add(new Student("LIZARRALDE", "Dorian", "SI3 - 2013"));
        users.add(new Teacher("SARMIENTO", "Sergio", "Communication"));

        store(users, location);
    }

    /**
     * Store the materials list in the location parameter.
     * 
     * @author Dorian LIZARRALDE
     * @param location
     *            The location of the xml file.
     */
    public static void storeMaterialsList(String location) {

        // Create an empty list of materials.
        List<Equipment> materials = new ArrayList<Equipment>();

        // Add the materials.
        materials.add(new Camera("Nokia 850", "Description of the Nokia 850"));
        materials.add(new Headphones("Dr Dre", "Description of the Dr Dre"));
        materials.add(new Phone("HTC One", "Description of the HTC One",
                OS.ANDROID));
        materials.add(new Tablet("iPad", "Description of the HTC One", OS.IOS));

        store(materials, location);
    }

    /**
     * Store the program's lists.
     * 
     * @author Dorian LIZARRLADE
     * @param args
     */
    public static void main(String[] args) {

        storeUserList("./data/USERS_LIST.xml");
        storeMaterialsList("./data/MATERIALS_LIST.xml");
    }
}
