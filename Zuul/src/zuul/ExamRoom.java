package zuul;

public class ExamRoom extends Workroom{
    public ExamRoom(String description) {
        super(description);
    }
    
    
    public void displayCourse(Student s) {
    	Quizz q = new Quizz(course);
    	q.startQuizz();
    	q.printScore();
    }
}