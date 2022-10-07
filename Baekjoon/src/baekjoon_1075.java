import java.util.Scanner;

public class baekjoon_1075 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int F = input.nextInt();
		N = (N/100)*100;
		while(N%F!=0) 
			N++;
		N %= 100;
		if(N<10)
			System.out.println("0"+N);
		else
			System.out.println(N);
	}

}