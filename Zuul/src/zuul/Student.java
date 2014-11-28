package zuul;


import java.util.HashMap;

public class Student {
	private int health;
	private HashMap<Course, Integer> coursSuivis= new HashMap<Course,Integer>();
	private HashMap<Course,Integer> tdSuivis= new HashMap<Course,Integer>();
	public static final int SANTEMINPOURTEST = 60;
	private boolean livrePOOLu=false;

    public int getHealth() {
		return health;
	}

	public Student(){
		health=50;
	}
	
   
	public void drinkCoffee(){
		health+=50;
	}
    
	public void initMap(Course[] courses){
	    for(Course co : courses){
	       coursSuivis.put(co,0);
	       tdSuivis.put(co,0);
	    }
	   
	}
	
	public void assissterAUnCoursOuTd(boolean estUnCours, Course cours){
		if (estUnCours) coursSuivis.put(cours,coursSuivis.get(cours)+1);
		else tdSuivis.put(cours,tdSuivis.get(cours)+1);
		health-=10;
	}
	
	
	
	/**
	 * 
	 * @param cours : la matiere
	 * @return true si l'etudiant a suivi suffisament de cours avant
	 */
	public boolean peutAssissterAUnTd(Course cours){
		return tdSuivis.get(cours)<coursSuivis.get(cours);
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
	
	public int getNbCoursOuTdSuivis(Course cours, boolean estUnCours){
	    if (estUnCours) return coursSuivis.get(cours);
	    else return tdSuivis.get(cours);
	}
	
	/**
     * @param nb le health à définir
     */
    public void lowerHealth(int nb) {
        this.health -= nb;
    }

    public boolean aSuiviTousLesCoursEtTD(Course cours){
		return coursSuivis.get(cours)>=cours.getNbMiniCoursExam() && tdSuivis.get(cours)>=cours.getNbMiniCoursExam();
	}
	/**
	 * Fait oublier a l'etudiant le dernier cours et le dernier TD correspondant a ce cours sauf s'il avait un cours d'avance
	 * @param cours le cours a oublier
	 */
	public void oublierCours(Course cours){
		if (coursSuivis.get(cours)==tdSuivis.get(cours)){//si nbcours=nbtd
		    tdSuivis.put(cours,tdSuivis.get(cours)-1);//alors on enlève un td
		}
		coursSuivis.put(cours,coursSuivis.get(cours)-1);//dans tous les cas on enlève un cours
	}
	
    /**
     * @return le livrePOOLu
     */
    public boolean getLivrePOOLu() {
        return livrePOOLu;
    }

    /**
     * @param livrePOOLu le livrePOOLu à définir
     */
    public void setLivrePOOLu() {
        livrePOOLu = true;
    }
	
	
	public void printInfos(){
	    System.out.println(""+Language.VOTREENERGIE+health);
	    System.out.println(Language.SUIVI);
	}
}
