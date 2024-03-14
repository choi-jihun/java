import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class baekjoon_1174 {

    static int N;
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        if (N > 1023) {
            bw.write("-1");
        } else {
            for (int i = 0; i < 10; i++) {
                back(1, i);
            }
            Collections.sort(list);
            bw.write(String.valueOf(list.get(N - 1)));
        }
        bw.flush();
    }

    static void back(int length, long num) {
        if (length > 10)
            return;

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            back(length + 1, num * 10 + i);
        }
    }

}