package zuul;

import java.util.ArrayList;

public class CheatSheet extends Item {
	private ArrayList<Question> questions;
	private Course course;

	public CheatSheet(Course course) {
		this.course = course;
		questions = course.getQuestions();
		description = "Une feuille de triche ";
	}

	/**
	 * Permet de lire la feuille de triche pour avoir les reponses et les
	 * questions d'un examen donne
	 */
	@Override
	public void use(Student player) {
		System.out.println("Voici les reponses aux questions de l'examen de :"
				+ course.getName() + "\n");
		for (Question q : questions) {
			System.out.println(q + "\n" + "REPONSE :" + q.getAnswer() + "\n");
		}

	}
}