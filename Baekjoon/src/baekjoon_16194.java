import java.util.Scanner;

public class baekjoon_16194 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int []dp = new int [N+1];
		int []card = new int [N+1];
		for(int i =1; i<N+1;i++) 
			card[i] = input.nextInt();
		
		for(int  i =1; i<N+1;i++) {
			dp[i] = card[i];
			for(int j = 1; j<=i;j++)
				dp[i] = Math.min(dp[i], card[j] + dp[i-j]);
			
		}
		System.out.println(dp[N]);
	}

}
