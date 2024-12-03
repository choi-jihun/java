import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class baekjoon_1706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] puzzle = new char[R][C];

        for (int i = 0; i < R; i++) {
            puzzle[i] = br.readLine().toCharArray();
        }

        TreeSet<String> words = new TreeSet<>();

        for (int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < C; j++) {
                if (puzzle[i][j] != '#') {
                    sb.append(puzzle[i][j]);
                } else {
                    if (sb.length() > 1) words.add(sb.toString());
                    sb.setLength(0);
                }
            }
            if (sb.length() > 1) words.add(sb.toString());
        }

        for (int j = 0; j < C; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                if (puzzle[i][j] != '#') {
                    sb.append(puzzle[i][j]);
                } else {
                    if (sb.length() > 1) words.add(sb.toString());
                    sb.setLength(0);
                }
            }
            if (sb.length() > 1) words.add(sb.toString());
        }

        bw.write(words.first());
        bw.flush();
        br.close();
        bw.close();
    }
}
