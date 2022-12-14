import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int []arr = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int []cost = new int [N-1];
        for(int i = 0; i < N-1; i++)
            cost[i] = arr[i+1] - arr[i];
        Arrays.sort(cost);
        int sum = 0;
        for(int i = 0; i < N-K; i++)
            sum+=cost[i];
        System.out.println(sum);
    }
}
