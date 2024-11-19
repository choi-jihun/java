import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class baekjoon_2057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());

        if (N == 0) {
            bw.write("NO");
            bw.flush();
            return;
        }

        List<Long> factorials = new ArrayList<>();
        long factorial = 1;
        for (int i = 1; factorial <= N; i++) {
            factorials.add(factorial);
            factorial *= i;
        }
        if (canRepresentAsFactorialSum(N, factorials)) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
    }

    private static boolean canRepresentAsFactorialSum(long target, List<Long> factorials) {
        int size = factorials.size();
        int maxSubset = 1 << size;

        for (int subset = 0; subset < maxSubset; subset++) {
            long sum = 0;
            for (int i = 0; i < size; i++) {
                if ((subset & (1 << i)) != 0) {
                    sum += factorials.get(i);
                }
            }
            if (sum == target) {
                return true;
            }
        }
        return false;
    }
}
