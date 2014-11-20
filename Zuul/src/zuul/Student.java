package zuul;

import java.util.ArrayList;

public class Student {
	private int health;
	private ArrayList<ItemCourse> coursSuivis;
	private ArrayList<ItemLab> tdSuivis;
	
	
	public Student(){
		health=50;
	}
	
	
	public void drinkCoffee(){
		
	}
	
	public void assissterAUnCours(Course cours){
		coursSuivis.add(new ItemCourse(cours));
		health-=10;
	}
	
	public void assissterAUnTD(Course cours){
		tdSuivis.add(new ItemLab(cours));
		health-=10;
	}
	
	public void faireUnExamen(Course cours){
		if (health<0) 
			//  
	}
	
	/*A mettre dans language
	ERRORHEALTH(""),
	VOUSAVEZASSISSTERA("");
	
	
	"Vous n'avez pas assez d'énergie pour prendre part à cet examen"
	
}
