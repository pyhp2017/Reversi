package OthelloGame;

import java.util.ArrayList;

/**
 *  Player represents a player in our game (We have two players)
 * @author Ahmad
 * @version 1.0
 */
public class Player
{
    //Player Name Field
    private String playerName;
    //List of Discs for Player
    private ArrayList<Disc> discs;
    //Player Sign
    private char sign;
    /**
     * Create a New Player
     */
    public Player(String pName, char sign)
    {
        this.playerName = pName;
        this.sign = sign;
        discs = new ArrayList<>();
    }

    /**
     *
     * @param x is x position
     * @param y is y position
     * @param board is board
     */
    public void addDisc(int x , int y, Grid board)
    {
            discs.add(new Disc(x,y));
            board.getGrid()[x][y] = this.getSign();
    }

    /**
     * Remove a disc
     * @param x is x position
     * @param y is y position
     */
    public void removeDisc(int x , int y)
    {
        discs.removeIf(disc -> disc.equals(new Disc(x, y)));
    }

    /**
     * Get Number of discs
     * @return  Number of Discs
     */
    public int numberOfDiscs()
    {
        return discs.size();
    }

    /**
     * Get Player Sign
     * @return sign
     */
    public char getSign() {
        return sign;
    }

    /**
     * get Player Details
     * @return String
     */
    @Override
    public String toString() {
        return "Player{" +
                "playerName= '" + playerName + '\'' +
                ", discs= " + discs.size() +
                ", sign= " + sign +
                '}';
    }

    /**
     * Get Player Name
     * @return playerName
     */
    public String getPlayerName() {
        return playerName;
    }
}
