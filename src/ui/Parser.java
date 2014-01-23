package ui;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import user.User;

/**
 * Read user input.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Parser {

    private Scanner scanner;

    public Scanner getScanner() {

        return scanner;
    }

    public void setScanner(Scanner scanner) {

        this.scanner = scanner;
    }

    public Parser(Scanner scanner) {

        this.setScanner(scanner);
    }

    public GregorianCalendar getADate() {

        List<String> words = getInput();

        if (!words.isEmpty()) {

            String str[] = words.get(0).split("/");

            if (str.length >= 3) {

                int year = Integer.parseInt(str[2]);

                int month = Integer.parseInt(str[1]);

                int day = Integer.parseInt(str[0]);

                return new GregorianCalendar(year, month - 1, day);
            }
        }
        return null;
    }

    public List<String> getInput() {

        List<String> words = new ArrayList<String>();

        System.out.print("> ");

        String inputLine = scanner.nextLine();

        Scanner tokenizer = new Scanner(inputLine);

        while (tokenizer.hasNext()) {

            words.add(tokenizer.next());
        }

        tokenizer.close();

        return words;
    }
}
