class Solution {
    static boolean [][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        visited = new boolean [grid.length][grid[0].length];
        int ans = Integer.MIN_VALUE;
        for(int  i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j]){
                    int size = DFS(i,j,grid);
                    ans = Math.max(size,ans);
                }
            }
        }
        return ans;
    }
    static int DFS(int x, int y, int [][]grid){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y] == 0||visited[x][y]==true)
            return 0;
        visited[x][y] = true;
        int size = 1;
        size += DFS(x+1,y,grid);
        size += DFS(x,y+1,grid);
        size += DFS(x-1,y,grid);
        size += DFS(x,y-1,grid);
        return size;
    }
}