import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int count = 0;
        int n = 0;
        int top = 0;
        int bot = 0;
        if (X == 1) {
            System.out.println("1/1");
            return;
        }
        while (count < X) {
            n++;
            count = n * (n + 1) / 2; //행 계산
        }
        int num = X - (n - 1) * n / 2; //열 계산
        if (n % 2 == 0) {
            top = num;
            bot = n - num + 1;
        } else {
            top = n - num + 1;
            bot = num;
        }
        System.out.println(top + "/" + bot);
    }
}
