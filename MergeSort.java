public class MergeSort{
	public static void main(String[] args) {
		int A[] = {
			1,6,4,5,2,9,7,23,56,43,98,56
		};
		int[] temp = new int[A.length];
		MergeSort(A,temp,0,A.length-1);
		for (int i:A){
			System.out.print(i+" ");
		}
	}

	public static void MergeSort(int[] A,int[] temp,int start,int end){
		if (start<end){
			int mid = (start+end)/2;
			//把数组分解为两个子列
			MergeSort(A,temp,start,mid);
			MergeSort(A,temp,mid+1,end);
			//逐级合并两个子列
			Merge(A,temp,start,mid,end);
		}
	}

	public static void Merge(int[] A,int[] temp,int start,int mid,int end){
		int i = start;
		int j = mid+1;
		int k = 0;
		while(i<=mid&&j<=end){
			if (A[i]<=A[j]) {
				temp[k] = A[i];
				i++;
				k++;
			}else {
				temp[k] = A[j];
				j++;
				k++;
			}
		}
		while(i<=mid){
			temp[k] = A[i];
			k++;
			i++;
		}
		while(j <= end){
			temp[k] = A[j];
			k++;
			j++;
		}
		for (int m = 0; m<k; m++) {
			A[start+m] = temp[m];
		}
	}
}