package zuul;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WordReader {

	private static Scanner sc = new Scanner(System.in);

	public static String getWord() {
		String word = sc.nextLine();

		while ("".equals(word))
			word = sc.nextLine();
		return word;
	}

	public static boolean getBoolean() {
		while (true) {
			try {
				boolean b = sc.nextBoolean();
				return b;
			} catch (InputMismatchException e) {
				System.out.println("Erreur de saisie");
			}

		}
	}

}
