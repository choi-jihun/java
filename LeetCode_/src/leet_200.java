class Solution {
    static boolean[][] visited;
    public int numIslands(char[][] grid) {
        visited = new boolean [grid.length][grid[0].length];
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i,j,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void dfs(int x, int y, char[][] grid){
        if(x<0||y<0||x==grid.length||y==grid[0].length || grid[x][y] == '0' || visited[x][y])
            return;
        visited[x][y]=true;
        dfs(x+1,y,grid);
        dfs(x-1,y,grid);
        dfs(x,y+1,grid);
        dfs(x,y-1,grid);
    }
}
