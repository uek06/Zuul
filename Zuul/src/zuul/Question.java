package zuul;

public class Question {
		private String question;
		private boolean answer;


		public Question(String question,boolean answer){
			this.question=question;
			this.answer=answer;
		}	


		public String toString(){
			return question;
		}

		/**
		* @param answer : la chaine que l'on veut comparer à la réponse de la question
		* @return true si les deux chaines correspondent
		*/
		public boolean goodAnswer(boolean answer){
			return this.answer==answer;
		}


		public boolean getAnswer() {
			return answer;
		}

		
}
