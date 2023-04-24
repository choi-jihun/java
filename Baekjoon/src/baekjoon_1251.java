import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baekjoon_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String temp = "";
                temp += reverse(0, i, str);
                temp += reverse(i, j, str);
                temp += reverse(j, str.length(), str);
                list.add(temp);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }

    static String reverse(int start, int end, String str) {
        StringBuilder temp = new StringBuilder();
        for (int i = end - 1; i >= start; i--)
            temp.append(str.charAt(i));

        return temp.toString();
    }
}
