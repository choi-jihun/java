import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_3005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] puzzle = new char[R][C];
        for (int i = 0; i < R; i++) {
            puzzle[i] = br.readLine().toCharArray();
        }
        List<String> words = getStrings(R, puzzle, C);

        Collections.sort(words);
        bw.write(words.get(0));
        bw.flush();
        br.close();
        bw.close();
    }

    private static List<String> getStrings(int R, char[][] puzzle, int C) {
        List<String> words = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String[] rows = new String(puzzle[i]).split("#");
            for (String word : rows) {
                if (word.length() >= 2) {
                    words.add(word);
                }
            }
        }

        for (int j = 0; j < C; j++) {
            StringBuilder column = new StringBuilder();
            for (int i = 0; i < R; i++) {
                column.append(puzzle[i][j]);
            }
            String[] cols = column.toString().split("#");
            for (String word : cols) {
                if (word.length() >= 2) {
                    words.add(word);
                }
            }
        }
        return words;
    }
}
