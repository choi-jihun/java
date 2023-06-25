import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int rank = 1;

        int[][] arr = new int[N + 1][4];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            arr[idx][1] = Integer.parseInt(st.nextToken());
            arr[idx][2] = Integer.parseInt(st.nextToken());
            arr[idx][3] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            if (arr[i][1] > arr[K][1])
                rank++;
            else if (arr[i][1] == arr[K][1] && arr[i][2] > arr[K][2])
                rank++;
            else if (arr[i][1] == arr[K][1] && arr[i][2] == arr[K][2] && arr[i][3] > arr[K][3])
                rank++;
        }

        System.out.println(rank);
    }
}
