import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_18492 {
    static int N, K;
    static int[] arr;
    static boolean[] used;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        used = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 500);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void backtrack(int day, int currentWeight) {
        if (day == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                int newWeight = currentWeight + arr[i] - K;
                if (newWeight >= 500) {
                    used[i] = true;
                    backtrack(day + 1, newWeight);
                    used[i] = false;
                }
            }
        }
    }
}
