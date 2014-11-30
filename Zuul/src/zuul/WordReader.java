package zuul;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WordReader {

	private static Scanner sc = new Scanner(System.in);

	
	/**
	 * Lit une chaine de caractères depuis le clavier
	 * @return la chaine lue
	 */
	public static String getWord() {
		String word = sc.nextLine();

		while ("".equals(word))
			word = sc.nextLine();
		return word;
	}

	/**
	 * Lit un boolean depuis le clavier
	 * @return le boolean lu
	 * @throws InputMismatchException si l'utilisateur ne tape pas true ou false
	 */
	public static boolean getBoolean() throws InputMismatchException{
			sc = new Scanner(System.in);
			return sc.nextBoolean();
	}

	/**
	 * Lit un entier depuis le clavier
	 * @return l'entier lu
	 */
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
