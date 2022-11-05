import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean keepRunning = true;
        CollectionOfBG boardgames = new CollectionOfBG();
        Scanner scan = new Scanner(System.in);
        boardgames.intro();
        while (keepRunning){
            System.out.println("Type (C) to save a new Board Games \n" +
                    "Type (R) to read all Board Games \n" +
                    "Type (U) to update a Board Game\n" +
                    "Type (D) to remove a Board Game\n \n" +
                    "Type (S) to save newly added Board Games" +
                    "Type (Q) to quit");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("C")){
                boardgames.create();
            } else if (answer.equalsIgnoreCase("R")){
                boardgames.read();
            } else if (answer.equalsIgnoreCase("U")) {
                boardgames.update();
            } else if (answer.equalsIgnoreCase("D")) {
                boardgames.delete();
            } else if (answer.equalsIgnoreCase("S")) {
                boardgames.saveData();
            } else if (answer.equalsIgnoreCase("Q")) {
                keepRunning = false;
            }
        }
    }
}
