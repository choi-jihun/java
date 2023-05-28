import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int temp = 10;
        while (N > temp) {
            int mod = N % temp;
            if (mod * 10 / temp >= 5)
                N += temp;
            N -= mod;
            temp *= 10;
        }

        System.out.println(N);
    }
}
