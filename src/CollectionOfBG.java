import java.util.ArrayList;
import java.util.Scanner;

public class CollectionOfBG {

    ArrayList<BoardGames> boardGames;
    Scanner scan = new Scanner(System.in);

    public void CollectionOfBG() {
        boardGames = new ArrayList<>();
    }

    public void intro(){
        System.out.println("Hello again, welcome to Board Games Manager\n" +
                "Where we strive to give you the best experience in Board Game Managing\n" +
                "First things, first...\n" +
                "Would you like to load the previous data?\n" +
                "Type (1) for Yes\n" +
                "Type (2) for No");
        String loadAnswer = scan.nextLine();
        if(loadAnswer.equalsIgnoreCase("Yes")){
            loadData();
            System.out.println("\n" +
                    "Loading Data......\n" +
                    "Data loaded\n" +
                    "Welcome to Board Game Manager!!!");
        } else if (loadAnswer.equalsIgnoreCase("No")) {
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
        boolean owner =true;
        System.out.println("Do you own this Board Game?\n" +
                "(True) or (False)");
        String borrow = scan.nextLine();
        try {
            if (borrow.equalsIgnoreCase("true")){
                owner = true;
            } else if (borrow.equalsIgnoreCase("false")) {
                owner = false;
            }
        } catch (Exception e){
            System.out.println("invalid entry try again");
            System.out.println("Do you own this Board Game?\n" +
                    "(True) or (False)");
            borrow = scan.nextLine();
        }
        BoardGames bg = new BoardGames(bGName,maxPlayers, maxPlayers, owner);
        boardGames.add(bg);
    }
    public void read(){
        for (BoardGames bg: boardGames) {
            System.out.println(bg.toString());
        }
    }
    public void update(){

    }
    public void delete(){

    }
    public void saveData(){

    }
    public void loadData(){

    }
    public void getBorrowing(){
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
