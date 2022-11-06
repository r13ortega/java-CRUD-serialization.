import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CollectionOfBG implements Serializable{

    ArrayList<BoardGames> boardGames;
    Scanner scan = new Scanner(System.in);
    //transient should fix this maybe
    //unable to implements Serializable because of Scanner, stupid 

    public CollectionOfBG() {
        this.boardGames = new ArrayList<>();
    }

    public void intro(){
        System.out.println("Hello again, welcome to Board Games Manager\n" +
                "Where we strive to give you the best experience in Board Game Managing\n" +
                "First things, first...\n" +
                "Would you like to load the previous data?\n" +
                "Type (1) for Yes\n" +
                "Type (2) for No");
        String loadAnswer = scan.nextLine();
        if(loadAnswer.equalsIgnoreCase("1")){
            loadData();
            System.out.println("\n" +
                    "Loading Data......\n" +
                    "Data loaded\n" +
                    "Welcome to Board Game Manager!!!");
        } else if (loadAnswer.equalsIgnoreCase("2")) {
            System.out.println("\n" +
                    "Very well, welcome to Jurassic... ummm I mean welcome to Board Game Manager!!!");
        }
    }
    public void create(){
        System.out.println("Let's add a new board game\n" +
                "Please enter in the (Name) of the Board Game");
        String bGName = scan.nextLine();
        System.out.println("Please enter in the minimum number of players needed to play");
        int minPlayers = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter in the maximum number of players needed to play");
        int maxPlayers = scan.nextInt();
        scan.nextLine();
        //boolean owner = true;
        System.out.println("Do you own this Board Game?\n" +
                "(true) or (false)");
        boolean owner = scan.nextBoolean();
        scan.nextLine();
//            if (mine == true){
//                owner = true;
//            } else if (mine == false) {
//                owner = false;
//            }
        BoardGames bG = new BoardGames(bGName,minPlayers, maxPlayers, owner);
        boardGames.add(bG);
    }
    public void read(){
        for (BoardGames bg: boardGames) {
            System.out.println(bg.toString());
        }
    }
    public void update(){
        System.out.println("Let's update a board game\n" +
                "Please enter in the (Name) of the Board Game you wish to update");
        String searchName = scan.nextLine();
        for (BoardGames bg: boardGames) {
            if (searchName.equalsIgnoreCase(bg.boardGameName)){
                System.out.println("Please enter in the minimum number of players needed to play");
                int minPlayers = scan.nextInt();
                scan.nextLine();
                System.out.println("Please enter in the maximum number of players needed to play");
                int maxPlayers = scan.nextInt();
                scan.nextLine();
                System.out.println("Do you own this Board Game?\n" +
                        "(true) or (false)");
                boolean owner = scan.nextBoolean();
                scan.nextLine();
                bg.boardGameName = searchName;
                bg.minNumOfPlayers = minPlayers;
                bg.maxNumOfPlayers = maxPlayers;
                bg.setOriginalOwner(owner);
            }
        }
    }
    public void delete(){
        System.out.println("Warning, once deleted we cannot retrieve the Board Game\n" +
                "Please enter in the (Name) of the Board Game you wish to Remove");
        String searchName = scan.nextLine();
        for (BoardGames bg: boardGames) {
            if (searchName.equalsIgnoreCase(bg.boardGameName)){
                boardGames.remove(bg);
            }
        }
    }
    public void saveData(){
        //method does load successfully
             try {
            FileOutputStream fileOut = new FileOutputStream("BoardGames.ser");
            //fileOut does load successfully
            //responsible for opening a connection to a file
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //out does load successfully
            out.writeObject(this.boardGames);
          //writing the object that we passed in = where we're directly writing the file
            out.close();
           fileOut.close();
             System.out.println("Serialized Array data is saved!!!");
        } catch (IOException i) {
            i.printStackTrace();
            //history of all the methods that were called - allow us to see where the code went wrong.
        }
    }
    public void loadData(){
        try {
            //read object from a file
            FileInputStream file = new FileInputStream("BoardGames.ser");
            //create a connection to a file
            ObjectInputStream in = new ObjectInputStream(file);
            //method for deserialize of an object
            this.boardGames = (ArrayList<BoardGames>) in.readObject();
            //read object  and convert data to type BoardGames
            in.close();
            file.close();
            System.out.println("ArrayList has been deserialized!! OMG!");
        } catch (IOException z){
            z.printStackTrace();
        } catch (ClassNotFoundException f){
            f.printStackTrace();
        }
    }
    public void borrowingBoardGame(){ //getBorrowing()
        int numOfBorrowing = 0;
        for (BoardGames bg: boardGames) {
            if (bg.isOriginalOwner() == false){
                System.out.println(boardGames.toString());
                numOfBorrowing++;
            }
        }
        System.out.println("You are currently borrowing " + numOfBorrowing + " Board Games");
    }
    public void stealBoardGames(){
        for (BoardGames bg: boardGames) {
            if (bg.isOriginalOwner() == false){
                bg.setOriginalOwner(true);
            }
        }
        System.out.println("heh, you are currently borrowing 0 Board Games");
    }
}
