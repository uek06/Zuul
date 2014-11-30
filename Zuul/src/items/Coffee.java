package items;

import player.Student;

/**
 * Café
 * 
 * @author
 *
 */
public class Coffee extends Item {
    public static final int ENERGIECAFE = 50;

    public Coffee() {
        description = "Café";
    }

    @Override
    public void use(Student player) {
        player.changeHealth(ENERGIECAFE);
    }

}