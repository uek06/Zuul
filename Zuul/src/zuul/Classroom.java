package zuul;

public class Classroom extends Workroom{
    private String choix;
    public Classroom(String description) {
        super(description);
    }
    
    public void action(Student s) throws InterruptedException {
        course=Game.getRandomCourse();
        //course=new Course("SSII");
        switch(course.getName()){
        case "POO":
            System.out.println(Language.COURSACTUEL+course.getName());
            System.out.println(Language.VOUSDEVEZASSISTER);
            displayCourse(s);
            break;
        case "SSII":
            System.out.println(Language.COURSACTUEL+course.getName());
            System.out.println(Language.VOULEZVOUSASSISTER);
            while(true){
                choix=WordReader.getWord();
                if (choix.equals(""+Language.OUI)){
                    displayCourse(s);
                    break;
                }
                else if(choix.equals(""+Language.NON)){
                    System.out.println(Language.REVENEZPLUSTARD);
                    break;
                }
                else System.out.println(Language.VEUILLEZSAISIR);
            }
            break;
        default: System.out.println(Language.PASCOURS);
        }
        
    }
    
    public void displayCourse(Student s) throws InterruptedException{
        for (int i = 0; i < 6; i++) {
            Thread.sleep(1000);
            System.out.print(".");
        }
        System.out.println("\n"+Language.COURSFINI);
        System.out.println(Language.FELICITATIONSITEM+course.getName()+" !");
        s.assissterAUnCours(course);
        
    }

}
