package zuul;

public class Quizz {
		
		private int points;
		private Question [] theQuestions;


		private final static Question [] oopQuestions = {
			new Question(Language.QUIZZOOPQUESTION1.toString(),Language.QUIZZOOPREPONSE1.toString()),
			new Question(Language.QUIZZOOPQUESTION2.toString(),Language.QUIZZOOPREPONSE2.toString()),
			new Question(Language.QUIZZOOPQUESTION3.toString(),Language.QUIZZOOPREPONSE3.toString()),
		};	

		

		private final static Question [] ssiiQuestions = {
				new Question(Language.QUIZZSSIIQUESTION1.toString(),Language.QUIZZSSIIREPONSE1.toString()),
				new Question(Language.QUIZZSSIIQUESTION2.toString(),Language.QUIZZSSIIREPONSE2.toString()),
		};	
		
		
		public Question[] getTheQuestions() {
			return theQuestions;
		}


		public void setTheQuestions(Question[] theQuestions) {
			this.theQuestions = theQuestions;
		}


/**
 * Cree un quizz et charge le tableau des questions selon la matiere donnee en parametre 
 * @param c : la matiere du quizz
 */
		public Quizz(Course c){
			points=0;
			
			switch (c.getName()){
				case "OOP" : theQuestions = oopQuestions;break;
				case "SSII" : theQuestions = ssiiQuestions;break;
				default : theQuestions = oopQuestions;break;
			}
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
				if (currentQuestion.goodAnswer(WordReader.getWord())) points++;
			}
		}
		
		/**
		* Renvoie true si l'utilisateur a répondu juste à au moins 50% des questions du quizz
		*/
		public boolean isPassed(){
			return points>=(float)theQuestions.length/2;
		}

	/**
	 * Affiche le score qu'a obtenu l'utilisateur au quizz
	 */
		public void printScore(){
			System.out.println(Language.QUIZZVOTRESCOREESTDE+" "+points+"/"+theQuestions.length);
		}
}
