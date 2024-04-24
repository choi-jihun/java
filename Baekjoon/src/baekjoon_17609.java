import java.io.*;

public class baekjoon_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            bw.write(determinePalindromeType(s) + "\n");
        }
        bw.flush();
    }

    public static int determinePalindromeType(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1)) {
                    return 1;
                }
                return 2;
            }
            i++;
            j--;
        }
        return 0;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
