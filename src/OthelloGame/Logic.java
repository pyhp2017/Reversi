package OthelloGame;

/**
 * This class contains all methods about game algorithm
 * @author Ahmad Foroughi
 * @version 1.0
 */
public class Logic
{
    /**
     * @param playerSign is player Sign
     * @param walkR is distance to move from current position
     * @param walkC is distance to move from current position
     * @param r is current position x (row)
     * @param c is current position y (column)
     * @param grid is a grid
     * @return true or false
     */
    public static boolean check_in_line(char playerSign , int walkR, int walkC , int r , int c , Grid grid)
    {
        if (grid.getGrid()[r][c] == playerSign)
        {
            return true;
        }
        if (grid.getGrid()[r][c] == '4')
        {
            return false;
        }
        if ( (r+walkR < 0) || (r+walkR > grid.getSIZE() -1) ) //Out of range
        {
            return false;
        }
        if ((c+walkC < 0) || (c+walkC > grid.getSIZE()-1))
        {
            return false;
        }
        return check_in_line(playerSign,walkR,walkC,r+walkR,c+walkC , grid);//Recursion
    }

    /**
     * Check Valid Move
     * @param playerSign is player Sign
     * @param walkR is distance to move from current position
     * @param walkC is distance to move from current position
     * @param r is current position x (row)
     * @param c is current position y (column)
     * @param grid is a grid
     * @return true or false
     */
    public static boolean validMove(char playerSign , int walkR, int walkC , int r , int c , Grid grid)
    {
        char opposite = ' ';
        if (playerSign == '●')
        {
            opposite = '○';
        }
        else if (playerSign == '○')
        {
            opposite = '●';
        }

        if ((r+walkR < 0) || (r+walkR) > 7)
        {
            return false;
        }
        if ((c+walkC < 0) || (c+walkC) > 7)
        {
            return false;
        }
        if (grid.getGrid()[r+walkR][c+walkC] != opposite)
        {
            return false;
        }
        if (r+(2*walkR) <0 || r+(2*walkR) > 7)
        {
            return false;
        }
        if (c+(2*walkC) < 0 || c+(2*walkC) > 7)
        {
            return false;
        }
        return check_in_line(playerSign, walkR, walkC, r+(2*walkR), c+(2*walkC), grid);
    }


    /**
     * Calculate all valid moves
     * @param playerSign is player Sign
     * @param board is a grid
     * @return number of valid moves
     */
    public static int cal_valid(char playerSign, Grid board)
    {
        int actives = 0;
        for (int i=0 ; i<8 ; i++)
        {
            for (int j=0 ; j<8 ; j++)
            {
                if (board.getGrid()[i][j] == '4') // if it was empty
                {
                    boolean northWest = validMove(playerSign,-1,-1,i,j,board);
                    boolean north = validMove(playerSign,0,-1,i,j,board);
                    boolean northEast = validMove(playerSign,+1,-1,i,j,board);
                    boolean west = validMove(playerSign,-1,0,i,j,board);
                    boolean east = validMove(playerSign,+1,0,i,j,board);
                    boolean southWest = validMove(playerSign,-1,1,i,j,board);
                    boolean south = validMove(playerSign,0,1,i,j,board);
                    boolean southEast = validMove(playerSign,1,1,i,j,board);

                    if (north || northEast || northWest || west || east || south || southEast || southWest)
                    {
                        board.getGrid()[i][j] = '1';//Movable
                        board.setGrid(board.getGrid());
                        actives++;
                    }

                }
            }
        }
        return actives;
    }

    /**
     * Clear Hints from the bord
     * @param grid is a grid
     */
    public static void putNormal(Grid grid)
    {
        for (int i =0 ; i< 8 ;i++)
        {
            for (int j=0 ; j< 8 ; j++)
            {
                if (grid.getGrid()[i][j] == '1')
                {
                    grid.getGrid()[i][j] = '4';
                }
            }
        }
    }

    /**
     * add a disc and flip the disc on the bord
     * @param play1 is player1
     * @param play2 is player2
     * @param board is a bord
     * @param row is current position
     * @param column is current position
     */
    public static void flipDisc(Player play1 , Player play2, Grid board , int row , int column)
    {
        play1.addDisc(row,column,board);
        flipLine(play1,play2,-1,-1,row,column,board);
        flipLine(play1,play2,0,-1,row,column,board);
        flipLine(play1,play2,+1,-1,row,column,board);
        flipLine(play1,play2,-1,0,row,column,board);
        flipLine(play1,play2,+1,0,row,column,board);
        flipLine(play1,play2,-1,1,row,column,board);
        flipLine(play1,play2,0,1,row,column,board);
        flipLine(play1,play2,1,1,row,column,board);

    }

    /**
     * @param play1 is player1  (Current Move)
     * @param play2 is player2
     * @param walkR is distance to move from current position
     * @param walkC is distance to move from current position
     * @param r is current position x (row)
     * @param c is current position y (column)
     * @param grid is a grid
     * @return true or false
     */
    public static boolean flipLine(Player play1 , Player play2 , int walkR, int walkC , int r , int c , Grid grid)
    {
        if ((r+walkR) < 0 || (r+walkR) > grid.getSIZE()-1)
        {
            return false;
        }
        if ((c+walkC) < 0 || (c+walkC) > grid.getSIZE()-1)
        {
            return false;
        }
        if (grid.getGrid()[r+walkR][c+walkC] != play1.getSign() && grid.getGrid()[r+walkR][c+walkC] != play2.getSign())
        {
            return false;
        }
        if (grid.getGrid()[r+walkR][c+walkC] == play1.getSign() )
        {
            return true;
        }
        else
        {
            if (flipLine(play1 , play2, walkR, walkC, r+walkR, c+walkC, grid))
            {
                play2.removeDisc(r+walkR,c+walkC);
                play1.addDisc(r+walkR,c+walkC,grid);
                return true;
            }
            else
            {
                return false;
            }

        }
    }


}
