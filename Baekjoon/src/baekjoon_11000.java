import java.io.*;
import java.util.*;

public class baekjoon_11000 {

    static class Node implements Comparable<Node> {
        int st;
        int et;

        public Node(int st, int et) {
            this.st = st;
            this.et = et;
        }

        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return this.st - o.st;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Node> classes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            classes.add(new Node(start, end));
        }

        Collections.sort(classes);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Node currentClass : classes) {
            if (!pq.isEmpty() && (pq.peek() <= currentClass.st)) {
                pq.poll();
            }
            pq.offer(currentClass.et);
        }

        bw.write(String.valueOf(pq.size()));
        bw.close();
        br.close();
    }

}
