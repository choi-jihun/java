import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int []arr = new int [W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int i = 1; i < W - 1; i++){
            int start = 0;
            int end = 0;
            for(int j = 0; j < i; j++)
                start = Math.max(arr[j],start);
            for(int j = i+1; j<W;j++)
                end = Math.max(arr[j],end);

            if(arr[i]<start && arr[i]<end)
                sum += Math.min(start,end) - arr[i];
        }
        System.out.println(sum);
    }
}
