import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int []time = {300,60,10};
        int []ans = new int [3];

        for(int i = 0; i < 3; i++){
            if(time[i] <= T){
                ans[i]  = T / time[i];
                T %= time[i];
            }
        }
        if(T != 0)
            System.out.println(-1);
        else
            for(int i = 0; i < 3; i++)
                System.out.print(ans[i] + " ");
    }
}
