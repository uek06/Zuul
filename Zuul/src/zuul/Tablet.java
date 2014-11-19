package zuul;

import java.util.Random;

public class Tablet extends Item{
		
	private Course theCourse;
	private boolean jeuvideo;
	
	private final Course [] lesMatieres = {
			new Course("OOP"),
			new Course("SSII")
	};
	

	public Tablet(String description){
		super(description);
		theCourse=getRandomCourse();
	}
	
	/**
	 * 
	 * @return Un Objet Course pris au hasard dans le tableau des matieres  
	 */
	public Course getRandomCourse(){
		Random r = new Random();
		return lesMatieres[r.nextInt(lesMatieres.length)];
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