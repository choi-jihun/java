import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int dis = 0;

        String[] str = new String[N];
        for (int i = 0; i < N; i++)
            str[i] = br.readLine();

        for (int i = 0; i < M; i++) {
            int[] cnt = new int[4];
            for (int j = 0; j < N; j++) {
                char ch = str[j].charAt(i);
                switch (ch) {
                    case 'A':
                        cnt[0]++;
                        break;
                    case 'C':
                        cnt[1]++;
                        break;
                    case 'G':
                        cnt[2]++;
                        break;
                    case 'T':
                        cnt[3]++;
                        break;
                }
            }

            int idx = 0;
            int max = 0;
            for (int k = 0; k < 4; k++) {
                if (cnt[k] > max || (cnt[k] == max && k < idx)) {
                    max = cnt[k];
                    idx = k;
                }
            }
            switch (idx) {
                case 0:
                    sb.append('A');
                    break;
                case 1:
                    sb.append('C');
                    break;
                case 2:
                    sb.append('G');
                    break;
                case 3:
                    sb.append('T');
                    break;
            }
            dis += N - max;
        }

        System.out.println(sb);
        System.out.println(dis);
    }
}
