package game;

public enum Language {
        
        BIENVENUE(""),
        COMMANDES(""),
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
		ETUN(""),
		VOUSDEVEZASSISTER(""),
		VOULEZVOUSYASSISTER(""),
		VEUILLEZSAISIR(""),
		REVENEZPLUSTARD(""),
		PASCOURS(""),
		COURS(""),
		TD(""),
		LE(""),
		FINI(""),
		FELICITATIONS(""),
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
		INFOS(""),
		SAC(""),
		AIDE(""),
		GAGNE(""),
		ECHOUE(""),
		FEUILLETRICHE(""),
		VOICIREPONSES(""),
		REPONSE(""),
		VOUSETESDISTRAITS(""),
		COULOIRETEINT(""),
		VOUSALLUMEZ(""),
		ILYAQUELQUECHOSE(""),
		VOUSMETTEZCA(""),
		EXAMEN(""),
		VOUSNAVEZ2(""),
		VOUSSUIVI(""),
		COURSET(""),
		TD2(""),
		VOUSDEVEZ(""),
		PASASSEZ(""),
		VOTREENERGIE2(""),
		ENERGIEMINIMALE(""),
		BIBLIOFERMEE(""),
		LIVRESDISPO(""),
		VOUSSAVEZTOUT(""),
		POURLIRE(""),
		CELIVRE(""),
		CAFETROUVE(""),
		VOUSJOUEZ(""),
		TAPEZ(""),
		PASOBJET(""),
		SACVIDE(""),
		CONTENUSAC(""),
		VOUSENAVEZ(""),
		VOTREENERGIEADIMINUE(""),
		VOTREENERGIEAAUGMENTE("");

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
		    "Bienvenue dans le jeu Zuul où vous vous baladez dans Polytech\n",
		    "Tapez la direction dans laquelle vous voulez aller, sortie si vous voulez quitter.\n"
		    + "Tapez infos pour afficher les détails de votre joueur.\n"
		    + "Tapez sac pour voir votre sac et utiliser son contenu.\n"
		    + "Tapez aide pour avoir un rappel des commandes.",
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
			"et un",
			"Vous devez y assister et attendre la fin",
			"Voulez-vous y assister ? (oui ou non)",
			"Veuillez saisir oui ou non",
			"Ok, revenez plus tard",
			"Il n'y a pas cours actuellement.",
			" cours ",
			" TD ",
			"Le",
			"est enfin fini !",
			"Félicitations, vous avez suivi un",
			"Félicitations, vous êtes tombés sur la page internet d'un",
			"Votre énergie est de ",
			"Vous avez suivi :",
			"L'examen va commencer. Pour réussir vous devez avoir au moins 50% des réponses justes\n" +
			"Répondez true ou false",
			"Votre choix : ",
			"Le professeur de POO s'appelle Mr Stromboni.",
			"La mascotte de Java s'appelle duke.",
			"Les méthodes d'une interface sont publiques.",
			"La condition de Shannon stipule que fe>2fo .",
			"Suréchantillonner un signal rajoute des points.",
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
			"infos",
			"sac",
			"aide",
			"Vous avez gagné ! Merci d'avoir joué",
			"Vous avez échoué.",
			"Feuille de triche de ",
			"Voici les reponses aux questions de l'examen de :",
			"REPONSE :",
			"Vous êtes distrait, vous oubliez donc un cours ",
			"Le couloir est éteint. Voulez vous l'allumer ? (oui ou non)",
			"Vous allumez le couloir",
			"Il y a quelque chose par terre...",
			" ! Vous mettez ça dans votre sac.",
			" examen ",
			"Vous n'avez pas suivi suffisament de cours et de TD de ",
			"Vous avez suivi ",
			" cours et ",
			" TD",
			"Vous devez en avoir suivi au minimum ",
			"Vous n'avez pas assez d'énergie pour particper à l'examen",
			"Votre energie est de ",
			"L'energie minimale pour passer un examen est de ",
			"La bibliotheque est fermee a cette heure, revenez plus tard",
			"Voici les livres disponibles : ",
			"Vous savez maintenant tout sur Java",
			"Pour lire un livre tapez son numéro, tapez 0 pour quitter",
			"Ce livre n'est pas dans la bibliotheque !",
			"Vous avez trouvé un café ! Vous le mettez dans votre sac",
			"Vous jouez au babyfoot et c'est très amusant !",
			"Tapez le numéro de l'objet pour l'utiliser, 0 pour quitter",
			"Vous n'avez pas d'objet correspondant...",
			"Votre sac est vide !",
			"Voici le contenu de votre sac :",
			", vous en avez ",
			"Votre énergie a diminué de ",
			"Votre énergie a augmenté de "
			
		};

		private final static String [] en ={
			"Hello",
			"Good bye",
		};

	}
