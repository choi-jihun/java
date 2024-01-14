import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int weight = 0;
        int time = 0;
        int idx = 0;
        while (idx < n) {
            if (queue.size() == w) {
                weight -= queue.poll();
            }
            if (weight + arr[idx] <= L) {
                queue.offer(arr[idx]);
                weight += arr[idx];
                idx++;
            } else {
                queue.offer(0);
            }
            time++;
        }

        System.out.println(time + w);
    }
}
