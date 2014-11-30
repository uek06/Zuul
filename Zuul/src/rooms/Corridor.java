package rooms;

import game.Game;
import game.Language;
import game.WordReader;
import items.CheatSheet;
import items.Item;
import items.Tablet;

import java.util.ArrayList;
import java.util.Random;

import player.Student;

/**
 * Couloir
 * 
 * @author
 *
 */
public class Corridor extends Room {
    private ArrayList<Item> objectsInTheCorridor = new ArrayList<Item>();

    public Corridor(String description) {
        super(description);
    }

    public void action(Student player) {
        objectsInTheCorridor.clear();
        putItemsInTheCorridorRandomly();
        Random r = new Random();
        if (r.nextBoolean())
            listItemsInTheCorridor(player);// lumière allumée
        else {
            System.out.println(Language.COULOIRETEINT);
            while (true) {
                String choix = WordReader.getWord();
                if (choix.equals("" + Language.OUI)) {
                    System.out.println(Language.VOUSALLUMEZ);
                    listItemsInTheCorridor(player);
                    break;
                } else if (choix.equals("" + Language.NON))
                    break;
                else
                    System.out.println(Language.VEUILLEZSAISIR);
            }
        }
    }

    private void putItemsInTheCorridorRandomly() {
        Random r = new Random();
        if (r.nextInt(10) > 8) {
            objectsInTheCorridor.add(new CheatSheet(Game.getRandomCourse()));
        }
        if (r.nextInt(8) > 6) {
            objectsInTheCorridor.add(new Tablet());
        }
    }

    private void listItemsInTheCorridor(Student player) {
        if (!objectsInTheCorridor.isEmpty()) {
            System.out.println(Language.ILYAQUELQUECHOSE);
        }
        for (Item i : objectsInTheCorridor) {
            System.out.println(i.getDescription()
                    + Language.VOUSMETTEZCA);
            player.getSac().addItem(i);
        }
    }

}