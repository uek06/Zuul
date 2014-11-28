package zuul;

import java.util.Random;

public class Tablet extends Item{
		
	private Course course;
	

	public Tablet(){
		course=Game.getRandomCourse();
		description = "Une tablette";
	}
	

	
	/**
	 * @return true si la tablette est en fait pour jouer et non pas pour apprendre un cours
	 */
	private boolean jouerAUnJeuVideo(){
		Random r = new Random();
		if (r.nextInt(10)<3) {
			return true;
		}
		return false;
	}



	@Override
	public void use(Student player) {
		if (jouerAUnJeuVideo() ){
			System.out.println("Vous jouez a un jeu sur votre tablette");
			if ("".equals(course.getName())){
				System.out.println("Comme vous jouez a Zuul, vous n'oubliez rien !");
			}
			else {
				System.out.println("Vous oubliez les dernieres choses faites en "+course.getName());
				player.oublierCours(course);
			}
		}
		else{
			if ("".equals(course.getName())){
				System.out.println("Le cours de cette tablette est trop vieux, vous n'apprenez rien ");
			}
			else {
				Random r = new Random();
				if (r.nextBoolean()){
					player.assissterAUnCoursOuTd(true,course);
				}
				else {
					if (player.peutAssissterAUnTd(course)) player.assissterAUnCoursOuTd(false,course);
				}
			}
		}
		
	}
}