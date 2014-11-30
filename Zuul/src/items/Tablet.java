package items;

import game.Game;
import game.Language;

import java.util.Random;

import courses.Course;
import player.Student;

/**
 * Tablette qui contient soit un jeu vidéo soit cours
 * 
 * @author ugo
 *
 */
public class Tablet extends Item {
    private Course course;

    public Tablet() {
        course = Game.getRandomCourse();
        description = "Une tablette";
    }

    /**
     * @return true si la tablette est en fait pour jouer et non pas pour
     *         apprendre un cours
     */
    private boolean jouerAUnJeuVideo() {
        Random r = new Random();
        if (r.nextInt(10) < 3) {
            return true;
        }
        return false;
    }

    @Override
    public void use(Student player) {
        if (jouerAUnJeuVideo()) {
            System.out.println("Vous jouez à Mario et vous adorez ça.");
            player.oublierCours(course);
        } else {
            Random r = new Random();
            boolean estUnCours = r.nextBoolean();
            String coursOuTd;
            if (estUnCours)
                coursOuTd = "" + Language.COURS;
            else
                coursOuTd = "" + Language.TD;
            System.out.println(Language.FELICITATIONSITEM + coursOuTd
                    + course.getName());
            if (player.peutAssissterAUnTd(course))
                player.assissterAUnCoursOuTd(estUnCours, course);
            else
                System.out.println(Language.ERREURPASASSEZDECOURS);
        }
    }
}