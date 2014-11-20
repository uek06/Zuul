package zuul;

public class Game {
    
    private void createRooms(){
        Room corridor1, corridor2, corridor3, corridor4, corridor5;
        Room classroom1, classroom2, lab1, lab2, examRoom, library,lunchroom;
        corridor1=new Room("dans le hall");
        corridor2=new Room("dans un couloir");
        corridor3=new Room("dans un couloir");
        corridor4=new Room("dans un couloir");
        corridor5=new Room("dans un couloir");
        classroom1=new Room("dans l'amphi 1");
        classroom2=new Room("dans l'amphi 2");
        lab1=new Room("dans la salle de TD 1");
        lab2=new Room("dans la salle de TD 2");
        examRoom=new Room("dans la salle d'examen");
        library=new Room("dans la bibliothèque");
    }
}
