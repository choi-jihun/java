import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] snacks = new int[N];
        long maxSnackLength = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            maxSnackLength = Math.max(maxSnackLength, snacks[i]);
        }

        long low = 1, high = maxSnackLength;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (canDistribute(snacks, M, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static boolean canDistribute(int[] snacks, int M, long length) {
        if (length == 0)
            return false;

        long count = 0;
        for (int snack : snacks) {
            count += snack / length;
        }

        return count >= M;
    }
}
