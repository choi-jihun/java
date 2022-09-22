class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int [][] memo = new int[m+1][n+1];
        for(int i = 0; i < m + 1; i++)
            for(int j = 0; j< n + 1; j++)
                memo[i][j]=-1;
        return LCS(text1,text2,m,n,memo);
    }
    int LCS(String s1, String s2, int m, int n, int[][] memo ){
        int result;
        int a,b;
        if(memo[m][n] != -1){
            result = memo[m][n];
            return memo[m][n]; 
        }
        if(m == 0 || n ==0){
            result = 0;
            memo[m][n] = result;
        }
        else if(s1.charAt(m-1) == s2.charAt(n-1)){
            result = 1 + LCS(s1,s2,m-1,n-1,memo); 
            memo[m][n] = result;
        }
        else{
            a = LCS(s1,s2,m-1,n,memo);
            b = LCS(s1,s2,m,n-1,memo);
            if(a>b) {
                result = a;
                memo[m][n] = result;
            }
            else{
                result = b;
                memo[m][n] = result;
            }
        }
        result = memo[m][n];
        return result;
    }
}