package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import management.Loan;

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

        Object obj = null;

        try {

            // Open a buffer.
            FileInputStream in = new FileInputStream(location);

            // Load.
            obj = xstream.fromXML(in);

            // Close the buffer.
            in.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return obj;
    }

    /**
     * Store the object in the location parameter.
     * 
     * @author Dorian Lizarralde
     * @param obj
     *            The object to store.
     * @param location
     *            The location of the xml file.
     */
    public static void store(Object obj, String location) {

        // Create a default Xstream.
        XStream xstream = new XStream(new DomDriver());

        try {

            // Open a buffer.
            FileOutputStream out = new FileOutputStream(location);

            // Store.
            xstream.toXML(obj, out);

            // Close the buffer.
            out.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Store the list of equipment in the location parameter.
     * 
     * @author Dorian LIZARRALDE
     * @param location
     *            The location of the xml file.
     */
    public static void storeEquipment(String location) {

        // Create an empty list of equipment.
        List<Equipment> equipment = new ArrayList<Equipment>();

        // Add equipment.
        equipment.add(new Camera("Description", "Camera"));
        equipment.add(new Headphones("Description", "Headphones"));
        equipment.add(new Phone("Description", "Phone", OS.ANDROID));
        equipment.add(new Tablet("Description", "Tablet", OS.IOS));

        store(equipment, location);
    }

    /**
     * Store the list of loans in the location parameter.
     * 
     * @author Dorian LIZARRALDE
     * @param location
     *            The location of the xml file.
     */
    public static void storeLoans(String location) {

        List<Loan> loans = new ArrayList<Loan>();

        store(loans, location);
    }

    /**
     * Store the list of users in the location parameter.
     * 
     * @author Dorian LIZARRALDE
     * @param location
     *            The location of the xml file.
     */
    public static void storeUsers(String location) {

        // Create an empty list of users.
        List<User> users = new ArrayList<User>();

        // Add users.
        users.add(new Administrator("Jean-Philippe", "KHA"));
        users.add(new Student("Dorian", "LIZARRALDE", "SI3 - 2013"));
        users.add(new Teacher("Mamadou Falou", "SECK", "IPA"));

        store(users, location);
    }

    /**
     * Store the program's lists.
     * 
     * @author Dorian LIZARRLADE
     * @param args
     */
    public static void main(String[] args) {

        storeEquipment("./data/EQUIPMENT_LIST.xml");
        storeLoans("./data/LOANS_LIST.xml");
        storeUsers("./data/USERS_LIST.xml");
    }
}
