package zuul;

public class ExamRoom extends Workroom {

	private Course course;

	public ExamRoom(String description) {
		super(description);
	}

	public void action(Student s) {
    	course = Game.getRandomCourse();
    	
    	if ("".equals(course.getName())) {
			System.out.println(Language.PASCOURS);
		} 
    	else {
    		System.out.println(Language.ACTUELLEMENT+" examen"+Language.DE+course.getName());
    		if (!(s.aSuiviTousLesCoursEtTD(course) || (s.getLivrePOOLu() && "POO".equals(course.getName())))) {
    	
				System.out.println("Vous n'avez pas suivi suffisament de cours et de TD de "+course.getName());
				System.out.println("Vous avez suivi "+s.getNbCoursOuTdSuivis(course,true)+" cours et "+s.getNbCoursOuTdSuivis(course,false)+" TD");
				System.out.println("Vous devez en avoir suivi au minimum "+course.getNbMiniCoursExam());
			}
			else if (!s.santeMiniPourParticiperAUnExam()){
				System.out.println("Vous n'avez pas assez d'energie pour particper a l'examen");
				System.out.println("Votre energie est de "+s.getHealth());
				System.out.println("L'energie minimale pour passer un examen est de "+Student.SANTEMINPOURTEST);
		
			}
			else {
				caseCours(s);
			}
    	}
    }

	

	@Override
    public void displayCourse(Student s){
    	Quizz q = new Quizz(course);
    	q.startQuizz();
    	q.printScore();
    	if (q.isPassed()) {
    		if ("POO".equals(course.getName())) {
    			Game.finish();
    			System.out.println("Vous avez gagné !");
    		}
    	}
    }
}
