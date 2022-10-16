class Solution {
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean [n];
        for(int i =0; i<n;i++){
            if(!visited[i]){
                dfs(computers,i);
                answer++;
            }
        }
        return answer;
    }
    static void dfs(int [][]computers, int start){
        visited[start] = true;
        for(int j = 0; j < computers.length; j++){
            if(!visited[j] && computers[start][j] == 1)
                dfs(computers,j);
        }
    }
}