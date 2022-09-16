class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int result[][] = new int[len1 + 1][len2 + 1];
        
        for(int i = 0; i < len1; i++) {
        	for(int j = 0; j < len2; j++) {
        		if(text1.charAt(i) == text2.charAt(j))
        			result[i+1][j+1] = result[i][j]+1;
        		else
        			result[i+1][j+1] = Math.max(result[i+1][j], result[i][j+1]);
        	}
        }
        return result[len1+1][len2+1];
        
    }
}