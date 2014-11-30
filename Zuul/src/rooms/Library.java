package rooms;

import game.Language;
import game.WordReader;
import items.Book;

import java.util.Random;

import player.Student;

/**
 * Bibliothèque
 * 
 * @author
 *
 */
public class Library extends Room {

    private final Book[] theBooks = {
            new Book("Objects First", "" + Language.VOUSSAVEZTOUT),
            new Book("The Lord Of The Rings",
                    "They are taking the hobbits to Isengard!") };

    public Library(String description) {
        super(description);
    }

    @Override
    public void action(Student player) {
        Random r = new Random();
        if (r.nextBoolean())
            System.out.println(Language.BIBLIOFERMEE);
        else {
            displayBooks();
            proposeToReadBook(player);
        }
    }

    private void displayBooks() {
        System.out.println(Language.LIVRESDISPO);
        for (int i = 0; i < theBooks.length; i++) {
            System.out.println(i + 1 + ") " + theBooks[i]);
        }
    }

    private void proposeToReadBook(Student player) {
        while (true) {
            System.out.println(Language.POURLIRE);
            int number = WordReader.getInt();
            if (number == 0)
                break;
            Book b = getBook(number);
            if (b != null)
                b.use(player);
            else
                System.out.println(Language.CELIVRE);
        }
    }

    private Book getBook(int number) {
        try {
            return theBooks[number - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }

    }

}