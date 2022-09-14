package Sort;

class Selection_Sort {
	void selection_sort(int arr[]) {
		int temp;
		for(int i = 0; i < arr.length - 1; i++) {
			int idx = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j]<arr[idx])
					idx = j;
			}
			temp = arr[idx];
			arr[idx] = arr[i];
			arr[i] = temp;
		}
	}
	
	static void printArr(int arr[]) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,9,23,15,25};
		Selection_Sort obj = new Selection_Sort();
		obj.selection_sort(arr);
		printArr(arr);
	}

}
