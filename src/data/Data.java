package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import objects.Camera;
import objects.Casque;
import objects.MaterialQuantity;
import objects.Phone;
import objects.Tablet;
import objects.TypeOS;
import users.Student;
import users.Teacher;
import users.User;

/**
 * Store and load the users and materials list on xml files.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Data {

    /**
     * Load the users list located in the location parameter.
     * 
     * @author Dorian LIZARRALDE
     * @param location
     *            The location of the xml file.
     * @return
     */
    public static List<User> loadUsersList(String location) {

        // Create a default Xstream.
        XStream xstream = new XStream(new DomDriver());

        // Create an empty list which will hold the users list.
        List<User> users = null;

        try {

            // Open a buffer.
            FileInputStream in = new FileInputStream(location);

            // Load the users list.
            users = (ArrayList<User>) xstream.fromXML(in);

            // Close the buffer.
            in.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return users;
    }

    /**
     * Store the users list in the location parameter.
     * 
     * @author Dorian LIZARRALDE
     * @param location
     *            The location of the xml file.
     */
    public static void storeUserList(String location) {

        // Create an empty list of users.
        List<User> users = new ArrayList<User>();

        // Add the users.
        users.add(new Student("LIZARRALDE", "Dorian", "SI3 - 2013"));
        users.add(new Student("PINEL", "Fabien", "SI3 - 2013"));
        users.add(new Student("SIMOND", "Hugo", "SI3 - 2013"));
        users.add(new Student("BENNI", "Benjamin", "SI3 - 2013"));
        users.add(new Student("SALMERON", "Quentin", "SI3 - 2013"));
        users.add(new Teacher("THUAIRE", "Alain", "Java"));
        users.add(new Teacher("SARMIENTO", "Sergio", "Communication"));

        // Create a default Xstream.
        XStream xstream = new XStream(new DomDriver());

        try {

            // Open a buffer.
            FileOutputStream out = new FileOutputStream(location);

            // Store the users list.
            xstream.toXML(users, out);

            // Close the buffer.
            out.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Load the materials list located in the location parameter.
     * 
     * @author Dorian LIZARRALDE
     * @param location
     *            The location of the xml file.
     * @return
     */
    public static List<MaterialQuantity> loadMaterialsList(String location) {

        // Create a default Xstream.
        XStream xstream = new XStream(new DomDriver());

        // Create an empty list which will hold the materials list.
        List<MaterialQuantity> materials = null;

        try {

            // Open a buffer.
            FileInputStream in = new FileInputStream(location);

            // Load the materials list.
            materials = (ArrayList<MaterialQuantity>) xstream.fromXML(in);

            // Close the buffer.
            in.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return materials;
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
        List<MaterialQuantity> materials = new ArrayList<MaterialQuantity>();

        // Add the materials.
        materials.add(new MaterialQuantity(new Phone("HTC One",
                "Description of the HTC One", TypeOS.ANDROID), 5));
        materials.add(new MaterialQuantity(new Casque("Dr Dre",
                "Description of the Dr Dre", 1, 3), 24));
        materials.add(new MaterialQuantity(new Camera("Nokia 850",
                "Description of the Nokia 850", 1, 2), 2));
        materials.add(new MaterialQuantity(new Tablet("iPad",
                "Description of the HTC One", TypeOS.IOS), 5));

        // Create a default Xstream.
        XStream xstream = new XStream(new DomDriver());

        try {

            // Open the buffer.
            FileOutputStream out = new FileOutputStream(location);

            // Store the materials list.
            xstream.toXML(materials, out);

            // Close the buffer
            out.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
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
