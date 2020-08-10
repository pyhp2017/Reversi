package OthelloGame;

import java.util.Objects;

/**
 * This class represents us a Disc in our game
 * @author Ahmad
 * @version 1.0
 */
public class Disc extends  Grid
{
    //Position Field
    private int x;
    //Position Field
    private int y;

    /**
     * Create a new Disc
     */
    public Disc(int x , int y )
    {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Check if discs are same
     * @param o is an Object
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disc disc = (Disc) o;
        return x == disc.x &&
                y == disc.y;
    }

    /**
     * hash code of each Disc
     * @return hash code integer
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
