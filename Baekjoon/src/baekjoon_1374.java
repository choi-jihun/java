import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1374 {
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(minClassroom());
    }

    static int minClassroom() {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(arr[0][2]);

        for (int i = 1; i < N; i++) {
            if (arr[i][1] >= queue.peek()) {
                queue.poll();
            }

            queue.add(arr[i][2]);
        }

        return queue.size();
    }

}
