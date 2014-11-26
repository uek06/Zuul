package zuul;

import java.util.Random;

public class Tablet extends Item{
		
	private Course theCourse;
	private boolean jeuvideo;

	public Tablet(String description){
		super(description);
		theCourse=Game.getRandomCourse();
	}
	

	
	/**
	 * 
	 * @return true si la tablette est en fait pour jouer et non pas pour apprendre un cours
	 */
	public boolean jouerAUnJeuVideo(){
		Random r = new Random();
		if (r.nextInt(10)<3) {
			return true;
		}
		return false;
	}
	
}