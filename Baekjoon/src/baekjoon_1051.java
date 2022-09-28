import java.util.Scanner;

public class baekjoon_1051 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int [][] arr = new int [N][M];
		for(int i =0; i<N;i++) {
			String str = input.next();
			for(int j=0;j<M;j++)
				arr[i][j] = Character.getNumericValue(str.charAt(j));
		}
		int size = 1;
		int max_size = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j< M; j++) {
				for(int k =0; k<Math.min(N, M);k++) {
					if(i+k <N && j+k<M) {
						if(arr[i][j] == arr[i][j+k] && arr[i][j] == arr[i+k][j] && arr[i][j] == arr[i+k][j+k]) {
							size = (k+1) * (k+1);
							max_size = Math.max(max_size, size);
						}
					}
				}
			}
		}
		System.out.print(max_size);
		input.close();
	}

}
