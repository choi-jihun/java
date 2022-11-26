import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []sub = br.readLine().split("-");
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < sub.length; i++){
            int temp = 0;
            String []add = sub[i].split("\\+");
            for(int j = 0; j < add.length; j++)
                temp += Integer.parseInt(add[j]);
            if(sum == Integer.MAX_VALUE)
                sum = temp;
            else
                sum -= temp;
        }
        System.out.println(sum);
    }
}
