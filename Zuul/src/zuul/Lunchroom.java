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
    	
    	System.out.println("Voulez vous prendre un cafe ? (oui,non)");
    	if (WordReader.getWord().equals("oui")){
    		new Coffee().use(player);
    	}
    }
    
    private void playBabyFoot(Student player){
        System.out.println("Vous jouez au babyfoot ");
        Course c = Game.getRandomCourse();
        if(player.peutOublierCours(c)){
            System.out.print("et oubliez un cours de "+c.getName());
		    player.oublierCours(c);
		}
    }
}