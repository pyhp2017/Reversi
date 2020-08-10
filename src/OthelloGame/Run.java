package OthelloGame;

import java.util.Scanner;

/**
 * Run.java is a class for Running the game
 * @author Ahmad Foroughi
 * @version 1.0
 */
public class Run
{
    public static int setColor;

    /**
     * Show Start Menu With options
     */
    public static void startMenu()
    {
        Scanner scanner = new Scanner(System.in);
        Graphic.menu();
        System.out.print("Select your Option: ");
        int option = scanner.nextInt();
        switch (option)
        {
            case 1:
                //Start a New Game
                if (setColor == 0)
                {
                    setColor = 1;
                }
                startGame();
                break;

            case 2:
                //Settings a Game
                Graphic.settings();
                System.out.print("Select your Option: ");
                int option2 = scanner.nextInt();
                switch (option2)
                {
                    case 1:
                        //Set Color to Blue with red Hint
                        setColor = 1;
                        break;
                    case 2:
                        //Set Color to Green with blue Hint
                        setColor = 2;
                        break;
                    case 3:
                        //Set Color to red with white Hint
                        setColor = 3;
                        break;
                }
                startMenu();
                break;

            case 3:
                //Exit
                System.exit(0);
                break;
        }
    }

    /**
     * Start The Game
     */
    public static void startGame()
    {
        Graphic graphic = new Graphic(setColor);
        Grid bord = new Grid();
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player("BLACK",'●');
        Player player2 = new Player("WHITE",'○');
        player1.addDisc(4,3,bord);
        player1.addDisc(3,4,bord);
        player2.addDisc(3,3,bord);
        player2.addDisc(4,4,bord);
        int move = 1;
        int countPass = 0;
        while(true)
        {
            System.out.println( "\t\t\t"+ player1.getSign() + " : " + player1.numberOfDiscs() + "\t\t\t " + player2.getSign() + " : " + player2.numberOfDiscs() );
            boolean isComplete = true;
            for (int i =0 ; i< bord.getSIZE() ; i++)
            {
                for (int j =0 ; j<8 ; j++)
                {
                    if (bord.getGrid()[i][j] == '4')
                    {
                        isComplete = false;
                    }
                }
            }

            if (!isComplete && countPass <=2)
            {
                if (move % 2 != 0)
                {
                    //Player 1 Turn
                    if (Logic.cal_valid(player1.getSign(),bord) != 0)
                    {
                        graphic.drawGrid(bord);
                        System.out.println("Player 1 - " + player1.getPlayerName() + " Turn");
                        int x , y;
                        while (true)
                        {
                            int  XY= turn();
                            x = XY/10;
                            y = XY%10;
                            if (bord.getGrid()[x][y] == '1')
                            {
                                break;
                            }
                        }
                        Logic.flipDisc(player1,player2,bord,x,y);
                        Logic.putNormal(bord);
                        move++;
                    }
                    else
                    {
                        System.out.println("PASS");
                        countPass++;
                    }
                }
                else
                {
                    //Player 2 Turn
                    if (Logic.cal_valid(player2.getSign(),bord)!=0)
                    {
                        graphic.drawGrid(bord);
                        System.out.println("Player 2 - " + player2.getPlayerName() + " Turn");
                        int x , y;
                        while (true)
                        {
                            int  XY= turn();
                            x = XY/10;
                            y = XY%10;
                            if (bord.getGrid()[x][y] == '1')
                            {
                                break;
                            }
                        }
                        Logic.flipDisc(player2,player1,bord,x,y);
                        Logic.putNormal(bord);
                        move++;
                    }
                    else
                    {
                        System.out.println("PASS");
                        countPass++;
                    }
                }

            }
            else
            {
                System.out.println("End Of the Game");
                Player winner = player1.numberOfDiscs() > player2.numberOfDiscs() ? player1 : player2;
                System.out.println("\n\n\n \t\t\t The Winner is \n" + winner.toString());
                System.exit(1);
            }

        }


    }

    /**
     * Give Player turn
     * @return GIVEN XY
     */
    public static int turn()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a coordinate: ");
        int iMove = Integer.parseInt(scanner.next());
        String cMove = scanner.next();
        int finalMoveX;
        int finalMoveY = iMove - 1;
        switch (cMove)
        {
            case "A":
                finalMoveX = 0;
                break;
            case "B":
                finalMoveX = 1;
                break;
            case "C":
                finalMoveX = 2;
                break;
            case "D":
                finalMoveX = 3;
                break;
            case "E":
                finalMoveX = 4;
                break;
            case "F":
                finalMoveX = 5;
                break;
            case "G":
                finalMoveX = 6;
                break;
            case "H":
                finalMoveX = 7;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + cMove);
        }

        return finalMoveX*10+finalMoveY;
    }

}