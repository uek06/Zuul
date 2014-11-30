package game;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Permet de lire une entrée clavier
 * 
 * @author
 *
 */
public class WordReader {
    private static Scanner sc = new Scanner(System.in);

    public static String getWord() {
        String word = sc.nextLine();

        while ("".equals(word))
            word = sc.nextLine();
        return word;
    }

    public static boolean getBoolean() throws InputMismatchException {
        sc = new Scanner(System.in);
        return sc.nextBoolean();
    }

    public static int getInt() {
        try {
            sc = new Scanner(System.in);
            int i = sc.nextInt();
            return i;
        } catch (InputMismatchException e) {
            return -1;
        }
    }

}
