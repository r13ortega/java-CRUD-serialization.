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
        System.out.println("");

    }
    public void read(){

    }
    public void update(){

    }
    public void delete(){

    }
    public void saveData(){

    }
    public void loadData(){

    }
}
