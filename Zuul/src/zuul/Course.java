package zuul;

/**
 * @author ugo
 *
 */
public class Course {
    private String name;
    
    public Course(String name){
        this.name=name;
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
	
}
