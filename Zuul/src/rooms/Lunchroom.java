package rooms;

import game.Game;
import game.Language;
import items.Coffee;

import java.util.Random;

import courses.Course;
import player.Student;

/**
 * Cafétéria
 * @author 
 *
 */
public class Lunchroom extends Room {

    public Lunchroom(String description) {
        super(description);
    }

    @Override
    public void action(Student player) {
        Random r = new Random();
        if (r.nextInt(10) > 6)
            playBabyFoot(player);
        System.out.println(Language.CAFETROUVE);
        player.getSac().addItem(new Coffee());
    }

    private void playBabyFoot(Student player) {
        System.out.println(Language.VOUSJOUEZ);
        Course c = Game.getRandomCourse();
        player.oublierCours(c);
    }
}