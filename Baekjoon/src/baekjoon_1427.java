import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class baekjoon_1427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String num = input.next();
		Integer []arr = new Integer[num.length()];
		for(int i = 0; i < num.length(); i++)
			arr[i] = Character.getNumericValue(num.charAt(i));
		Arrays.sort(arr,Collections.reverseOrder());
		for(int i = 0; i<arr.length;i++)
			System.out.print(arr[i]);
	}

}
