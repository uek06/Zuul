package zuul;

public class Quizz {
		private boolean passed;
		private int points;


		private final Question [] theQuestions = {
			new Question(Language.QUIZZQUESTION1.toString(),Language.QUIZZREPONSE1.toString()),
			new Question(Language.QUIZZQUESTION2.toString(),Language.QUIZZREPONSE2.toString()),
		};	


		public Quizz(){
			points=0;
			passed=false;
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

			for (int i=0;i<theQuestions.length;i++){
				Question currentQuestion = theQuestions[i];
				printQuestion(currentQuestion);
				//ici on  récupère une entree au clavier
				if (currentQuestion.goodAnswer("La réponse récupérée au clavier")) points++;
			}
		}
		
		/**
		* Renvoie true si l'utilisateur a répondu juste à au moins 50% des questions du quizz
		*/
		public boolean isPassed(){
			return points>=(float)theQuestions.length/2;
		}

	
}
