import java.util.Scanner;

public class baekjoon_2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int count = 0;
		
		while(true) {
			if(N%5 ==0) {
				System.out.println(N/5+count);
				break;
			}
			else if(N<0) {
				System.out.println(-1);
				break;
			}
			count++;
			N-=3;
				
		}
	}
}
