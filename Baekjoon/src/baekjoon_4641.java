import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_4641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            int[] arr = new int[15];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == 0)
                    break;
                if (arr[i] == -1)
                    System.exit(0);
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++)
                    if (arr[i] == arr[j] * 2 && arr[i] != 0)
                        cnt++;
            }
            System.out.println(cnt);
        }
    }
}
