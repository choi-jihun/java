import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon_1446 {

    static class Road {
        int start, end, cost;

        public Road(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Road> list = new ArrayList<>();
        int[] dist = new int[D + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Road(s, e, c));
        }

        Collections.sort(list, (o1, o2) -> o1.start - o2.start);

        for (int i = 1; i <= D; i++) {
            dist[i] = dist[i - 1] + 1;
            for (Road road : list) {
                if (road.end == i) {
                    if (road.start == 0)
                        dist[i] = Math.min(dist[i], road.cost);
                    else if (dist[road.start] != 0)
                        dist[i] = Math.min(dist[i], dist[road.start] + road.cost);
                }
            }
        }

        bw.write(Integer.toString(dist[D]));
        bw.flush();
    }
}
