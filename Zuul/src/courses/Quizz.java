package courses;

import game.Language;
import game.WordReader;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Quizz de l'examen
 * 
 * @author
 *
 */
public class Quizz {
    private int points;
    private ArrayList<Question> questions;

    /**
     * Cree un quizz et charge le tableau des questions selon la matiere donnee
     * en parametre
     * 
     * @param c
     *            : la matiere du quizz
     */
    public Quizz(Course c) {
        points = 0;
        questions = c.getQuestions();
    }

    /**
     * Affiche la phrase de bienvenue d'un quizz
     */
    public void printWelcome() {
        System.out.println(Language.QUIZZBIENVENUE);
    }

    /**
     * Affiche toutes les informations d'une question
     * 
     * @param Question
     *            q : la question à afficher
     */
    public void printQuestion(Question q) {
        System.out.println("\n-" + q);
        System.out.print(Language.QUIZZVOTRECHOIX);

    }

    /**
     * Débute un quizz, permettant ainsi à l'utilisateur de répondre à toutes
     * les questions
     */
    public void startQuizz() {
        printWelcome();
        for (Question q : questions) {
            printQuestion(q);
            while (true)
                try {
                    boolean b = WordReader.getBoolean();
                    if (q.goodAnswer(b))
                        points++;
                    break;
                } catch (InputMismatchException e) {
                }
        }
    }

    /**
     * Renvoie true si l'utilisateur a répondu juste à au moins 50% des
     * questions du quizz
     */
    public boolean isPassed() {
        return points >= (float) questions.size() / 2;
    }

    /**
     * Affiche le score qu'a obtenu l'utilisateur au quizz
     */
    public void printScore() {
        System.out.println("" + Language.QUIZZVOTRESCOREESTDE + points + "/"
                + questions.size());
    }
}
