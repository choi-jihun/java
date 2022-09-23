class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] memo = new int[numRows+1][numRows+2];
        for(int i = 0; i < numRows + 1; i++)
            for(int j =0; j<=i;j++)
                memo[i][j] = -1;
        for(int i=0; i<numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
        	    temp.add(Combi(i,j,memo));
            }
            list.add(temp);
        }
        return list;
    }
    int Combi(int n, int m,int[][] memo) {
        int result;
        if(memo[n][m] != -1){
            result = memo[n][m];
            return memo[n][m];
        }
        if (m == 0 || m == n) {
            result = 1;
            memo[n][m] = result;
        } else {
            result = Combi(n - 1, m - 1,memo) + Combi(n - 1, m,memo);
            memo[n][m] = result;
        }
        result = memo[n][m];
        return result;
    }
}