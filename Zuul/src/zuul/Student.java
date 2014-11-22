package zuul;

import java.util.ArrayList;

public class Student {
	private int health;
	private ArrayList<ItemCourse> coursSuivisSSII = new ArrayList<ItemCourse>();
	private ArrayList<ItemCourse> coursSuivisPOO = new ArrayList<ItemCourse>();
	private ArrayList<ItemLab> tdSuivisSSII = new ArrayList<ItemLab>();
	private ArrayList<ItemLab> tdSuivisPOO = new ArrayList<ItemLab>();
	private static final int SANTEMINPOURTEST = 60;
	private static final int NUMBEROFOOPCOURSES = 2;
	private static final int NUMBEROFSSIICOURSES = 2;
	
	public Student(){
		health=50;
	}
	
	
	public void drinkCoffee(){
		health+=50;
	}
	
	public void assissterAUnCours(Course cours){
		ArrayList<ItemCourse> list = null;
		
		switch (cours.getName()){
		case "SSII" : ;
			list = coursSuivisSSII;
			break;
		case "POO" : 
			list = coursSuivisPOO;
			break;
		}
		
		list.add(new ItemCourse(cours));
		health-=10;
	}
	
	public void assissterAUnTD(Course cours){
		ArrayList<ItemLab> list = null;
		switch (cours.getName()){
		case "SSII" : ;
			list = tdSuivisSSII;
			break;
		case "POO" : 
			list = tdSuivisPOO;
			break;
	}
		list.add(new ItemLab(cours));
		health-=10;
	}
	
	/**
	 * 
	 * @param cours : la matiere
	 * @return true si l'etudiant a suivi suffisament de cours avant
	 */
	public boolean peutAssissterAUnTd(Course cours){
		ArrayList<ItemCourse> listCourse = null;
		ArrayList<ItemLab> listLab = null;
		
		
		switch (cours.getName()){
		case "SSII" :
			listCourse = coursSuivisSSII;
			listLab = tdSuivisSSII;
			break;
		case "POO" : 
			listCourse = coursSuivisPOO;
			listLab = tdSuivisPOO;
			break;
		}
		
		
		//Si il y a au moins un td de moins que de cours dans la matiere, alors l'etudiant
		//a deja suivi le cours pour le td et peut donc y a assisster
		return listLab.size()<listCourse.size();  
	}
	
	/**
	 * @param cours la matiere de l'examen
	 * @return true si l'examen est réussi
	 */
	public boolean faireEtReussirUnExamen(Course cours){
		Quizz q = new Quizz(cours);
		q.startQuizz();
		q.printScore();
		return q.isPassed();
	}
	/**
	 * 
	 * @return true si l'etudiant a assez d'énergie pour passer un test
	 */
	public boolean santeMiniPourParticiperAUnExam(){
		return health >= SANTEMINPOURTEST;
	}
	
	
	public boolean aSuiviTousLesCoursEtTD(Course cours){
		switch (cours.getName()) {
		case "SSII" : 
			return coursSuivisSSII.size() >= NUMBEROFSSIICOURSES && 
			tdSuivisSSII.size() >= NUMBEROFSSIICOURSES; 
			
		case "POO" : return coursSuivisPOO.size() >= NUMBEROFOOPCOURSES && 
			tdSuivisPOO.size() >= NUMBEROFOOPCOURSES;
		}
		
		return false; //juste pour pouvoir compiler
	}
	/**
	 * Fait oublier a l'etudiant le dernier cours et le dernier TD correspondant a ce cours sauf s'il avait un cours d'avance
	 * @param cours le cours a oublier
	 */
	public void oublierCours(Course cours){
		ArrayList<ItemCourse> listCourse = null;
		ArrayList<ItemLab> listLab = null;
		
		switch (cours.getName()){
		case "SSII" :
			listCourse = coursSuivisSSII;
			listLab = tdSuivisSSII;
			break;
		case "POO" : 
			listCourse = coursSuivisPOO;
			listLab = tdSuivisPOO;
			break;
		}
		
		listCourse.remove(listCourse.size()-1); //On oublie le dernier cours
		if (listCourse.size()<listLab.size()){
			listLab.remove(listLab.size()-1); //On oublie le dernier TD seulement 
		}
	}
	
	public void printInfos(){
		
	}
}
