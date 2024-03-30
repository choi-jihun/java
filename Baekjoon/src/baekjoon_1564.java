import java.io.*;

public class baekjoon_1564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long k = (long) 1e12;

        long factorial = 1;
        for (int i = 2; i <= N; i++) {
            factorial *= i;
            while (factorial % 10 == 0) {
                factorial /= 10;
            }
            factorial %= k;
        }

        factorial %= 100000;
        StringBuilder sb = new StringBuilder();
        if (factorial < 10000) sb.append(0);
        if (factorial < 1000) sb.append(0);
        if (factorial < 100) sb.append(0);
        if (factorial < 10) sb.append(0);
        sb.append(factorial);
        bw.write(sb.toString());
        bw.flush();
    }
}
