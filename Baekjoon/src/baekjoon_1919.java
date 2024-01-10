import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] count1 = new int[256];
        int[] count2 = new int[256];

        for (int i = 0; i < str1.length(); i++)
            count1[str1.charAt(i)]++;

        for (int i = 0; i < str2.length(); i++)
            count2[str2.charAt(i)]++;

        int result = 0;
        for (int i = 0; i < 256; i++)
            result += Math.abs(count1[i] - count2[i]);

        System.out.println(result);
    }
}
