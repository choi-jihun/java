class Solution {
    public int numTilePossibilities(String tiles) {
        if(tiles.length() <= 1)
            return tiles.length();
        HashSet<String> set = new HashSet<>();
        boolean []visited = new boolean [tiles.length()];
        dfs(set,tiles,"",visited);
        return set.size();
    }
    public void dfs(HashSet<String> set, String tiles, String temp, boolean [] visited){
        if(temp.length() != 0)
            set.add(temp);
        for(int i =0; i < tiles.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(set,tiles, temp+tiles.charAt(i),visited);
                visited[i] = false;
            }
        }
    }

}