import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_13023 {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            if (dfs(i, 0)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static boolean dfs(int start, int depth) {
        if (depth == 4) {
            return true;
        }

        visited[start] = true;

        for (int i = 0; i < list.get(start).size(); i++) {
            int temp = list.get(start).get(i);
            if (!visited[temp]) {
                visited[temp] = true;
                if (dfs(temp, depth + 1)) {
                    return true;
                }
                visited[temp] = false;
            }
        }

        return false;
    }

}

