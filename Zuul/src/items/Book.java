package items;

import player.Student;

/**
 * Livre
 * 
 * @author
 *
 */
public class Book extends Item {
    private String title, content;
    private static final int ENERGIELIVRE = -5;

    public Book(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void use(Student player) {
        if ("Objects First".equals(title)) {
            player.livrePOOLu();
        }
        System.out.println(content);
        player.changeHealth(ENERGIELIVRE);
    }

    @Override
    public String toString() {
        return title;
    }

}