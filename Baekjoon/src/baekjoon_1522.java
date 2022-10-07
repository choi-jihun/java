import java.util.Scanner;

public class baekjoon_1522 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str = input.next();
		
		int min = Integer.MAX_VALUE;
		int a_count = 0;
		for(int i =0; i< str.length();i++)
			if(str.charAt(i)=='a')
				a_count++;
		
		for(int i =0; i< str.length();i++) {
			int b_count=0;
			for(int j =i; j<i + a_count;j++) {
				int idx = j % str.length();
				if(str.charAt(idx)=='b')
					b_count++;
			}
			min = Math.min(min, b_count);
		}
		System.out.println(min);
	}

}
