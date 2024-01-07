import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2529 {
    static String min = "";
    static String max = "";
    static boolean[] visited = new boolean[10];
    static char[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        operators = new char[k];

        for (int i = 0; i < k; i++) {
            operators[i] = st.nextToken().charAt(0);
        }
        dfs("", 0);
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    static void dfs(String str, int idx) {
        if (idx == operators.length + 1) {
            if (min.isEmpty() || str.compareTo(min) < 0) {
                min = str;
            }
            if (str.compareTo(max) > 0) {
                max = str;
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (idx == 0 || checkOperator(str.charAt(str.length() - 1), (char) (i + '0'), operators[idx - 1])) {
                    visited[i] = true;
                    dfs(str + i, idx + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean checkOperator(char a, char b, char op) {
        if (op == '<') {
            return a < b;
        } else {
            return a > b;
        }
    }
}
