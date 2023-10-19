import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String A = st.nextToken();
        String B = st.nextToken();

        int sameIdxA = 0;
        int sameIdxB = 0;
        boolean found = false;

        for (int i = 0; i < A.length(); i++) {
            char chA = A.charAt(i);
            for (int j = 0; j < B.length(); j++) {
                if (chA == B.charAt(j)) {
                    sameIdxA = i;
                    sameIdxB = j;
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }

        for (int i = 0; i < B.length(); i++) {
            if (i == sameIdxB) {
                sb.append(A).append("\n");
                continue;
            } else {
                for (int j = 0; j < A.length(); j++) {
                    if (j == sameIdxA)
                        sb.append(B.charAt(i));
                    else
                        sb.append(".");
                }
                sb.append("\n");
            }


        }

        System.out.println(sb);
    }
}
