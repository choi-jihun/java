import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon_23559 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int [][]A = new int [N][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
            A[i][2] = Math.abs(A[i][0]-A[i][1]);
        }
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] == o2[2]) {
                    return o2[0] - o1[0];
                }else {
                    return o2[2] - o1[2];
                }
            }
        });
        int sum = 0;
        int day = 1;
        for(int i = 0; i < N; i++) {
            if(X<=0)
                break;
            if(X - 5000 >= 1000 * (N-day) && A[i][0] > A[i][1]) {
                sum += A[i][0];
                X-=5000;
            }
            else{
                sum+=A[i][1];
                X-=1000;
            }
            day++;
        }
        System.out.println(sum);
    }

}