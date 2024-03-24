import java.io.*;

public class baekjoon_9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int temp = Integer.parseInt(br.readLine());
            for (int i = temp / 2; i >= 2; i--) {
                if (isPrime(i) && isPrime(temp - i)) {
                    bw.write(i + " " + (temp - i) + "\n");
                    break;
                }
            }
        }
        bw.flush();
    }

    static boolean isPrime(int num) {
        if (num <= 1)
            return false;

        if (num == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
