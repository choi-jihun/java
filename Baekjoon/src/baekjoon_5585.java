import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int change = 1000-n;
        while(change > 0){
            if(change / 500 > 0){
                count += change/500;
                change %= 500;
            }
            else if(change / 100 > 0){
                count += change / 100;
                change %= 100;
            }
            else if (change / 50 > 0) {
                count += change / 50;
                change %= 50;
            }
            else if (change / 10 > 0) {
                count += change / 10;
                change %= 10;
            }
            else if (change / 5 > 0) {
                count += change / 5;
                change %= 5;
            }
            else{
                count += change / 1;
                change %= 1;
            }
        }
        System.out.println(count);
    }
}
