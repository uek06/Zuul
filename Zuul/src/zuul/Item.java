package zuul;

public abstract class Item{
	protected String description;

	/*
	public Item(String description){
		this.description=description;
	}
*/

	
	public String getDescription(){
		return description;
	}
	
	
	public abstract void use(Student player);
}