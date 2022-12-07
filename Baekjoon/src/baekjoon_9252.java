import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String strA = br.readLine();
        String strB = br.readLine();
        int [][]dp = new int [strA.length()+1][strB.length()+1];
        for(int i = 1; i < strA.length()+1; i++){
            for(int j = 1; j < strB.length()+1; j++){
                if(strA.charAt(i-1) == strB.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        if(dp[strA.length()][strB.length()] == 0){
            System.out.println(0);
            return;
        }
        else{
            int i = strA.length(), j = strB.length();
            while(i != 0 && j != 0){
                if(dp[i][j] == dp[i-1][j])
                    i--;
                else if (dp[i][j] == dp[i][j-1])
                    j--;

                else{
                    sb.append(strA.charAt(i-1));
                    i--;
                    j--;
                }
            }
            System.out.println(dp[strA.length()][strB.length()]+"\n"+sb.reverse());
        }

    }
}
