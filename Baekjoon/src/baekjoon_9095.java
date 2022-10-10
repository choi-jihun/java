import java.util.Scanner;

public class baekjoon_9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int []memo = new int [100];
		memo[1]=1;
		memo[2]=2;
		memo[3]=4;
		for(int i = 0; i < N;i++) {
			int num = input.nextInt();
			for(int j = 4; j <= num; j++)
				memo[j] = memo[j-3] + memo[j-2] + memo[j-1];
			System.out.println(memo[num]);
		}
	}

}
