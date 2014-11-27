package zuul;

public class Question {
		private String question;
		private String answer;


		public Question(String question,String answer){
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
		public boolean goodAnswer(String answer){
			return this.answer.equals(answer);
		}


		public String getAnswer() {
			return answer;
		}

		
}
