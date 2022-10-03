import java.util.Scanner;

public class baekjoon_25628 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int A = input.nextInt();
		int B = input.nextInt();
		int ans = A/2;
		if(A < 2)
			ans = 0;
		else if(ans > B)
			ans = B;
		System.out.print(ans);
	}

}