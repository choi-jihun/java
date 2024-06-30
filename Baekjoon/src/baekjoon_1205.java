import java.io.*;
import java.util.*;

public class baekjoon_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        int rank = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > newScore) {
                rank++;
            } else {
                break;
            }
        }

        if (N == P && list.get(N - 1) >= newScore) {
            rank = -1;
        }

        bw.write(String.valueOf(rank));
        br.close();
        bw.flush();
        bw.close();
    }
}
