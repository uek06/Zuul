package courses;

import java.util.ArrayList;

/**
 * Matière
 * 
 * @author ugo
 *
 */
public class Course {
    private String name;
    private boolean isCompulsory;
    private int nombreMiniCoursExam;
    private ArrayList<Question> questions = new ArrayList<Question>();

    /**
     * @param name
     *            nom de la matière
     * @param isCompulsory
     *            true si obligatoire, false sinon
     * @param nombreMiniCoursExam
     *            nb de cours qu'il faut pour passer l'exam
     */
    public Course(String name, boolean isCompulsory, int nombreMiniCoursExam) {
        this.name = name;
        this.isCompulsory = isCompulsory;
        this.nombreMiniCoursExam = nombreMiniCoursExam;
    }

    /**
     * @return true si la matière est obligatoire
     */
    public boolean isCompulsory() {
        return isCompulsory;
    }

    /**
     * @return le nombre de cours qu'il faut pour passer l'exam
     */
    public int getNbMiniCoursExam() {
        return nombreMiniCoursExam;
    }

    /**
     * @param question
     *            question
     * @param answer
     *            réponse
     */
    public void addQuestion(String question, boolean answer) {
        questions.add(new Question(question, answer));
    }

    /**
     * @return une liste de toutes les questions de la matière
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * @return nom de la matière
     */
    public String getName() {
        return name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Reference equality.
        }
        if (!(obj instanceof Course)) {
            return false; // Not the same type.
        }
        // Gain access to the other student’s fields.
        Course other = (Course) obj;
        return name.equals(other.getName());
    }

}
