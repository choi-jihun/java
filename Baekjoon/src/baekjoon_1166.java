import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_1166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        double left = 0, right = Math.max(L, Math.max(W, H)), mid;
        for(int i = 0; i < 10000; i++) { // 이진 탐색을 위한 반복, 10^-9의 정밀도를 위해 충분한 반복 횟수 설정
            mid = (left + right) / 2;
            long count = (long)(L / mid) * (long)(W / mid) * (long)(H / mid);
            if(count >= N) {
                left = mid;
            } else {
                right = mid;
            }
        }
        bw.write(String.format("%.9f", left));
        bw.flush();
    }
}
