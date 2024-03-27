import java.io.*;
import java.util.*;

public class baekjoon_11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<Integer>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int temp = -1;
            if (!str.equals("all") && !str.equals("empty")) {
                temp = Integer.parseInt(st.nextToken());
            }
            switch (str) {
                case "add": {
                    set.add(temp);
                    break;
                }
                case "remove": {
                    set.remove(temp);
                    break;
                }
                case "check": {
                    bw.write(set.contains(temp) ? "1\n" : "0\n");
                    break;
                }
                case "toggle": {
                    if (set.contains(temp)) {
                        set.remove(temp);
                    } else {
                        set.add(temp);
                    }
                    break;
                }

                case "all": {
                    set.clear();
                    for (int i = 1; i <= 20; i++) {
                        set.add(i);
                    }
                    break;
                }
                case "empty": {
                    set.clear();
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
