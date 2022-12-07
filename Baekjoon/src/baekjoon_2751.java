import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baekjoon_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++)
            arr.add(Integer.parseInt(br.readLine()));
        Collections.sort(arr);
        for(int value : arr)
            sb.append(value).append("\n");
        System.out.println(sb);
    }
}
