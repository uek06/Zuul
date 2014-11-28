package zuul;

import java.util.ArrayList;
import java.util.Random;

public class Corridor extends Room{
    
	private ArrayList<Item> objectsInTheCorridor = new ArrayList<Item>(); 

	
	public Corridor(String description) {
        super(description);
    }

	public void action(Student player)  {
		
		putItemsInTheCorridorRandomly();
		
        Random r = new Random();
        if (r.nextBoolean()){  //lumiere allumee
      
        	listItemsInTheCorridor(player);
        }
        else {
        	System.out.println("Le couloir est eteint. Voulez vous l'allumer?(oui,non)");
        	if (WordReader.getWord().equals("oui")) {
        		System.out.println("Vous allumez le couloir");
        	
            	listItemsInTheCorridor(player);
        	}
        }
    }
 
	
	private void putItemsInTheCorridorRandomly(){
		Random r = new Random();
		if (r.nextInt(10)>8) {
			objectsInTheCorridor.add(new CheatSheet(Game.getRandomCourse()));
		}
		if (r.nextInt(8)>6) {
			objectsInTheCorridor.add(new Tablet());
		}	
	}

	private void listItemsInTheCorridor(Student player) {

		if (!objectsInTheCorridor.isEmpty()) {
			System.out.println("Il y a des objets dans le couloir : \n");
		}
		for (Item i : objectsInTheCorridor) {
			System.out.println(i.getDescription());
			System.out.print("Voulez vous l'utiliser? (oui,non)");
			if (WordReader.getWord().equals("oui")) i.use(player);
		}
	}
	
	
	
}