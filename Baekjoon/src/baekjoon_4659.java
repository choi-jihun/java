import java.io.*;

public class baekjoon_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }
            if (isAcceptable(str)) {
                bw.write(String.format("<%s> is acceptable.\n", str));
            } else {
                bw.write(String.format("<%s> is not acceptable.\n", str));
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean isAcceptable(String password) {
        boolean hasVowel = false;
        int consecutiveVowels = 0;
        int consecutiveConsonants = 0;
        char lastChar = ' ';

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (isVowel(c)) {
                hasVowel = true;
                consecutiveVowels++;
                consecutiveConsonants = 0;
            } else {
                consecutiveConsonants++;
                consecutiveVowels = 0;
            }

            if (consecutiveVowels > 2 || consecutiveConsonants > 2)
                return false;

            if (c == lastChar && c != 'e' && c != 'o')
                return false;

            lastChar = c;
        }

        return hasVowel;
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}
