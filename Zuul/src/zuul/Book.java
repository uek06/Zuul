package zuul;

public class Book extends Item{
	
	private String title,content;
	public Book(String title,String content){
		this.title=title;
		this.content=content;
	}
	
	public void use(Student player) {
		if ("Objects First".equals(title)){
			player.setLivrePOOLu();
			player.lowerHealth(5);
		}
		System.out.println(content);
	}

	@Override
	public String toString() {
		return title;
	}
	
	
}