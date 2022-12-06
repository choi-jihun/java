import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int []dp0 = new int [41];
        int []dp1 = new int [41];
        dp0[0] = 1;
        dp0[1] = 0;
        dp1[0] = 0;
        dp1[1] = 1;
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            for(int j = 2; j <= N; j++){
                dp0[j] = dp0[j-1] + dp0[j-2];
                dp1[j] = dp1[j-1] + dp1[j-2];
            }
            sb.append(dp0[N]+" ").append(dp1[N]).append("\n");
        }
        System.out.println(sb);
    }
}
