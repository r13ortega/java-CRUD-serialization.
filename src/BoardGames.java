public class BoardGames {

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

    public boolean isOriginalOwner() {
        return originalOwner;
    }

    public void setOriginalOwner(boolean originalOwner) {
        this.originalOwner = originalOwner;
    }
}
