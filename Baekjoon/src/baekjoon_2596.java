import java.io.*;

public class baekjoon_2596 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] codes = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };
        char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String str = input.substring(i * 6, (i + 1) * 6);
            boolean found = false;
            for (int j = 0; j < codes.length; j++) {
                if (isDifferent(str, codes[j])) {
                    sb.append(letters[j]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                bw.write((i + 1) + "\n");
                bw.flush();
                return;
            }
        }

        bw.write(sb + "\n");
        bw.flush();
    }

    private static boolean isDifferent(String received, String code) {
        int differenceCount = 0;
        for (int i = 0; i < 6; i++) {
            if (received.charAt(i) != code.charAt(i)) {
                differenceCount++;
            }
            if (differenceCount > 1) {
                return false;
            }
        }
        return true;
    }
}
