class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int [values.length];
        dp[0] = values[0];
        for(int i = 1; i< values.length;i++){
            max = Math.max(max,dp[i-1]+values[i]-i);
            dp[i] = Math.max(dp[i-1],values[i] + i);
        }
        return max; //참고한 코드
        /*int max = Integer.MIN_VALUE;
        for(int i = 0; i < values.length;i++){
            for(int j=i+1;j<values.length;j++){
                int second = values[i] + values[j] + i - j;
                max = Math.max(max,second);
            }
        }
        return max; 오류가 발생한 코드*/
    }
    
}