import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (true) {
            if (isPalindrome(N) && isPrime(N)) {
                System.out.println(N);
                break;
            }
            N++;
        }
    }

    static boolean isPalindrome(int number) {
        String numStr = String.valueOf(number);
        int len = numStr.length();
        for (int i = 0; i < len / 2; i++) {
            if (numStr.charAt(i) != numStr.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
