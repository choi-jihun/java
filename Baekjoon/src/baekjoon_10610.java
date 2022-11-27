import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 0;
        int len = str.length();
        int []arr = new int [len];
        for(int i = 0; i < len; i++){
            sum+=str.charAt(i) - '0';
            arr[i] = str.charAt(i) - '0';
        }
        if((sum % 3) !=0 || !str.contains("0")){
            System.out.println(-1);
            return;
        }
        Arrays.sort(arr);
        for(int i = len - 1; i >= 0; i--)
            System.out.print(arr[i]);
    }
}
