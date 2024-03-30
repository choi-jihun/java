import java.io.*;
import java.util.*;

public class baekjoon_2251 {

    static boolean[][][] visited;
    static int A, B, C;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[A + 1][B + 1][C + 1];
        bfs();

        List<Integer> sortedAmounts = new ArrayList<>(set);
        Collections.sort(sortedAmounts);
        for (int amount : sortedAmounts) {
            bw.write(amount + " ");
        }
        bw.flush();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, C});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curA = current[0], curB = current[1], curC = current[2];

            if (visited[curA][curB][curC])
                continue;
            visited[curA][curB][curC] = true;

            if (curA == 0) set.add(curC);

            if (curA + curB > B)
                queue.add(new int[]{curA + curB - B, B, curC});
            else
                queue.add(new int[]{0, curA + curB, curC});

            if (curA + curC > C)
                queue.add(new int[]{curA + curC - C, curB, C});
            else
                queue.add(new int[]{0, curB, curA + curC});

            if (curB + curA > A)
                queue.add(new int[]{A, curB + curA - A, curC});
            else
                queue.add(new int[]{curB + curA, 0, curC});

            if (curB + curC > C)
                queue.add(new int[]{curA, curB + curC - C, C});
            else
                queue.add(new int[]{curA, 0, curB + curC});

            if (curC + curA > A)
                queue.add(new int[]{A, curB, curC + curA - A});
            else
                queue.add(new int[]{curC + curA, curB, 0});

            if (curC + curB > B)
                queue.add(new int[]{curA, B, curC + curB - B});
            else
                queue.add(new int[]{curA, curC + curB, 0});
        }
    }
}
