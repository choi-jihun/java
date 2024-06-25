import java.io.*;

public class baekjoon_15312 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = br.readLine();
        String B = br.readLine();
        int[] count = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        int len = A.length();
        int[] combine = new int[len * 2];
        for (int i = 0; i < len; i++) {
            combine[i * 2] = count[A.charAt(i) - 'A'];
            combine[i * 2 + 1] = count[B.charAt(i) - 'A'];
        }

        while (combine.length > 2) {
            int[] newStrokes = new int[combine.length - 1];
            for (int i = 0; i < combine.length - 1; i++) {
                newStrokes[i] = (combine[i] + combine[i + 1]) % 10;
            }
            combine = newStrokes;
        }

        bw.write(String.format("%d%d", combine[0], combine[1]));
        bw.flush();
    }
}
