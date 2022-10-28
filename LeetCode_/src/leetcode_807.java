class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int [][]gridNew = new int [grid.length][grid.length];
        int [][]colMax = new int [grid.length][grid.length];
        int [][]rowMax = new int [grid.length][grid.length];
        int sum = 0;
        for(int i = 0; i < grid.length; i++){
            int maxRow = Integer.MIN_VALUE;
            int maxCol = Integer.MIN_VALUE;
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] > maxRow)
                    maxRow = grid[i][j];
                if(grid[j][i] > maxCol)
                    maxCol = grid[j][i];
            }
            for(int k = 0; k < grid.length; k++){
                colMax[k][i] = maxCol;
                rowMax[i][k] = maxRow;
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                gridNew[i][j] = Math.min(colMax[i][j],rowMax[i][j]);
                sum += gridNew[i][j] - grid[i][j];
            }
        }
        return sum;
    }
}