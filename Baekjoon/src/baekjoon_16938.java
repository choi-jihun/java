import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_16938{

    static int N, L, R, X;
    static int[] arr;
    static int cnt = 0;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        back(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    static void back(int idx, int sum, int min, int max, int count) {
        if (idx == N) {
            if (sum >= L && sum <= R && (max - min) >= X && count >= 2) {
                cnt++;
            }
            return;
        }

        back(idx + 1, sum + arr[idx], Math.min(min, arr[idx]), Math.max(max, arr[idx]), count + 1);
        back(idx + 1, sum, min, max, count);
    }

}