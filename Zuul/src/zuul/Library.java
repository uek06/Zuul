package zuul;

import java.util.Random;

public class Library extends Room{
	
	private final Book [] theBooks = {
			new Book("Objects First","Vous savez maintenant tout sur Java"),
			new Book("The Lord Of The Rings","They are taking the hobbits to Isengard!")
	};

    public Library(String description) {
        super(description);
    }

    @Override
    public void action(Student player){
    	Random r = new Random();
    	
    	if (r.nextBoolean()){
    		System.out.println("La bibliotheque est fermee a cette heure, revenez plus tard");
    	}
    	else{
    		displayBooks();
    		proposeToReadBook(player);
    	}
    }
    
    
    private void displayBooks(){
    	System.out.println("Voici les livres disponibles : \n");
    	for (Book b : theBooks){
    		System.out.println(b);
    	}
    }
    
    private void proposeToReadBook(Student player){
    	System.out.println("Pour lire un livre tapez son nom, tapez quit pour quitter");
    	String word = WordReader.getWord();
    	while (!"quit".equals(word)){
    		Book b = getBook(word);
    		if (b!=null){
    			b.use(player);
    		}
    		else {
    			System.out.println("Ce livre n'est pas dans la bibliotheque !");
    		}
    		word = WordReader.getWord();
    	}
    }
    
    private Book getBook(String title){
    	for (Book b : theBooks) {
    		if (b.toString().equals(title)) {
    			return b;
    		}
    	}
    	return null;
    }
}