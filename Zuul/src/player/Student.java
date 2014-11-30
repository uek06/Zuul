package player;

import game.Game;
import game.Language;

import java.util.HashMap;

import courses.Course;
import courses.Quizz;

/**
 * Joueur pour Zuul
 * 
 * @author ugo
 *
 */
public class Student {
    private int health;
    private HashMap<Course, Integer> coursSuivis = new HashMap<Course, Integer>();
    private HashMap<Course, Integer> tdSuivis = new HashMap<Course, Integer>();
    private Bag sac = new Bag(this);
    public static final int SANTEMINPOURTEST = 60;

    public Student() {
        health = 60;
    }

    /**
     * initialise les 2 map cours et tds
     */
    public void initMap() {
        for (Course co : Game.getCourses()) {
            coursSuivis.put(co, 0);
            tdSuivis.put(co, 0);
        }
    }

    /**
     * permet au joueur d'assister à un cours ou td cad incrémenter la valeur de
     * la hashmap
     * 
     * @param estUnCours
     *            true si c'est un cours, false si c'est un td
     * @param cours
     *            le cours en question
     */
    public void assissterAUnCoursOuTd(boolean estUnCours, Course cours) {
        if (estUnCours)
            coursSuivis.put(cours, coursSuivis.get(cours) + 1);
        else
            tdSuivis.put(cours, tdSuivis.get(cours) + 1);
        this.changeHealth(-10);
    }

    /**
     * savoir si le joueur a suivi plus de cours que de td pour une matière
     * donnée
     * 
     * @param cours
     *            : la matiere
     * @return true si l'etudiant a suivi suffisament de cours avant
     */
    public boolean peutAssissterAUnTd(Course cours) {
        return tdSuivis.get(cours) < coursSuivis.get(cours);
    }

    /**
     * lance un examen
     * 
     * @param cours
     *            la matiere de l'examen
     * @return true si l'examen est réussi
     */
    public boolean faireEtReussirUnExamen(Course cours) {
        Quizz q = new Quizz(cours);
        q.startQuizz();
        q.printScore();
        return q.isPassed();
    }

    /**
     * 
     * @return true si l'etudiant a assez d'énergie pour passer un test
     */
    public boolean santeMiniPourParticiperAUnExam() {
        return health >= SANTEMINPOURTEST;
    }

    public int getNbCoursOuTdSuivis(Course cours, boolean estUnCours) {
        if (estUnCours)
            return coursSuivis.get(cours);
        else
            return tdSuivis.get(cours);
    }

    /**
     * @param nb
     *            le changement d'énergie à changer
     */
    public void changeHealth(int nb) {
        int healthChange;
        String blabla;
        if (nb > 0)
            blabla = "" + Language.VOTREENERGIEAAUGMENTE;
        else
            blabla = "" + Language.VOTREENERGIEADIMINUE;
        if (health + nb >= 0) {
            healthChange = nb;
            this.health += nb;
        } else {
            healthChange = health;
            this.health = 0;
        }
        System.out.print(blabla + Math.abs(healthChange) + "\n");
    }

    /**
     * @param cours
     *            la matière
     * @return true si l'élève a suivi les cours et td nécessaires pour passer
     *         l'examen
     */
    public boolean aSuiviTousLesCoursEtTD(Course cours) {
        return coursSuivis.get(cours) >= cours.getNbMiniCoursExam()
                && tdSuivis.get(cours) >= cours.getNbMiniCoursExam();
    }

    /**
     * Fait oublier a l'etudiant le dernier cours et le dernier TD correspondant
     * a ce cours sauf s'il avait un cours d'avance
     * 
     * @param cours
     *            le cours a oublier
     */
    public void oublierCours(Course cours) {
        String res = "" + Language.VOUSETESDISTRAITS;
        if (peutOublierCours(cours)) {
            if (coursSuivis.get(cours) == tdSuivis.get(cours)) {// si
                                                                // nbcours=nbtd
                tdSuivis.put(cours, tdSuivis.get(cours) - 1);// alors on enlève
                                                             // un td
                res += "" + Language.ETUN + Language.TD;
            }
            coursSuivis.put(cours, coursSuivis.get(cours) - 1);// dans tous les
                                                               // cas on enlève
                                                               // un cours
            System.out.println(res + Language.DE + cours.getName());
        }
    }

    /**
     * @param cours
     *            la matière
     * @return true si l'élève a suivi au moins un cours
     */
    public boolean peutOublierCours(Course cours) {
        return coursSuivis.get(cours) >= 1;
    }

    /**
     * l'élève a lu le livre de POO, il va donc connaitre tous les cours
     * 
     * @return le livrePOOLu
     */
    public void livrePOOLu() {
        coursSuivis.put(Game.getCourses()[0],
                Game.getCourses()[0].getNbMiniCoursExam());
    }

    /**
     * @return le sac de l'élève
     */
    public Bag getSac() {
        return sac;
    }

    /**
     * @return l'énergie du joueur
     */
    public int getHealth() {
        return health;
    }

    /**
     * Affiche les informations de l'élève (énergie et cours/td suivis)
     */
    public void printInfos() {
        // on affiche l'énergie
        System.out.println("" + Language.VOTREENERGIE + health + ".");
        // on affiche les cours/td suivis
        System.out.println(Language.SUIVI);
        for (Course co : Game.getCourses()) {
            System.out.println("_" + co.getName() + " : " + coursSuivis.get(co)
                    + Language.COURS + ", " + tdSuivis.get(co) + Language.TD);
        }
    }

}
