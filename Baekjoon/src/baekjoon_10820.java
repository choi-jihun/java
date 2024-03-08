import java.io.*;

public class baekjoon_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;

        while ((str = br.readLine()) != null) {
            int small = 0;
            int big = 0;
            int num = 0;
            int space = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == ' ') {
                    space++;
                } else if (Character.isUpperCase(ch)) {
                    big++;
                } else if (Character.isLowerCase(ch)) {
                    small++;
                } else if (Character.isDigit(ch)) {
                    num++;
                }
            }
            bw.write(small + " " + big + " " + num + " " + space + "\n");
            bw.flush();
        }

    }
}
