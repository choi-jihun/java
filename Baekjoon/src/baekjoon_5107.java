import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_5107 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int idx = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            HashMap<String, String> map = new HashMap<String, String>();
            HashSet<String> visited = new HashSet<String>();
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                map.put(st.nextToken(), st.nextToken());
            }

            for (String person : map.keySet()) {
                if (!visited.contains(person)) {
                    String current = person;
                    boolean isCycle = false;
                    while (map.containsKey(current) && !visited.contains(current)) {
                        visited.add(current);
                        current = map.get(current);
                        if (current.equals(person)) {
                            isCycle = true;
                            break;
                        }
                    }
                    if (isCycle)
                        cnt++;
                }
            }
            bw.write(String.format("%d %d\n", idx, cnt));
            idx++;
        }
        bw.flush();

        bw.flush();
    }

}