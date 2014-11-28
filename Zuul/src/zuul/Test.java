package zuul;

import java.util.HashMap;

public class Test{
	public static void main(String args[]) {
		Language.initLanguage("FR");
		//System.out.println(Language.BONJOUR);

		//Corridor c = new Corridor("test");
		//c.action(null);
		
		//CheatSheet a = new CheatSheet(new Course("POO"));
		//a.use();
		
		//Tablet t = new Tablet();
		//t.use(null);
		
		//Lunchroom l = new Lunchroom("test");
		//l.action(null);
		
		//Library l = new Library("test");
		//l.action(null);
		
		Student s = new Student();
		s.drinkCoffee();
		ExamRoom e = new ExamRoom("test");
		e.action(s);
		
	}
}