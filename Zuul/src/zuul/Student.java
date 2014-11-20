package zuul;

import java.util.ArrayList;

public class Student {
	private int health;
	private ArrayList<ItemCourse> coursSuivis;
	private ArrayList<ItemLab> tdSuivis;
	private static final int SANTEMINPOURTEST = 60;
	
	
	public Student(){
		health=50;
	}
	
	
	public void drinkCoffee(){
		health+=50;
	}
	
	public void assissterAUnCours(Course cours){
		coursSuivis.add(new ItemCourse(cours));
		health-=10;
	}
	
	public void assissterAUnTD(Course cours){
		tdSuivis.add(new ItemLab(cours));
		health-=10;
	}
	
	/**
	 * @param cours la matiere de l'examen
	 * @return true si l'examen est réussi
	 */
	public boolean faireUnExamen(Course cours){
		Quizz q = new Quizz(cours);
		q.startQuizz();
		q.printScore();
		return q.isPassed();
	}
	/**
	 * 
	 * @return true si l'etudiant peut passer le test
	 */
	public boolean santeMiniPourParticiperAUnExam(){
		return health >= SANTEMINPOURTEST;
	}
	

}
