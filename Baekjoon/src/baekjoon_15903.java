import java.io.*;
import java.util.*;

public class baekjoon_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] cards = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Long.parseLong(st.nextToken());
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long card : cards) {
            pq.add(card);
        }

        for (int i = 0; i < m; i++) {
            long firstMin = pq.poll();
            long secondMin = pq.poll();

            long combinedValue = firstMin + secondMin;
            pq.add(combinedValue);
            pq.add(combinedValue);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        bw.write(Long.toString(sum));
        bw.flush();
    }
}
