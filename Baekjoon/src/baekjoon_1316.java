//https://blog.naver.com/dh971125/222378910497
//코드를 참조한 곳
import java.util.Scanner;

public class baekjoon_1316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N=input.nextInt();
		int count=N;
		for(int i = 0; i< N; i++) {
			String str = input.next();
			boolean chk[] = new boolean [26];
			for(int j = 0; j < str.length() - 1;j++) {
				if(str.charAt(j) != str.charAt(j+1)) 
					if(chk[str.charAt(j+1)-97]==true) {
						count--;
						break;
					}
				chk[str.charAt(j)-97]=true;
			}
		}
		System.out.println(count);
	}

}