import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] sum = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 0)
                sum[i] = arr[i];
            else
                sum[i] = sum[i - 1] + arr[i];
        }
        int maxVisit = sum[X - 1];
        int cnt = 1;

        for (int i = X; i < N; i++) {
            int current = sum[i] - sum[i - X];
            if (current > maxVisit) {
                maxVisit = current;
                cnt = 1;
            } else if (current == maxVisit) {
                cnt++;
            }
        }
        if (maxVisit == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisit);
            System.out.println(cnt);
        }
    }
}
