package zuul;

import java.util.ArrayList;

public class Quizz {
		
		private int points;
		private ArrayList<Question> questions;

/**
 * Cree un quizz et charge le tableau des questions selon la matiere donnee en parametre 
 * @param c : la matiere du quizz
 */
		public Quizz(Course c){
			points=0;
			questions = c.getQuestions();
		}


		/**
		* Affiche la phrase de bienvenue d'un quizz
		*/
		public void printWelcome(){
			System.out.println(Language.QUIZZBIENVENUE);
		}

		/**
		* Affiche toutes les informations d'une question 
		* @param Question q : la question à afficher
		*/
		public void printQuestion(Question q){
			System.out.println("\n"+Language.QUIZZQUESTIONSUIVANTE.toString()+"\n");
			System.out.println(q+"\n");
			System.out.print(Language.QUIZZVOTRECHOIX);

		}

		/**
		* Débute un quizz, permettant ainsi à l'utilisateur de répondre à toutes les questions
		*/
		public void startQuizz(){
			printWelcome();
			for (Question q: questions){
				printQuestion(q);
				if (q.goodAnswer(WordReader.getBoolean())) points++;
			}
		}
		
		/**
		* Renvoie true si l'utilisateur a répondu juste à au moins 50% des questions du quizz
		*/
		public boolean isPassed(){
			return points>=(float)questions.size()/2;
		}

	/**
	 * Affiche le score qu'a obtenu l'utilisateur au quizz
	 */
		public void printScore(){
			System.out.println(Language.QUIZZVOTRESCOREESTDE+" "+points+"/"+questions.size());
		}
}
