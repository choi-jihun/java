import java.io.*;
import java.util.*;

public class baekjoon_9009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        List<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(2);
        while (true) {
            int nextFib = fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2);
            if (nextFib > 1000000000)
                break;
            fibs.add(nextFib);
        }

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> result = new ArrayList<>();

            for (int i = fibs.size() - 1; i >= 0; i--) {
                if (fibs.get(i) <= n) {
                    n -= fibs.get(i);
                    result.add(fibs.get(i));
                }
                if (n == 0)
                    break;
            }

            Collections.sort(result);
            for (int i = 0; i < result.size(); i++) {
                if (i > 0) bw.write(" ");
                bw.write(String.valueOf(result.get(i)));
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
