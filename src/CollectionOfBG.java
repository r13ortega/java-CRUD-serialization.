import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CollectionOfBG implements Serializable{

    ArrayList<BoardGames> boardGames;
    //transient Scanner scan = new Scanner(System.in);
    //transient should fix this maybe
    //unable to implements Serializable because of Scanner, stupid

    public CollectionOfBG() {
        this.boardGames = new ArrayList<>();
    }

    public void create(){
        //Scanner scan = new Scanner(System.in);
        System.out.println("Let's add a new board game\n" +
                "Please enter in the (Name) of the Board Game");
        Scanner scan = new Scanner(System.in);
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
        Scanner scan = new Scanner(System.in);
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
        Scanner scan = new Scanner(System.in);
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
        this.boardGames = null;
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
