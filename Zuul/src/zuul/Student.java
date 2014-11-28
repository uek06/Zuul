package zuul;

import java.util.HashMap;

public class Student {
	private int health;
	private HashMap<Course, Integer> coursSuivis= new HashMap<Course,Integer>();
	private HashMap<Course,Integer> tdSuivis= new HashMap<Course,Integer>();
	private HashMap<Item,Integer> inventaire= new HashMap<Item,Integer>();
	public static final int SANTEMINPOURTEST = 60;
	
    public int getHealth() {
		return health;
	}

	public Student(){
		health=60;
	}
    
	public void initMap(){
	    for(Course co : Game.getCourses()){
	       coursSuivis.put(co,0);
	       tdSuivis.put(co,0);
	    }
	   
	}
	
	public void assissterAUnCoursOuTd(boolean estUnCours, Course cours){
		if (estUnCours) coursSuivis.put(cours,coursSuivis.get(cours)+1);
		else tdSuivis.put(cours,tdSuivis.get(cours)+1);
		this.changeHealth(-10);
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
    public void changeHealth(int nb) {
        int healthChange;
        String blabla;
        if(nb>0) blabla=""+Language.VOTREENERGIEAAUGMENTE;
        else blabla=""+Language.VOTREENERGIEADIMINUE;
        if (health+nb>=0){
            healthChange=nb;
            this.health += nb;
        }
        else{
            healthChange=health;
            this.health=0;
        }
        System.out.print(blabla+healthChange+"\n");
    }

    public boolean aSuiviTousLesCoursEtTD(Course cours){
		return coursSuivis.get(cours)>=cours.getNbMiniCoursExam() && tdSuivis.get(cours)>=cours.getNbMiniCoursExam();
	}
    
	/**
	 * Fait oublier a l'etudiant le dernier cours et le dernier TD correspondant a ce cours sauf s'il avait un cours d'avance
	 * @param cours le cours a oublier
	 */
	public void oublierCours(Course cours){
	    if(peutOublierCours(cours)){
    		if (coursSuivis.get(cours)==tdSuivis.get(cours)){//si nbcours=nbtd
    		    tdSuivis.put(cours,tdSuivis.get(cours)-1);//alors on enlève un td
    		}
    		coursSuivis.put(cours,coursSuivis.get(cours)-1);//dans tous les cas on enlève un cours
	    }
	}
	
	public boolean peutOublierCours(Course cours){
	    return coursSuivis.get(cours)>=1;
	}
	
    /**
     * @return le livrePOOLu
     */
    public void livrePOOLu() {
        coursSuivis.put(Game.getCourses()[0],Game.getCourses()[0].getNbMiniCoursExam());
    }
	
	public void printInfos(){
	    //on affiche l'énergie
	    System.out.println(""+Language.VOTREENERGIE+health+".");
	    //on affiche les cours/td suivis
	    System.out.println(Language.SUIVI);
	    for(Course co : Game.getCourses()){
	        System.out.println("_"+co.getName()+" : "+coursSuivis.get(co)+Language.COURS+", "+tdSuivis.get(co)+Language.TD);
	    }
	}
}
