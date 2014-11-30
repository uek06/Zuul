package player;

import game.Language;
import game.WordReader;
import items.Item;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Sac qui contient des objets
 * 
 * @author ugo
 *
 */

public class Bag {
    private ArrayList<Item> sac = new ArrayList<Item>();
    private Student player;
    private HashMap<Integer, Integer> numeroEtIndice = new HashMap<Integer, Integer>();

    /**
     * @param player
     *            le joueur qui possède ce sac
     */
    public Bag(Student player) {
        this.player = player;
    }

    /**
     * @param i
     *            l'objet qu'on veut ajouter au sac
     */
    public void addItem(Item i) {
        sac.add(i);
    }

    /**
     * affiche le contenu du sac et propose à l'utilisateur d'utiliser des
     * objets
     */
    public void printSac() {
        if (sac.size() >= 1) { // si le sac n'est pas vide
            printContenuSac();
            while (true) {
                System.out.println(Language.TAPEZ);
                int number = WordReader.getInt();
                if (number == 0)
                    break;
                Item i = getItem(number);
                if (i != null) {
                    i.use(player);
                    sac.remove(i);
                } else
                    System.out.println(Language.PASOBJET);
            }
        } else
            System.out.println();
    }

    /**
     * affiche le contenu du sac
     */
    private void printContenuSac() {
        ArrayList<String> descriptions = new ArrayList<String>();
        for (Item i : sac)
            descriptions.add(i.getDescription());// on stocke toutes les
                                                 // descriptions de tous les
                                                 // items
        ArrayList<String> listeDesObjetsEcrits = new ArrayList<String>();
        numeroEtIndice.clear();
        System.out.println("\n" + Language.CONTENUSAC);
        int nb = 1;
        for (int i = 0; i < sac.size(); i++) {
            String description = sac.get(i).getDescription();
            if (!listeDesObjetsEcrits.contains(description)) {// si on a pas
                                                              // déjà écrit
                                                              // l'objet
                int occurence = java.util.Collections.frequency(descriptions,
                        description);// on récupère son occurence
                System.out.println(nb + ") " + description
                        + Language.VOUSENAVEZ + occurence);
                numeroEtIndice.put(nb, i);
                nb++;
                listeDesObjetsEcrits.add(description);// on l'ajoute à la liste
                                                      // des objets écrits afin
                                                      // de ne pas le réécrire 2
                                                      // fois
            }
        }
    }

    /**
     * @param number
     *            le numéro de l'objet qu'on veut utiliser
     * @return l'objet qu'on veut utiliser
     */
    private Item getItem(int number) {
        try {
            return sac.get(numeroEtIndice.get(number));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

}
