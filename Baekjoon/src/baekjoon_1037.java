import java.util.Scanner;

public class baekjoon_1037 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<N;i++) {
			int x = input.nextInt();
			min = Math.min(x,min);
			max = Math.max(x, max);
		}
		System.out.println(min*max);
	}

}
