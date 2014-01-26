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
     */
    public static Object load(String location) {

        Object obj = null;

        // Create a default Xstream.
        XStream xstream = new XStream(new DomDriver());

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
     * @author Dorian LIZARRALDE
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
     * Store the list of equipment.
     * 
     * @author Dorian LIZARRALDE
     * 
     */
    public static void storeEquipment() {

        // Create an empty list of equipment.
        List<Equipment> equipment = new ArrayList<Equipment>();

        // Add equipment.
        equipment.add(new Camera("Camera", "Description"));
        equipment.add(new Headphones("Headphones", "Description"));
        equipment.add(new Phone("Phone", "Description", OS.ANDROID));
        equipment.add(new Tablet("Tablet", "Description", OS.IOS));

        store(equipment, "./data/EQUIPMENT_LIST.xml");
    }

    /**
     * Store the list of loans.
     * 
     * @author Dorian LIZARRALDE
     * 
     */
    public static void storeLoans() {

        List<Loan> loans = new ArrayList<Loan>();

        store(loans, "./data/LOANS_LIST.xml");
    }

    /**
     * Store the list of loans on hold.
     * 
     * @author Dorian LIZARRALDE
     * 
     */
    public static void storeOnHold() {

        List<Loan> onHold = new ArrayList<Loan>();

        store(onHold, "./data/ON_HOLD_LIST.xml");
    }

    /**
     * Store the list of users.
     * 
     * @author Dorian LIZARRALDE
     * 
     */
    public static void storeUsers() {

        // Create an empty list of users.
        List<User> users = new ArrayList<User>();

        // Add users.
        users.add(new Administrator("Jean-Philippe", "KHA"));
        users.add(new Student("Dorian", "LIZARRALDE", "SI3 - 2013"));
        users.add(new Teacher("Mamadou Falou", "SECK", "IPA"));

        store(users, "./data/USERS_LIST.xml");
    }

    /**
     * Store the program's lists.
     * 
     * @author Dorian LIZARRLADE
     * @param args
     */
    public static void main(String[] args) {

        storeEquipment();
        storeLoans();
        storeOnHold();
        storeUsers();
    }
}
