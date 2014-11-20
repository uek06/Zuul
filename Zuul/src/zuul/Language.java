package zuul;

public enum Language {

		BONJOUR(""),
		AUREVOIR(""),
		QUIZZBIENVENUE(""),
		QUIZZQUESTIONSUIVANTE(""),
		QUIZZVOTRECHOIX(""),
		QUIZZOOPQUESTION1(""),
		QUIZZOOPQUESTION2(""),
		QUIZZOOPQUESTION3(""),
		QUIZZOOPREPONSE1(""),
		QUIZZOOPREPONSE2(""),
		QUIZZOOPREPONSE3(""),
		QUIZZSSIIQUESTION1(""),
		QUIZZSSIIQUESTION2(""),
		QUIZZSSIIREPONSE1(""),
		QUIZZSSIIREPONSE2(""),
		QUIZZVOTRESCOREESTDE(""),
		DESCRIPTIONHALL(""),
		DESCRIPTIONCOULOIR(""),
		DESCRIPTIONAMPHI("");

		String str;
		
		Language(String str){
			this.str=str;
		}

		public String toString(){
			return str;
		}
		
		private void setStr(String str){
			this.str=str;
		}

		/**
		 * Charge les valeurs des str de BONJOUR,AUREVOIR... selon la langue choisie : FR, EN...  à partir des tableaux statiques fr,en ...
		 * @param String language : la langue dans laquelle on veut que les les objets de l'enum soient traduits
		 */

		public static void initLanguage(String language){
			String [] theLanguage;

			switch (language){
				case "FR" : theLanguage = fr; break;
				case "EN" : theLanguage = en; break;
				default : theLanguage = fr; break;
			}

			int i = 0;
			for (Language word : Language.values()){
				word.setStr(theLanguage[i]);
				i++;
			}
		}



		/**
		 * Tableau de tous les morceaux de phrases utilisés dans l'interface en francais 
		 * L'ordre compte : il doit etre le meme que BONJOUR,AUREVOIR... (les éléments de l'enum)
		 */ 
		
		private final static String [] fr = {
			"Bonjour",
			"Au revoir",
			"L'examen va commencer. Pour réussir vous devez avoir au moins 50% des réponses justes\n",
			"Question suivante :",
			"Votre choix : ",
			"Qui détient et maintient java depuis 2009? ikea, oracle ou mcdonald ?",
			"Quelle est la mascotte de Java? duke, tux ou mario?",
			"Ce projet est-il exceptionnel? (oui,non)",
			"oracle",
			"duke",
			"oui",
			"Est ce que ce cours est pourri? (oui,non)",
			"Quelle est la meilleure chose à faire pendant ce cours? (attendrecorrection,trackmania)",
			"oui",
			"trackmania",
			"Votre score est de ",
			"dans le hall",
			"dans le couloir",
			"dans l'amphi",
			"dans la salle de TD",
			"dans la salle d'examen",
			"dans la bibliothèque",
			"dans la caféteria"
		};

		private final static String [] en ={
			"Hello",
			"Good bye",
		};

	}
