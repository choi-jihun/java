import java.io.*;
import java.util.*;

public class baekjoon_1544 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> uniqueWords = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            uniqueWords.add(getCanonicalForm(word));
        }

        bw.write(uniqueWords.size() + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static String getCanonicalForm(String word) {
        String original = word;
        String rotated = word + word;

        for (int i = 1; i < word.length(); i++) {
            String candidate = rotated.substring(i, i + word.length());
            if (candidate.compareTo(original) < 0) {
                original = candidate;
            }
        }
        return original;
    }
}
