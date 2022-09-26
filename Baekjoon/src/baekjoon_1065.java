import java.util.Scanner;

public class baekjoon_1065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int ans = 0;
		if(num<100)
			ans = num;
		else if(num>=100) {
			ans = 99;
			for(int i = 100; i<=num; i++) {
				int hun = i/100;
				int ten = (i/10) % 10;
				int one = i%10;
				if((hun-ten) == (ten-one))
					ans++;
			}
			
		}
		System.out.println(ans);
		input.close();
	}

}
