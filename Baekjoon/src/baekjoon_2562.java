import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp > max) {
                max = temp;
                cnt = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(cnt);
    }
}
