import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class baekjoon_1076 {

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      HashMap<String, int[]> map = new HashMap<String, int[]>() {{
            put("black", new int[]{0, 1});
            put("brown", new int[]{1, 10});
            put("red", new int[]{2, 100});
            put("orange", new int[]{3, 1000});
            put("yellow", new int[]{4, 10000});
            put("green", new int[]{5, 100000});
            put("blue", new int[]{6, 1000000});
            put("violet", new int[]{7, 10000000});
            put("grey", new int[]{8, 100000000});
            put("white", new int[]{9, 1000000000});
        }};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();
       String temp = "";
       temp += map.get(first)[0];
       temp += map.get(second)[0];
       long answer = Long.parseLong(temp) *  map.get(third)[1];
       
       System.out.println(answer);
   }

}