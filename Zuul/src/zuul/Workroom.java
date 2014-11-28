package zuul;

import java.util.Random;

public abstract class Workroom extends Room {

	protected Course course;
	protected String choix;
	private boolean estUnCours;
	private String coursOuTd;

	public Workroom(String description) {
		super(description);
	}

	public void action(Student s) {
		
		Random rand=new Random();
		//1 chance sur le nombre de matières pour qu'il n'y ait pas cours
		if(rand.nextInt(Game.getCourses().length+1)==1) System.out.println(Language.PASCOURS);
		else {
		    course = Game.getRandomCourse();
			if (this instanceof Lab) {
			    coursOuTd = "" + Language.TD;
                estUnCours = false;
			}
			else{
			    coursOuTd = "" + Language.COURS;
                estUnCours = true;
			}
			System.out.println(Language.ACTUELLEMENT + coursOuTd + Language.DE
                    + course.getName());
			if (estUnCours || (!estUnCours && s.peutAssissterAUnTd(course)))
				    caseCours(s);
			else {
			    System.out.println(Language.ERREURPASASSEZDECOURS);
			}
		}
	}

	public void caseCours(Student s) {
		
		if (course.isCompulsory()) {
			System.out.println(Language.VOUSDEVEZASSISTER);
			displayCourse(s);
		}
		else {
			System.out.println(Language.VOULEZVOUSYASSISTER);
			while (true) {
				choix = WordReader.getWord();
				if (choix.equals("" + Language.OUI)) {
					displayCourse(s);
					break;
				} else if (choix.equals("" + Language.NON)) {
					System.out.println(Language.REVENEZPLUSTARD);
					break;
				} else
					System.out.println(Language.VEUILLEZSAISIR);
			}
		}
	}

	public void displayCourse(Student s) {
		for (int i = 0; i < 6; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println("\n" + Language.LE + coursOuTd + Language.FINI);
		System.out.println(Language.FELICITATIONSITEM + coursOuTd
				+ course.getName() + " !");
		s.assissterAUnCoursOuTd(estUnCours, course);
	}

}
