//Assignment Task 04: Rotate Secret
class AssgnTask4{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    //If needed you can create extra helper static methods
    //if extra helper methods are used then you must submit those as well
    
    public static void rotateSecret( Character[][] board ){

        int rows = board.length, cols = board[0].length;
        int layers = rows / 2;

        for (int layer = 0; layer < layers; layer++) {
            int top = layer;
            int left = top;
            int btm = rows - 1 - layer;
            int right = btm;

            int rotations = layers - layer;

            while (rotations > 0) {
                char temp = board[top][left];

                for (int i = top; i < btm; i++) {
                    board[i][left] = board[i + 1][left];
                }

                for (int j = left; j < right; j++) {
                    board[btm][j] = board[btm][j + 1];
                }

                for (int i = btm; i > top; i--) {
                    board[i][right] = board[i - 1][right];
                }

                for (int j = right; j > left + 1; j--) {
                    board[top][j] = board[top][j - 1];
                }

                board[top][left + 1] = temp;
                rotations--;
            }
        }

        for(int i = 0   ; i < rows; i++) {
            for(int j = 0; j < rows; j++) {
                System.out.print(board[i][j]);
            }
        }
        System.out.println();
    }


    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        System.out.print("===========Test#1===========\n");
        Character[][] board = {
        {'T','A','U','S'},
        {'A','R','I','.'},
        {'D','T','T','N'},
        {'S','C','F','U'}
        };
        System.out.println("Given Board: ");
        Arr.print2D(board);

        System.out.println("\nExpected Output:");
        Character[][] outputBoard = {
            {'D','A','T','A'},
            {'S','T','R','U'},
            {'C','T','I','S'},
            {'F','U','N','.'}
        };
        System.out.print("DATASTRUCTISFUN.\n");
        Arr.print2D(outputBoard);
        
        System.out.print("\nYour Output:\n");
        rotateSecret( board );
        Arr.print2D(board);
        
        if( Arr.compare2D(outputBoard, board) ) System.out.print("Test 1 Success");
        else System.out.println("Test 1 FAILED");
        
        System.out.print("\n===========Test#2===========\n");

        board = new Character[][]{
          {'O','R','I','R','N','P'},
          {'G','S','A','A','L','R'},
          {'L','M','N','O','N','Y'},
          {'A','H','U','O','O','P'},
          {'T','F','C','T','H','S'},
          {'E','D','Y','O','C','K'}
        };
        System.out.println("Given Board: ");
        Arr.print2D(board);

        System.out.println("\nExpected Output:");
        outputBoard = new Character[][]{
            {'A','L','G','O','R','I'},
            {'T','H','M','S','A','R'},
            {'E','F','U','N','A','N'},
            {'D','C','O','O','L','P'},
            {'Y','T','H','O','N','R'},
            {'O','C','K','S','P','Y'}
        };
        System.out.print("ALGORITHMSAREFUNANDCOOLPYTHONROCKS\n");
        Arr.print2D(outputBoard);
        
        System.out.print("\nYour Output:\n");
        rotateSecret( board );
        Arr.print2D(board);
        
        if( Arr.compare2D(outputBoard, board) ) System.out.print("Test 2 Success");
        else System.out.println("Test 2 FAILED");
    }
}
