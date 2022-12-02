import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2992 {

    static char []ch;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        ch = str.toCharArray();
        System.out.println(back(0,0,0,0));
    }

    public static long back(int idx, int vowel, int con, int ans){
        if(vowel ==3 || con == 3)
            return 0;
        if(idx == ch.length)
            return ans;
        long count = 0;
        if(ch[idx]=='_'){
            count += back(idx+1,vowel + 1,0, ans) * 5;
            count += back(idx + 1, 0, con + 1, ans) * 20;
            count += back(idx+1, 0, con + 1, 1);
        }
        else if (ch[idx] == 'A' || ch[idx] == 'E' || ch[idx] == 'I' || ch[idx] == 'O' || ch[idx] == 'U')
            count += back(idx + 1, vowel + 1, 0, ans);
        else{
            if(ch[idx] == 'L')
                count += back(idx + 1, 0, con + 1, 1);
            else
                count += back(idx + 1, 0, con + 1, ans);
        }
        return count;
    }
}
