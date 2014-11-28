package zuul;

public class Book extends Item{
	private String title,content;
	private static final int ENERGIELIVRE=5;
	public Book(String title,String content){
		this.title=title;
		this.content=content;
	}
	
	public void use(Student player) {
		if ("Objects First".equals(title)){
			player.livrePOOLu();
			player.changeHealth(ENERGIELIVRE);
		}
		System.out.println(content);
	}

	@Override
	public String toString() {
		return title;
	}
	
	
}