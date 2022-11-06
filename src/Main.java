import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        boolean keepRunning = true;
        CollectionOfBG theBoardGame = new CollectionOfBG();
        Scanner scan = new Scanner(System.in);
        theBoardGame.intro();
        while (keepRunning){
            System.out.println("Type (C) to save a new Board Games \n" +
                    "Type (R) to read all Board Games \n" +
                    "Type (U) to update a Board Game\n" +
                    "Type (D) to remove a Board Game\n \n" +
                    "Type (S) to save newly added Board Games\n" +
                    "Type (Q) to quit");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("C")){
                theBoardGame.create();
            } else if (answer.equalsIgnoreCase("R")){
                theBoardGame.read();
            } else if (answer.equalsIgnoreCase("U")) {
                theBoardGame.update();
            } else if (answer.equalsIgnoreCase("D")) {
                theBoardGame.delete();
            } else if (answer.equalsIgnoreCase("S")) {
                //theBoardGame.saveData();

                try {
                    FileOutputStream fileOut = new FileOutputStream("BoardGames.ser");
                    //fileOut does load successfully
                    //responsible for opening a connection to a file
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    //out does load successfully
                    out.writeObject(theBoardGame);
                    //writing the object that we passed in = where we're directly writing the file
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized Array data is saved!!!");
                } catch (IOException i) {
                    i.printStackTrace();
                    //history of all the methods that were called - allow us to see where the code went wrong.
                }

            } else if (answer.equalsIgnoreCase("Q")) {
                keepRunning = false;
            }
        }
    }

}
