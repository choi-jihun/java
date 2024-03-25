import java.io.*;
import java.util.Arrays;

public class baekjoon_2992_1 {

    static char[] arr;
    static char[] ans;
    static boolean[] visited;
    static String original;
    static String minimum = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        original = br.readLine();
        arr = original.toCharArray();
        visited = new boolean[arr.length];
        ans = new char[arr.length];

        Arrays.sort(arr);
        back(0);

        if (minimum == null) {
            bw.write("0");
        } else {
            bw.write(minimum);
        }
        bw.flush();
    }

    static boolean back(int depth) {
        if (depth == arr.length) {
            String current = new String(ans);
            if (current.compareTo(original) > 0) {
                if (minimum == null || current.compareTo(minimum) < 0) {
                    minimum = current;
                    return true;
                }
            }
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[depth] = arr[i];
                if (back(depth + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

}
