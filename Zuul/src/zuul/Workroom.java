package zuul;

public abstract class Workroom extends Room {

	protected Course course;
	protected String choix;
    private boolean estUnCours;
    private String coursOuTd;

	public Workroom(String description) {
		super(description);
	}

	public void action(Student s) {
		course = Game.getRandomCourse();
		//course=new Course("POO");
		switch (course.getName()) {
        case "POO":
            System.out.println(Language.COURSACTUEL + course.getName());
            break;
        case "SSII":
            System.out.println(Language.TDACTUEL + course.getName());
            break;
        default:
            System.out.println(Language.PASCOURS);
		}
                
		if (this instanceof Lab) {
		    if(!course.getName().equals("") && !s.peutAssissterAUnTd(course)) System.out.println(Language.ERREURPASASSEZDECOURS);
		    else{
		        coursOuTd=""+Language.TD;
		        estUnCours=false;
		        caseCours(s);
		    }
		}
		else {//c'est donc un cours
		    coursOuTd=""+Language.COURS;
		    estUnCours=true;
		    caseCours(s);
		}
	}

    public void caseCours(Student s){
        switch (course.getName()) {
        case "POO":
            System.out.println(Language.VOUSDEVEZASSISTER);
            displayCourse(s);
            break;
        case "SSII":
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
		System.out.println("\n" +Language.LE+coursOuTd+ Language.FINI);
		System.out
				.println(Language.FELICITATIONSITEM + coursOuTd+course.getName() + " !");
		s.assissterAUnCoursOuTd(estUnCours, course);
	}

}
