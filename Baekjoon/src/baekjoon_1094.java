import java.util.Scanner;

public class baekjoon_1094 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int X = input.nextInt();
		int bar = 64;
		int count = 0;
		while(X>0) {
			if(bar>X)
				bar/=2;
			else {
				count++;
				X-=bar;
			}
		}
		System.out.println(count);
	}

}