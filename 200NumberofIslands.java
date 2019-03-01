class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) {return 0;}
        
        int numIslands = 0;
        
        for(int xPos = 0; xPos < grid.length; ++xPos) {
            for(int yPos = 0; yPos < grid[xPos].length; ++yPos) {
                if(grid[xPos][yPos] == '2') {continue;}
                
                if(grid[xPos][yPos] == '1') {
                    numIslands++;
                    findWholeIsland(grid, xPos, yPos);
                }
                else {
                    grid[xPos][yPos] = '2';
                }
            }
        }
        
        return numIslands;
    }
    
    public void findWholeIsland(char [][] grid, int xPos, int yPos) {
        if(xPos < 0 || xPos >= grid.length || yPos < 0 || yPos >= grid[xPos].length) {
            return;
        }
        if(grid[xPos][yPos] == '1') {
            grid[xPos][yPos] = '2';
            findWholeIsland(grid, xPos+1, yPos);
            findWholeIsland(grid, xPos-1, yPos);
            findWholeIsland(grid, xPos, yPos+1);
            findWholeIsland(grid, xPos, yPos-1);
        }
        else {
            grid[xPos][yPos] = '2';
        }
    }
}