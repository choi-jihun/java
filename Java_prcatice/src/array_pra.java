public class array_pra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] studentsID = new int[] {100,101,102};
		//int [] studentsID2 = new int[3] {100,101,102}; 오류 발생!
		int [][] arr = new int[2][3];
		for(int i = 0; i < arr.length; i++)
			for(int j=0; j < arr[i].length; j++)
				System.out.println(arr[i][j]);
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		char[] alphabets = new char[26];
		char ch = 'A';
		for(int i =0;i<alphabets.length;i++,ch++)
			alphabets[i]=ch;
		for(int i = 0; i < alphabets.length; i++)
			System.out.println(alphabets[i] + "," + (int)alphabets[i]);
		
	}

}
