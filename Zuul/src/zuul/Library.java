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
    	System.out.println("Voici les livres disponibles : ");
    	for (int i=0;i<theBooks.length;i++){
    		System.out.println(i+1+") "+theBooks[i]);
    	}
    }
    
    private void proposeToReadBook(Student player){
    	System.out.println("Pour lire un livre tapez son numéro, tapez 0 pour quitter");
    	int number = WordReader.getInt();
    	while (0!=number){
    		Book b = getBook(number);
    		if (b!=null){
    			b.use(player);
    		}
    		else {
    			System.out.println("Ce livre n'est pas dans la bibliotheque !");
    		}
    		number = WordReader.getInt();
    	}
    }
    
    
    
    private Book getBook(int number){
    	try {
    		return theBooks[number-1];
    	}
    	
    	catch (ArrayIndexOutOfBoundsException e){
    		return null;
    	}	
    	
    }
  
    
}