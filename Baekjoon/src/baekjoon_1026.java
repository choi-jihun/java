import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int [] A = new int [num];
		int [] B = new int [num];
		int [] C = new int [num];
		for(int i = 0; i < num;i++) 
			A[i] = input.nextInt();
		for(int i = 0; i < num;i++) 
			B[i] = input.nextInt();
		for(int i = 0; i < num;i++)
			C[i] = B[i];
		Arrays.sort(A);
		Arrays.sort(C);
		int ans = 0;
		for(int i =0;i < num; i++) 
			ans += A[i] * C[num-i-1];
		
		System.out.print(ans);
	}

}