package zuul;

public abstract class Workroom extends Room {

	protected Course course;
	protected String choix;

	public Workroom(String description) {
		super(description);
	}

	public void action(Student s) {
		course = Game.getRandomCourse();
		// course=new Course("SSII");
		if (this instanceof Lab && !s.peutAssissterAUnTd(course)) {
			System.out.println(Language.ERREURPASASSEZDECOURS);
		} else {
			switch (course.getName()) {
			case "POO":
				System.out.println(Language.COURSACTUEL + course.getName());
				System.out.println(Language.VOUSDEVEZASSISTER);
				displayCourse(s);
				break;
			case "SSII":
				System.out.println(Language.COURSACTUEL + course.getName());
				System.out.println(Language.VOULEZVOUSASSISTER);
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
				break;
			default:
				System.out.println(Language.PASCOURS);
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
		System.out.println("\n" + Language.COURSFINI);
		System.out
				.println(Language.FELICITATIONSITEM + course.getName() + " !");
		s.assissterAUnCours(course);

	}

}
