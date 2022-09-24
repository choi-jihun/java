class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i =0; i< n+1; i++)
            arr[i] = -1;
        for(int i = 0; i< n+1; i++)
            arr[i] = res(i,arr);
        return arr;
    }
    int res(int n, int[] memo){
        int result;
        if(memo[n] != -1){
            result = memo[n];
            return memo[n];
        }
        if(n==1){
            result = 1;
            memo[n] = result;
        }
        else if(n==0){
            result = 0;
            memo[n] = 0;
        }
        else{
            if(n%2 == 0){
                result = res(n/2,memo);
                memo[n] = result;
            }
            else{
                result = 1+res(n/2,memo);
                memo[n] = result;
            }
        }
        result = memo[n];
        return result;
    }
}