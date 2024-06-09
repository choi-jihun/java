import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class baekjoon_1342 {
    static boolean[] visited;
    static char[] arr;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        arr = S.toCharArray();
        Arrays.sort(arr);
        visited = new boolean[arr.length];

        permute(new char[arr.length], 0);

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void permute(char[] current, int depth) {
        if (depth == arr.length) {
            if (isLuckyString(current)) {
                result++;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                continue;

            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])
                continue;

            visited[i] = true;
            current[depth] = arr[i];
            permute(current, depth + 1);
            visited[i] = false;
        }
    }

    static boolean isLuckyString(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
