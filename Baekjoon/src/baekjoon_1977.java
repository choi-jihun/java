import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int i = 1;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(true){
            if(i*i>n)
                break;
            if(i*i >= m && i*i <= n){
                sum += i*i;
                min = Math.min(min,i*i);
            }

            i++;
        }
        if(sum==0)
            System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }

    }
}
