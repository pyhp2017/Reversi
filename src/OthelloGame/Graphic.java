package OthelloGame;

/**
 * Graphic Class is for Graphic design
 * @author Ahmad Foroughi
 * @version 1.0
 */
public class Graphic extends Grid
{
    //alphabet array field
    private final String[] alpha = {"A","B","C","D","E","F","G","H"};
    // colors unicode
    public static final String ANSI_RESET  = "\u001B[0m";
    public static final String ANSI_BRIGHT_BLACK  = "\u001B[90m";
    public static final String ANSI_BG_RED    = "\u001B[41m";
    public static final String ANSI_BG_GREEN  = "\u001B[42m";
    public static final String ANSI_BG_BLUE   = "\u001B[44m";
    public static final String ANSI_BG_WHITE  = "\u001B[47m";
    //final background and hint color
    public String backgroundFinal;
    public String hintColorFinal;

    /**
     * Create a new Graphic with given Details
     * @param option is given option
     */
    public Graphic(int option)
    {
        if (option == 1)
        {
            backgroundFinal = ANSI_BG_BLUE;
            hintColorFinal = ANSI_BG_RED;
        }
        else if (option == 2)
        {
            backgroundFinal = ANSI_BG_GREEN;
            hintColorFinal = ANSI_BG_BLUE;
        }
        else if (option == 3)
        {
            backgroundFinal = ANSI_BG_RED;
            hintColorFinal = ANSI_BG_WHITE;
        }
    }

    /**
     *     Draw a Grid with BackGround and Graphic
     */
    public void drawGrid(Grid grid)
    {
        System.out.printf("*");
        System.out.print("       ");
        for (int z = 0; z < alpha.length; z++)
        {
            System.out.printf("%s    ", alpha[z]);
        }
        System.out.printf("\n");

        for (int j = 0; j <SIZE ; j++)
        {
            System.out.printf("   ");
            System.out.printf("%d  ", j+1);
            for (int i = 0; i < SIZE; i++)
            {
                System.out.print(backgroundFinal+ANSI_BRIGHT_BLACK);
                if (grid.getGrid()[i][j] == '4')
                {
                    System.out.print(backgroundFinal+ANSI_BRIGHT_BLACK);
                    System.out.printf("|   |");
                }
                else if (grid.getGrid()[i][j] == '1')
                {
                    System.out.print(hintColorFinal+ANSI_BRIGHT_BLACK);
                    System.out.printf("|   |");
                }
                else
                {
                    System.out.print(backgroundFinal+ANSI_BRIGHT_BLACK);
                    System.out.printf("| %c |" , grid.getGrid()[i][j]);
                }
            }
            System.out.print(ANSI_RESET+ANSI_BRIGHT_BLACK);
            System.out.print("\n");
        }
    }

    /**
     * Print menu to the terminal
     */
    public static void menu()
    {
        System.out.println("\n\t\t\tWelcome to Othello Game");
        System.out.println("\t\t1) Start a New Multi player Game");
        System.out.println("\t\t2) Settings");
        System.out.println("\t\t3) Exit");
    }

    /**
     * Print settings menu to the terminal
     */
    public static void settings()
    {
        System.out.println("\n\n\t\t\tChange Board background color : ");
        System.out.println("\t\t 1) Set Color to Blue with red Hint");
        System.out.println("\t\t 2) Set Color to Green with blue Hint");
        System.out.println("\t\t 3) Set Color to red with white Hint");
    }

}
