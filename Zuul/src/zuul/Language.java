package zuul;

public enum Language {
        
        BIENVENUE(""),
		BONJOUR(""),
		AUREVOIR(""),
		NORD(""),
		EST(""),
		SUD(""),
		OUEST(""),
		OUI(""),
		NON(""),
		SORTIE(""),
		PASDEPORTE(""),
		VOUSETES(""),
		DIRECTIONS(""),
		ACTUELLEMENT(""),
		DE(""),
		VOUSDEVEZASSISTER(""),
		VOULEZVOUSYASSISTER(""),
		VEUILLEZSAISIR(""),
		REVENEZPLUSTARD(""),
		PASCOURS(""),
		COURS(""),
		TD(""),
		LE(""),
		FINI(""),
		FELICITATIONSITEM(""),
		VOTREENERGIE(""),
		SUIVI(""),
		QUIZZBIENVENUE(""),
		QUIZZVOTRECHOIX(""),
		QUIZZOOPQUESTION1(""),
		QUIZZOOPQUESTION2(""),
		QUIZZOOPQUESTION3(""),
		QUIZZSSIIQUESTION1(""),
		QUIZZSSIIQUESTION2(""),
		QUIZZVOTRESCOREESTDE(""),
		DESCRIPTIONHALL(""),
		DESCRIPTIONCOULOIR(""),
		DESCRIPTIONAMPHI(""),
		DESCRIPTIONTD(""),
        DESCRIPTIONEXAM(""),
        DESCRIPTIONBIBLIO(""),
        DESCRIPTIONCAFET(""),
		ERRORHEALTH(""),
		ERREURPASASSEZDECOURS(""),
		VOUSAVEZASSISSTERA(""),
		VOTREENERGIEADIMINUE(""),
		VOTREENERGIEAAUGMENTE(""),
		VOUSAVEZTROUVETD("");

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
		    "Bienvenue dans le jeu Zuul où vous vous baladez dans Polytech\n"
		    + "Tapez la direction dans laquelle vous voulez aller, sortie si vous voulez quitter, "
		    + "infos pour afficher les détails de votre joueur",
			"Bonjour",
			"Au revoir",
			"nord",
			"est",
			"sud",
			"ouest",
			"oui",
			"non",
			"sortie",
			"Cela ne mène à rien...",
			"Vous êtes ",
			"Directions possibles :",
			"Il y a actuellement",
			"de ",
			"Vous devez y assister et attendre la fin",
			"Voulez-vous y assister ? (oui ou non)",
			"Veuillez saisir oui ou non",
			"Ok, revenez plus tard",
			"Il n'y a pas cours actuellement.",
			" cours ",
			" TD ",
			"Le",
			"est enfin fini !",
			"Félicitations vous venez de récupérer un item",
			"Votre énergie est de ",
			"Vous avez suivi :",
			"L'examen va commencer. Pour réussir vous devez avoir au moins 50% des réponses justes\n" +
			"Répondez true ou false",
			"Votre choix : ",
			"Le professeur de POO s'appelle Mr Stromboni? ",
			"Est ce que la mascotte de Java s'appelle duke? ",
			"Les méthodes d'une interface sont-elles publiques? ",
			"La condition de Shannon stipule-t-elle que fe>2fo? ",
			"Suréchantillonner un signal rajoute-il des points? ",
			"Votre score est de ",
			"dans le hall",
			"dans le couloir",
			"dans l'amphi ",
			"dans la salle de TD ",
			"dans la salle d'examen",
			"dans la bibliothèque",
			"dans la caféteria",
			"Vous n'avez pas assez d'énergie pour prendre part à cet examen",
			"Vous n'avez pas suivi assez de cours dans cette matiere pour pouvoir suivre le TD !",
			"Vous avez assiste",
			"Votre énergie a diminué de ",
			"Votre énergie a augmenté de ",
			"Vous avez trouvé un td de "
			
		};

		private final static String [] en ={
			"Hello",
			"Good bye",
		};

	}
