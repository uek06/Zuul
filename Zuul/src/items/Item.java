package items;

import player.Student;

/**
 * Objet quelconque
 * 
 * @author
 *
 */
public abstract class Item {
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void use(Student player);
}