import java.io.*;
import java.util.*;

public class baekjoon_2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> badCombinations = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            badCombinations.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            badCombinations.get(a).add(b);
            badCombinations.get(b).add(a);
        }

        int count = 0;
        for (int i = 1; i <= N - 2; i++) {
            for (int j = i + 1; j <= N - 1; j++) {
                for (int k = j + 1; k <= N; k++) {
                    if (!badCombinations.get(i).contains(j) &&
                            !badCombinations.get(i).contains(k) &&
                            !badCombinations.get(j).contains(k)) {
                        count++;
                    }
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}
