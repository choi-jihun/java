import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_18111 {
    static int [][]map;
    static int N,M,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        map = new int [N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,map[i][j]);
                min = Math.min(min,map[i][j]);
            }
        }
        int time = Integer.MAX_VALUE;
        int floor = 0;

        for(int i = min; i <= max; i++){
            int cnt = 0;
            int block = B;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(i < map[j][k]){
                        cnt += (map[j][k] - i) * 2;
                        block += map[j][k] - i;
                    }
                    else{
                        cnt += i - map[j][k];
                        block -= i -map[j][k];
                    }
                }
            }
            if(block < 0)
                break;
            if(time >= cnt){
                time = cnt;
                floor = i;
            }
        }
        System.out.println(time + " " + floor);
    }
}
