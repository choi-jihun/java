import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_15969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            max = Math.max(temp, max);
            min = Math.min(temp, min);
        }

        System.out.println(max - min);
    }
}
