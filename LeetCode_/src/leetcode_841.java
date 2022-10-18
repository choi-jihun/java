class Solution {
    static boolean []visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        if(len == 0 || rooms == null)
            return false;
        visited = new boolean[len];
        dfs(rooms,0);
        for(int i = 0; i < len; i++)
            if(!visited[i])
                return false;
        return true;
    }
    static void dfs(List<List<Integer>> rooms,int start){
        if(start>=rooms.size() || visited[start])
            return;
        visited[start] = true;
        for(int i = 0; i<rooms.get(start).size();i++){
            int next = rooms.get(start).get(i);
            dfs(rooms,next);
        }
            
    }
}
