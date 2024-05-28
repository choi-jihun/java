import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;


//HashSet을 이용하여 탐색
//시간 복잡도 200000^2(n^2)
//시간초과 대 실패!!!
//x,y를 문자열로 저장하고 이중포문을 통해 구하려고 했음
public class baekjoon_17430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            HashSet<String> sets = new HashSet<>();
            HashSet<Integer> xSet = new HashSet<>();
            HashSet<Integer> ySet = new HashSet<>();
            boolean isBalanced = true;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                sets.add(x + "," + y);
                xSet.add(x);
                ySet.add(y);
            }

            for (int x : xSet) {
                for (int y : ySet) {
                    if (!sets.contains(x + "," + y)) {
                        isBalanced = false;
                        break;
                    }
                }
                if (!isBalanced) break;
            }
            if (isBalanced) {
                bw.write("BALANCED\n");
            } else {
                bw.write("NOT BALANCED\n");
            }
        }
        bw.flush();
    }
}
