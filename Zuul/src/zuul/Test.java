package zuul;

public class Test{
	public static void main(String args[]) {
		Language.initLanguage("FR");
		System.out.println(Language.BONJOUR);

		Item b = new Book("un livre");

		Quizz a = new Quizz(new Course("OOP"));
		a.startQuizz();
		System.out.println(a.isPassed());
		a.printScore();

	}
}