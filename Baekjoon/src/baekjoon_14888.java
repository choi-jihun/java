import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_14888 {
    static int []NUM;
    static int N;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int []operator = new int [4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        NUM = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            NUM[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++)
            operator[i] = Integer.parseInt(st.nextToken());
        dfs(NUM[0],1);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int num, int idx){
        if(idx == N){
            max = Math.max(max,num);
            min = Math.min(min,num);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(operator[i] > 0){
                operator[i]--;
                switch (i){
                    case 0:
                        dfs(num+NUM[idx],idx+1);
                        break;
                    case 1:
                        dfs(num-NUM[idx],idx+1);
                        break;
                    case 2:
                        dfs(num*NUM[idx],idx+1);
                        break;
                    case 3:
                        dfs(num/NUM[idx],idx+1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
