import java.io.*;
import java.util.*;

public class baekjoon_23757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            maxHeap.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int[] wishes = new int[M];
        for (int i = 0; i < M; i++) {
            wishes[i] = Integer.parseInt(st.nextToken());
        }

        boolean canSatisfyAll = true;
        for (int i = 0; i < M; i++) {
            if (maxHeap.isEmpty()) {
                canSatisfyAll = false;
                break;
            }

            int largestBox = maxHeap.poll();
            if (largestBox < wishes[i]) {
                canSatisfyAll = false;
                break;
            }

            if (largestBox - wishes[i] > 0) {
                maxHeap.offer(largestBox - wishes[i]);
            }
        }

        bw.write(canSatisfyAll ? "1\n" : "0\n");
        bw.flush();
        bw.close();
    }
}
