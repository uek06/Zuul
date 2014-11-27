package zuul;

import java.util.Random;

public class Lunchroom extends Room{
    //café
    public Lunchroom(String description) {
        super(description);
    }

    @Override
    public void action(Student player){
    	Random r = new Random();
    	
    	if (r.nextInt(10)>6) {
    		playBabyFoot(player);
    	}
    	
    	System.out.print("Voulez vous prendre un cafe ? (oui,non)");
    	if (WordReader.getWord().equals("oui")){
    		player.drinkCoffee();
    	}
    	
    
    }
    
    private void playBabyFoot(Student player){
    	Course c = Game.getRandomCourse();
		if (!"".equals(c.getName())) {
			System.out.println("Vous jouez au babyfoot et oubliez un cours de "+c.getName());
			player.oublierCours(c);
		}
    }
}