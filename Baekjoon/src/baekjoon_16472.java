import java.io.*;

public class baekjoon_16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int maxLen = 0;
        int left = 0;
        int[] count = new int[26];
        int distinctCount = 0;

        for (int right = 0; right < str.length(); right++) {
            char rc = str.charAt(right);
            if (count[rc - 'a'] == 0) {
                distinctCount++;
            }
            count[rc - 'a']++;

            // 문자 종류가 N을 초과하면 왼쪽에서 축소
            while (distinctCount > N) {
                char lc = str.charAt(left);
                count[lc - 'a']--;
                if (count[lc - 'a'] == 0) {
                    distinctCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        bw.write(String.valueOf(maxLen));
        bw.flush();
    }
}
