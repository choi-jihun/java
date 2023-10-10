import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class baekjoon_5568 {
    static int n, k;
    static boolean[] visited;
    static int[] arr;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        makeNum(0, "0");
        System.out.println(set.size());
    }

    static void makeNum(int idx, String num) {
        if (idx == k) {
            set.add(num);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNum(idx + 1, num + arr[i]);
                visited[i] = false;
            }
        }
    }
}
