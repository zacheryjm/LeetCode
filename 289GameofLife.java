class Solution {
    public void gameOfLife(int[][] board) {
        int[][] newBoard = new int [board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int numNeighbors = findNeighbors(board, i, j);
                newBoard[i][j] = nextState(numNeighbors, board[i][j]);
            } 
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = newBoard[i][j];
            } 
        }
    }
    
    public int findNeighbors(int[][] board, int row, int col) {
        
        int numNeighbors = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if((i+row != row || j+col != col)) {
                    if(row + i >= 0 && row + i < board.length 
                       && col + j >=0 && col + j < board[0].length) {
                        numNeighbors += board[row+i][col+j];
                    }
                }
            } 
        }  
        return numNeighbors;
    }
    
    public int nextState (int numNeighbors, int currentState) {
        
        if(currentState == 0 && numNeighbors == 3) return 1;
        if(currentState == 1 && (numNeighbors == 2 || numNeighbors == 3)) return 1;
        
        return 0;
        
        
    }
}