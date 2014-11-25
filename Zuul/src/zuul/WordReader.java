package zuul;

import java.util.Scanner;

public class WordReader {
	
	private static Scanner sc = new Scanner(System.in);
	
	
	
	public static String getWord(){
		String word = sc.nextLine();
		
		while ("".equals(word) ) word = sc.nextLine();
		return word;
	}

}
