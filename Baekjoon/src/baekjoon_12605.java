import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            sb.append("Case #").append(i + 1).append(": ");

            for (int j = arr.length - 1; j >= 0; j--)
                sb.append(arr[j]).append(" ");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
