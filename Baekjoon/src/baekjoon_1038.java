import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baekjoon_1038 {
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 10) {
            System.out.println(N);
            return;
        } else if (N >= 1023) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < 10; i++) {
            DFS(i, 1);
        }
        Collections.sort(list);
        System.out.println(list.get(N));

    }

    static void DFS(long num, int idx) {
        if (idx > 10) {
            return;
        }

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            DFS((num * 10) + i, idx + 1);
        }
    }

}