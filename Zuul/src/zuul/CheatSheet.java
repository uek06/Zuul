package zuul;

public class CheatSheet extends Item{
	private Question [] theAnswers;
	private Course course;

	public CheatSheet(Course c){
		course=c;
		theAnswers = (new Quizz(c)).getTheQuestions();
		description = "Une feuille de triche ";
	}
	
	
	/**
	 * Permet de lire la feuille de triche pour avoir les reponses et les questions
	 * d'un examen donne
	 */
	@Override
	public void use(Student player) {
		if ("".equals(course.getName())) {
			System.out.println("La feuille est illisible ! ");
		} else {
			System.out
					.println("Voici les reponses aux questions de l'examen de :"
							+ course.getName() + "\n");
			for (Question q : theAnswers) {
				System.out.println(q + "\n" + "REPONSE :"
						+ q.getAnswer() + "\n");
			}
		}
	}
}