import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] str = new String[N];
            int[] arr = new int[N];
            int max = -1;
            int idx = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                str[i] = st.nextToken();
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] > max) {
                    max = arr[i];
                    idx = i;
                }
            }
            sb.append(str[idx]).append("\n");
        }

        System.out.println(sb);
    }
}
