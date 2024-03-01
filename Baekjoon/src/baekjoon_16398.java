import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_16398 {

    static int N;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(calculate()));
        bw.flush();
    }

    static long calculate() {
        int[] minArr = new int[N];
        Arrays.fill(minArr, Integer.MAX_VALUE);

        minArr[0] = 0;
        long cost = 0;

        for (int i = 0; i < N; i++) {
            int temp = -1;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && (temp == -1 || minArr[j] < minArr[temp])) {
                    temp = j;
                }
            }

            visited[temp] = true;
            cost += minArr[temp];

            for (int j = 0; j < N; j++) {
                if (!visited[j] && arr[temp][j] < minArr[j]) {
                    minArr[j] = arr[temp][j];
                }
            }
        }
        return cost;
    }
}
