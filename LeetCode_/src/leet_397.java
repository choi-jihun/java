class Solution {
    public int integerReplacement(int n) {
        int []memo = new int[n + 2];
        for(int i = 0; i < n + 2; i++)
            memo[i] = -1;
        return find_best(n,memo);
    }
    int find_best(int n, int []memo){
        int result;
        if(memo[n]!=-1){
            result = memo[n];
            return memo[n];
        }
        if(n <= 1){
            result =  0;
            memo[n] = result;
        }
        else{
            if(n % 2 == 0){
                result = 1 + find_best(n/2,memo);
                memo[n] = result;
            }
            else{
                result = 1 + Math.min(find_best(n-1,memo),find_best(n+1,memo));
                memo[n] = result;
            }
        }
        result = memo[n];
        return result;
    }
    
}