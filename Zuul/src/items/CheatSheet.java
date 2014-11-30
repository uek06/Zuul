package items;

import game.Language;

import java.util.ArrayList;

import courses.Course;
import courses.Question;
import player.Student;

/**
 * Feuille de triche
 * 
 * @author
 *
 */
public class CheatSheet extends Item {
    private ArrayList<Question> questions;
    private Course course;

    /**
     * @param course
     *            la matière de la feuille de triche
     */
    public CheatSheet(Course course) {
        this.course = course;
        questions = course.getQuestions();
        description = Language.FEUILLETRICHE + course.getName();
    }

    /**
     * Permet de lire la feuille de triche pour avoir les reponses et les
     * questions d'un examen donne
     */
    @Override
    public void use(Student player) {
        System.out.println(Language.VOICIREPONSES + course.getName() + "\n");
        for (Question q : questions) {
            System.out.println(q + "\n" + q.getAnswer() + "\n");
        }

    }
}