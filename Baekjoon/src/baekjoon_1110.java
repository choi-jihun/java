import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int temp = N;
        int cnt = 0;

        while (true) {
            int ten = temp / 10;
            int one = temp % 10;
            temp = one * 10 + (one + ten) % 10;
            cnt++;
            if (N == temp)
                break;
        }
        System.out.println(cnt);
    }
}
