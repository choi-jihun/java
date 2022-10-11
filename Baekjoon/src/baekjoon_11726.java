import java.util.Scanner;

public class baekjoon_11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int [] memo = new int [n+2];
		memo[1]=1;
		memo[2]=2;
		for(int i = 3; i <= n; i++)
			memo[i] = (memo[i-1] + memo[i-2])%10007;
		System.out.println(memo[n]);
	}

}
