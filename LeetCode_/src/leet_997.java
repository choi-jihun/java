class Solution {
    public int findJudge(int n, int[][] trust) {
        int ans = -1;
        if(n <= 1)
            return 1;
        int []arr = new int [n+1];
        for(int i = 0; i < trust.length; i++){
            arr[trust[i][1]]++;
            if(arr[trust[i][1]] == n -1){
                ans=trust[i][1];
                break;
            }
        }
        for(int i=0; i< trust.length;i++){
            if(trust[i][0] == ans){
                ans = -1;
                break;
            }
        }
        return ans;
    }
}