//Assignment Task 04: Rotate Secret
class AssgnTask4{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    //If needed you can create extra helper static methods
    //if extra helper methods are used then you must submit those as well
    
    public static void rotateSecret( Character[][] board ){

        int rows = board.length, cols = board[0].length;
        int layers = rows / 2;

        for(int layer = layers - 1; layer >= 0; layer--) {
            int first = layer;
            int last = rows - 1 - layer;
            int rotations = layers - layer;
            int arrsize = (last - first) * 4;

            char[] loop = new char[arrsize];
            int pos = 0;

            for(int j = first; j <= last; j++) {
                loop[pos++] = board[first][j];
            }

            for(int i = first + 1; i <= last - 1; i++) {
                loop[pos++] = board[i][last];
            }

            for(int j = last; j >= first; j--) {
                loop[pos++] = board[last][j];
            }

            for (int i = last - 1; i >= first + 1; i--) {
                loop[pos++] = board[i][first];
            }

            for(int r = 0; r < rotations; r++) {
                char temp = loop[arrsize - 1];

                for(int i = arrsize - 1; i > 0; i--) {
                    loop[i] = loop[i - 1];
                }
                loop[0] = temp;
            }

            pos = 0;

            for(int j = first; j <= last; j++) {
                board[first][j] = loop[pos++];
            }

            for(int i = first + 1; i <= last - 1; i++) {
                board[i][last] = loop[pos++];
            }

            for (int j = last; j >= first; j--) {
                board[last][j] = loop[pos++];
            }

            for (int i = last - 1; i >= first + 1; i--) {
                board[i][first] = loop[pos++];
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
