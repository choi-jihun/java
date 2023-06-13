import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Integer> hSet = new HashSet<>();

        for (int i =0; i < N; i++)
            hSet.add(Integer.parseInt(st.nextToken()));

        ArrayList<Integer> list = new ArrayList<>(hSet);
        Collections.sort(list);

        for (int i : list)
            System.out.print(i + " ");
    }
}
