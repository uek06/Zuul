package rooms;

import game.Game;
import game.Language;

import java.util.Random;

import courses.Quizz;
import player.Student;

/**
 * Salle d'examen
 * 
 * @author
 *
 */
public class ExamRoom extends Workroom {

    public ExamRoom(String description) {
        super(description);
    }

    public void action(Student s) {
        Random rand = new Random();
        // 1 chance sur le nombre de matières pour qu'il n'y ait pas cours
        if (rand.nextInt(Game.getCourses().length + 1) == 1)
            System.out.println(Language.PASCOURS);
        else {
            course = Game.getRandomCourse();
            System.out.println("" + Language.ACTUELLEMENT + Language.EXAMEN
                    + Language.DE + course.getName());
            if (!(s.aSuiviTousLesCoursEtTD(course))) {
                System.out.println(Language.VOUSNAVEZ2 + course.getName());
                System.out.println(+s.getNbCoursOuTdSuivis(course, true)
                        + +s.getNbCoursOuTdSuivis(course, false) + ""
                        + Language.TD2);
                System.out.println("" + Language.VOUSDEVEZ
                        + course.getNbMiniCoursExam());
            } else if (!s.santeMiniPourParticiperAUnExam()) {
                System.out.println(Language.PASASSEZ);
                System.out.println("" + Language.VOTREENERGIE2 + s.getHealth());
                System.out.println("" + Language.ENERGIEMINIMALE
                        + Student.SANTEMINPOURTEST);
            } else
                caseCours(s);
        }
    }

    @Override
    public void displayCourse(Student s) {
        Quizz q = new Quizz(course);
        q.startQuizz();
        q.printScore();
        if (q.isPassed()) {
            if ("POO".equals(course.getName())) {
                Game.finish();
                System.out.println(Language.GAGNE);
            }
        } else
            System.out.println(Language.ECHOUE);
    }
}
