import java. util.Arrays;

public class des {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String L1 = "0001 0010 0011 0100 0110 1110 0101 1001";
		String R1 = "1011 1100 0111 1010 1000 0110 1010 1111";
		System.out.println("         -  입력 평문 -         ");
		System.out.println("L1 : "+L1);
		System.out.println("R1 : "+R1);
		//R1 = R1.trim();
		R1 = R1.replace("\s", "");
		int [] arr = new int [R1.length()];
		for(int i = 0; i < R1.length();i++)
			arr[i] = R1.charAt(i) - '0';
		/*for(int i = 0; i < arr.length;i++)
			System.out.print(arr[i]);*/
		int b[]=new int[48];
		int index=0;
		int count =0;
		int last=arr.length-1;
		while(count<48) {
			if(last>arr.length-1)
				last=0;
			b[index++]=arr[last++];
			count++;
			if(count%6==0)
				last-=2;
		}
		int cnt=0;
		System.out.println("         -  R1 Extend -         ");
		System.out.print("ext_R1 : ");
		for(int i=0;i<b.length;i++) {
			if(i==5 || cnt == 5) {
				System.out.print(b[i]+ "  ");
				cnt = 0;
			}
			else {
				System.out.print(b[i]);
				cnt++;
			}
		}
	}

}
