
public class baekjoon_4673 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean []check = new boolean [10001];
		for(int i = 1; i < 10001; i++) {
			int k = i;
			int n = i;
			while(n>0) {
				k+=n%10;
				n/=10;
			}
			if(k<10001)
				check[k] = true;
		}
		for(int i = 1; i < 10001; i++)
			if(!check[i])
				System.out.println(i);
	}

}
