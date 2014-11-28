package zuul;

public class Coffee extends Item{
    public static final int ENERGIECAFFE=50;
    
	public Coffee(){
	}

	@Override
	public void use(Student player) {
	    player.changeHealth(ENERGIECAFFE);
	}
}