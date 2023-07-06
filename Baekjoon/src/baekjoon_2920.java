import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        int[] arr = new int[8];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 7; i++) {
            if (arr[i] == arr[i + 1] - 1)
                str = "ascending";
            else if (arr[i] == arr[i + 1] + 1) {
                str = "descending";
            } else {
                str = "mixed";
                break;
            }
        }
        System.out.println(str);
    }
}
