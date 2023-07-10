import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_15666 {
    static int N, M;
    static int[] arr, temp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        temp = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        back(0, 0);
        System.out.println(sb);
    }

    static void back(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(temp[i]).append(" ");
            sb.append("\n");
            return;
        }

        int bef = -1;
        for (int i = start; i < N; i++) {
            int cur = arr[i];
            if (cur != bef) {
                bef = cur;
                temp[depth] = arr[i];
                back(i, depth + 1);
            }
        }
    }
}
