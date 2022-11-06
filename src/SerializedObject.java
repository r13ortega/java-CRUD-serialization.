import java.io.*;

public class SerializedObject implements Serializable{

    public static void saveData(CollectionOfBG theBoardGame){
        //method does load successfully
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
    }
    public static void loadData(){
        CollectionOfBG theBoardGame;
        try {
            //read object from a file
            FileInputStream file = new FileInputStream("BoardGames.ser");
            //create a connection to a file
            ObjectInputStream in = new ObjectInputStream(file);
            //method for deserialize of an object
            theBoardGame = (CollectionOfBG) in.readObject();
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
}

