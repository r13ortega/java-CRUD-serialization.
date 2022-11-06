import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable{
    public static CollectionOfBG theBoardGame = new CollectionOfBG();
    public static void main(String[] args) {
        boolean keepRunning = true;
        //CollectionOfBG theBoardGame = null;
        Scanner scan = new Scanner(System.in);
        //theBoardGame.intro();
        //loadData();
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
                SerializedObject.saveData(theBoardGame);
            } else if (answer.equalsIgnoreCase("Q")) {
                keepRunning = false;
            }
        }
    }

}
