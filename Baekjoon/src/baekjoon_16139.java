import java.io.*;
import java.util.*;

public class baekjoon_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int[][] freq = new int[26][str.length() + 1];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < 26; j++) {
                freq[j][i + 1] = freq[j][i];
            }
            freq[ch - 'a'][i + 1]++;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int count = freq[ch - 'a'][end + 1] - freq[ch - 'a'][start];
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
