package OthelloGame;

/**
 * This is grid class in our game
 * @author Ahmad Foroughi
 * @version 1.0
 */
public class Grid
{
    //Grid array field
    private char[][] grid;
    //Size of each Graphic Grid array
    protected final int SIZE = 8;
    /**
     * Create a new Grid and Put everything Empty = '4'
     */
    public Grid()
    {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                grid[i][j] = '4';
            }
        }
    }

    /**
     * Get Size of Grid
     * @return SIZE
     */
    public int getSIZE() {
        return SIZE;
    }

    /**
     * Get grid array
     * @return grid
     */
    public char[][] getGrid() {
        return grid;
    }

    /**
     * Set grid
     * @param grid set grid
     */
    public void setGrid(char[][] grid) {
        this.grid = grid;
    }
}
