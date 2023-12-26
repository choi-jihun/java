import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_16968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'c') {
                result *= i == 0 || str.charAt(i - 1) != 'c' ? 26 : 25;
            } else if (ch == 'd') {
                result *= i == 0 || str.charAt(i - 1) != 'd' ? 10 : 9;
            }
        }

        System.out.println(result);
    }
}
