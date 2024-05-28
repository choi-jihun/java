import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_17471 {
    //선거구 1개부터 N개까지 인구수 체크
    //visit 하지않은 곳이 있으면 연결 되어있는지 체크 후 인구 수 비교
    //아직 못 풂

    static List<List<Integer>> graph;
    static int[] arr;
    static boolean[] checked;
    static boolean[] visited;
    static int N;
    static int diff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        checked = new boolean[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int k = Integer.parseInt(st.nextToken());
                graph.get(i).add(k);
            }
        }

        divide(1);
        bw.write(diff == Integer.MAX_VALUE ? "-1" : String.valueOf(diff));
        bw.flush();
    }

    static void divide(int idx) {
        if (idx == N + 1) {
            if (checkGraph()) {
                int minDiff = calculateDifference();
                diff = Math.min(minDiff, diff);
            }
            return;
        }

        checked[idx] = true;
        divide(idx + 1);
        checked[idx] = false;
        divide(idx + 1);
    }

    static boolean checkGraph() {
        visited = new boolean[N + 1];
        int cnt = 0;

        for (int i = 1; i < N + 1; i++) {
            if (checked[i] && !visited[i]) {
                dfs(i, true);
                cnt++;
            }
        }
        if (cnt != 1)
            return false;

        cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!checked[i] && !visited[i]) {
                dfs(i, false);
                cnt++;
            }
        }
        return cnt == 1;
    }

    static void dfs(int idx, boolean flag) {
        visited[idx] = true;
        for (int next : graph.get(idx)) {
            if (checked[next] == flag && !visited[next]) {
                dfs(next, flag);
            }
        }
    }

    static int calculateDifference() {
        int groupOne = 0, groupTwo = 0;
        for (int i = 1; i <= N; i++) {
            if (checked[i])
                groupOne += arr[i];
            else
                groupTwo += arr[i];
        }
        return Math.abs(groupOne - groupTwo);
    }
}
