package ui;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 * Read user input.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Parser {

    // Scanner.
    private Scanner scanner;

    // Getter and setters.
    public Scanner getScanner() {

        return scanner;
    }

    public void setScanner(Scanner scanner) {

        this.scanner = scanner;
    }

    /**
     * Default constructor.
     * 
     * @param scanner
     */
    public Parser(Scanner scanner) {

        this.setScanner(scanner);
    }

    /**
     * Return the calendar using the user input.
     * 
     * @return
     */
    public GregorianCalendar getCalendar() {

        // User input.
        List<String> words = getInput();

        if (!words.isEmpty()) {

            String str[] = words.get(0).split("/");

            if (str.length > 2) {

                int year = Integer.parseInt(str[2]);

                int month = Integer.parseInt(str[1]);

                int day = Integer.parseInt(str[0]);

                return new GregorianCalendar(year, month - 1, day);
            }
        }

        return null;
    }

    /**
     * Return the user input.
     * 
     * @return
     */
    public List<String> getInput() {

        List<String> words = new ArrayList<String>();

        System.out.print("> ");

        String inputLine = this.getScanner().nextLine();

        Scanner tokenizer = new Scanner(inputLine);

        while (tokenizer.hasNext()) {

            words.add(tokenizer.next());
        }

        tokenizer.close();

        return words;
    }
}
