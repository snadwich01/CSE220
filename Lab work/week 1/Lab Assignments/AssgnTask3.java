//Assignment Task 03: Game Arena
class AssgnTask3{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static void playGame( Integer[][] arena ){

        //For this task you don't need to create any new 2D array
        //just print the result inside the function
        
        //TO DO
        int rows = arena.length, cols = arena[0].length;

        int count = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(arena[row][col] % 50 == 0 && arena[row][col] != 0){
                    if(row > 0 && arena[row-1][col] == 2) {
                        count++;
                    }
                    if(row < rows - 1 && arena[row+1][col] == 2) {
                        count++;
                    }
                    if(col > 0 && arena[row][col - 1] == 2) {
                        count++;
                    }
                    if(col < cols - 1 && arena[row][col + 1] == 2) {
                        count++;
                    }
                }
            }
        }

        int points = count * 2;

        if(points >= 10) {
            System.out.printf("Points Gained: %d. Your team has survived the game.\n", points);
        } else {
            System.out.printf("Points Gained: %d. Your team is out.\n", points);
        }
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] arena = {
            {0,2,2,0},
            {50,1,2,0},
            {2,2,2,0},
            {1,100,2,0}
        };
        System.out.println("Given Arena: ");
        Arr.print2D(arena);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 6. Your team is out.\n");
        
        System.out.print("\nYour Output:\n");
        playGame( arena );

        System.out.print("\n======================\n");

        Integer[][] arena1 = {
            {0,2,2,0,2},
            {1,50,2,1,100},
            {2,2,2,0,2},
            {0,200,2,0,0}
        };
        System.out.println("\nGiven Arena: ");
        Arr.print2D(arena1);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 14. Your team has survived the game.\n");
        
        System.out.print("\nYour Output:\n");
        playGame( arena1 );
    }
}
