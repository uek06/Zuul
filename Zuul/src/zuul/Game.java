package zuul;

import java.util.Random;

/**
 * @author ugo
 *
 */
public class Game {
    private Room currentRoom;
    private String word;
    private Student player;
    private static final Course POO=new Course("POO");
    private static final Course SSII=new Course("SSII");
    private static final Course VIDE=new Course("");
    private static final Course[] COURSES = {POO,SSII,VIDE};
    
    public Game(){
        //methode qui demande la langue ?
        Language.initLanguage("FR");
        createRooms();
        player=new Student();
        player.initMap(COURSES);

    }
    
    private void createRooms(){
        Room corridor1, corridor2, corridor3, corridor4, corridor5;
        Room classroom1, classroom2, lab1, lab2, examRoom, library, lunchroom;
        corridor1=new Corridor(""+Language.DESCRIPTIONCOULOIR);
        corridor2=new Corridor(""+Language.DESCRIPTIONCOULOIR);
        corridor3=new Corridor(""+Language.DESCRIPTIONCOULOIR);
        corridor4=new Corridor(""+Language.DESCRIPTIONCOULOIR);
        corridor5=new Corridor(""+Language.DESCRIPTIONCOULOIR);
        classroom1=new Classroom(Language.DESCRIPTIONAMPHI+"1");
        classroom2=new Classroom(Language.DESCRIPTIONAMPHI+"2");
        lab1=new Lab(Language.DESCRIPTIONTD+"1");
        lab2=new Lab(Language.DESCRIPTIONTD+"2");
        examRoom=new ExamRoom(""+Language.DESCRIPTIONEXAM);
        library=new Library(""+Language.DESCRIPTIONBIBLIO);
        lunchroom=new Lunchroom(""+Language.DESCRIPTIONCAFET);
        
        corridor1.setExit(""+Language.OUEST,corridor4);
        corridor1.setExit(""+Language.NORD,corridor2);
        corridor1.setExit(""+Language.EST,corridor5);
        
        corridor2.setExit(""+Language.SUD,corridor1);
        corridor2.setExit(""+Language.NORD,corridor3);
        
        corridor3.setExit(""+Language.SUD,corridor2);
        corridor3.setExit(""+Language.OUEST,library);
        corridor3.setExit(""+Language.NORD,lab1);
        corridor3.setExit(""+Language.EST,lab2);
       
        corridor4.setExit(""+Language.OUEST,classroom1);
        corridor4.setExit(""+Language.NORD,classroom2);
        corridor4.setExit(""+Language.EST,corridor1);
        
        corridor5.setExit(""+Language.OUEST,corridor1);
        corridor5.setExit(""+Language.NORD,examRoom);
        corridor5.setExit(""+Language.EST,lunchroom);
        
        classroom1.setExit(""+Language.EST,corridor4);
        
        classroom2.setExit(""+Language.SUD,corridor4);
        
        lab1.setExit(""+Language.SUD,corridor3);
        
        lab2.setExit(""+Language.OUEST,corridor3);
        
        examRoom.setExit(""+Language.SUD,corridor5);
        
        library.setExit(""+Language.EST,corridor3);
        
        lunchroom.setExit(""+Language.OUEST,corridor5);   
        
        currentRoom=corridor1;
    }

    public void play() {
        printWelcome();
        boolean finished = false;
        while (!finished) {
            word=WordReader.getWord();
            finished = processCommand(word);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    private void printWelcome() {
        System.out.println();
        System.out.println(Language.BIENVENUE);
        System.out.println(currentRoom.getLongDescription());
        System.out.println(currentRoom.getExitString());
    }
    
    private boolean processCommand(String w) {
        boolean wantToQuit=false;
        if (w.equals(Language.SORTIE)) wantToQuit=true;
        else if(w.equals("lol")) player.printInfos();
        else{
            goRoom(w);
        }
        return wantToQuit;
    }
    private void goRoom(String direction) {
        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println(Language.PASDEPORTE);
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            currentRoom.action(player);
            System.out.println(currentRoom.getExitString());
        }
    }
    
    /**
     * 
     * @return Un Objet Course pris au hasard dans le tableau des matieres  
     */
    public static Course getRandomCourse(){
        Random r = new Random();
        return COURSES[r.nextInt(COURSES.length)];
    }
    
    public static void main(String[] args){
        System.out.println("sfsdf");
        Game test=new Game();
        test.play();
    }
}
