import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RSA {

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      Scanner input = new Scanner(System.in);
      int p = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());
      int e = 3;
      int a = (p-1) * (q-1);
      int d = 2;
      while(d<100) {
         if((e*d)%a==1)
            break;
         else
            d++;
      }
      System.out.println("개인키 : " +d);
      System.out.print("메시지 입력 : ");
      int M = input.nextInt();
      int C = (int) Math.pow(M, e) % (p*q);
      System.out.println("암호문 : "+ C);
      System.out.println("복호화 : "+ (long)Math.pow(C, d)%(p*q));
   }

}
