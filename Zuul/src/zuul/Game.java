package zuul;

/**
 * @author ugo
 *
 */
public class Game {
    
    private void createRooms(){
        Room corridor1, corridor2, corridor3, corridor4, corridor5;
        Room classroom1, classroom2, lab1, lab2, examRoom, library, lunchroom;
        corridor1=new Room(""+Language.DESCRIPTIONCOULOIR);
        corridor2=new Room(""+Language.DESCRIPTIONCOULOIR);
        corridor3=new Room(""+Language.DESCRIPTIONCOULOIR);
        corridor4=new Room(""+Language.DESCRIPTIONCOULOIR);
        corridor5=new Room(""+Language.DESCRIPTIONCOULOIR);
        classroom1=new Room(Language.DESCRIPTIONAMPHI+"POO");
        classroom2=new Room(Language.DESCRIPTIONAMPHI+"SSII");
        lab1=new Room(Language.DESCRIPTIONTD+"POO");
        lab2=new Room(Language.DESCRIPTIONTD+"SSII");
        examRoom=new Room(""+Language.DESCRIPTIONEXAM);
        library=new Room(""+Language.DESCRIPTIONBIBLIO);
        lunchroom=new Room(""+Language.DESCRIPTIONCAFET);
        
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
        
        
        
        
    }
}
