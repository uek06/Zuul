package zuul;

import java.util.ArrayList;

/**
 * @author ugo
 *
 */
public class Course {
    private String name;
    private boolean isCompulsory;
    private int nombreMiniCoursExam;
    private ArrayList<Question> questions=new ArrayList<Question>();
    
    public Course(String name,boolean isCompulsory,int nombreMiniCoursExam){
        this.name=name;
        this.isCompulsory=isCompulsory;
        this.nombreMiniCoursExam=nombreMiniCoursExam;
    }

	public String getName() {
		return name;
	}

	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true; // Reference equality.
		}
		if(!(obj instanceof Course)) {
			return false; // Not the same type.
		}
		// Gain access to the other student’s fields.
		Course other = (Course) obj;
		return name.equals(other.getName());
	}

	public boolean isCompulsory() {
		return isCompulsory;
	}

	public int getNbMiniCoursExam() {
		return nombreMiniCoursExam;
	}

    public void addQuestion(String question, boolean answer) {
        questions.add(new Question(question,answer));
    }
    
    public ArrayList<Question> getQuestions(){
        return questions;
    }
	
}
