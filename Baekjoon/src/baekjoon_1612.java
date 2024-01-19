import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class baekjoon_1612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num = 1;
        int length = 1;

        HashSet<Integer> set = new HashSet<>();

        while (true) {
            if (num % N == 0) {
                System.out.println(length);
                break;
            }
            if (set.contains(num)) {
                System.out.println(-1);
                break;
            } else {
                set.add(num);
            }
            num = (num * 10 + 1) % N;
            length++;
        }
    }
}
