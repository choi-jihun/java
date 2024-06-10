import java.io.*;

public class baekjoon_4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        int num = 1;

        while ((str = br.readLine()) != null) {
            if (str.contains("-")) {
                break;
            }

            int minOperations = getMinOperations(str);

            bw.write(num + ". " + minOperations + "\n");
            num++;
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int getMinOperations(String line) {
        int length = line.length();
        int open = 0;
        int close = 0;
        int minOperations = 0;

        for (int i = 0; i < length; i++) {
            char ch = line.charAt(i);
            if (ch == '{') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }

        minOperations = open / 2 + close / 2 + (open % 2) * 2;
        return minOperations;
    }
}
