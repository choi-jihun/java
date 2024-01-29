import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null && !str.isEmpty()) {
            int N = Integer.parseInt(str);
            int num = 1;
            int len = 1;

            while (num % N != 0) {
                num = (num * 10 + 1) % N;
                len++;
            }
            System.out.println(len);
        }
    }
}
