import java.io.*;

public class BoardGames implements Serializable {

    public String boardGameName;

    public int minNumOfPlayers;

    public int maxNumOfPlayers;

    private boolean originalOwner;

    public BoardGames(String boardGameName, int minNumOfPlayers, int maxNumOfPlayers, boolean originalOwner) {
        this.boardGameName = boardGameName;
        this.minNumOfPlayers = minNumOfPlayers;
        this.maxNumOfPlayers = maxNumOfPlayers;
        this.originalOwner = originalOwner;
    }

    @Override
    public String toString() {
        return "BoardGames{" +
                "boardGameName='" + boardGameName + '\'' +
                ", minNumOfPlayers=" + minNumOfPlayers +
                ", maxNumOfPlayers=" + maxNumOfPlayers +
                '}';
    }

    public boolean isOriginalOwner() {
        return originalOwner;
    }

    public void setOriginalOwner(boolean originalOwner) {
        this.originalOwner = originalOwner;
    }
}
