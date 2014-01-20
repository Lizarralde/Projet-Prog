package ui;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 * This parser reads user input and make a list or a gregorian calendar of it.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Parser {

    // Source of command input
    private Scanner reader;

    /**
     * Create a parser to read from the terminal window.
     * 
     * @author Dorian LIZARRALDE
     */
    public Parser() {

        reader = new Scanner(System.in);
    }

    /**
     * Change the source of command input.
     * 
     * @author Dorian LIZARRALDE
     * @param inputStream
     *            The new source of command input
     */
    public void setReader(InputStream inputStream) {

        reader = new Scanner(inputStream);
    }

    /**
     * Read user input and make a list of it.
     * 
     * @author Dorian LIZARRALDE
     * @return A list of the user input.
     */
    public List<String> getInput() {

        // Create an empty list which will hold the user input.
        List<String> words = new ArrayList<String>();

        // Create an empty String which will hold the user input.
        String inputLine;

        // Display a prompt.
        System.out.print("> ");

        // Get the user input.
        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);

        // Each word of the user input is placed in the list.
        while (tokenizer.hasNext()) {

            words.add(tokenizer.next());
        }

        tokenizer.close();

        return words;
    }

    /**
     * Read user input and make a gregorian calendar of it. The format of the
     * user input is dd/MM/yyyy.
     * 
     * @author Dorian LIZARRALDE & Fabien PINEL
     * @return A gregorian calendar based on the user input.
     */
    public GregorianCalendar getADate() {

        // Get the user input.
        List<String> words = getInput();

        if (!words.isEmpty()) {

            // Get the day, month and year of the user input.
            String str[] = words.get(0).split("/");

            // String -> Integer
            if (str.length >= 3) {

                int year = Integer.parseInt(str[2]);

                int month = Integer.parseInt(str[1]);

                int day = Integer.parseInt(str[0]);

                // Creation of the calendar.
                return new GregorianCalendar(year, month - 1, day);
            }
        }
        return null;
    }
}
