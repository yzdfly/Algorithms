import java.io.*;
public class InsertionSort{
	public static void InsertionSort(int[] A){
		//从第二个元素开始循环
		for(int i=1;i<A.length;i++){
			//得到需要排序的数
			int key = A[i];
			//跟之前排好序的最大的元素开始比较，此时j为之前排好序的最大的元素的下标
			int j = i - 1;
			//循环比较，直到这个数>前一个数并且<后一个数
			while(j>=0&&A[j]>key){
				//比这个数大，则之前的数往后移
				A[j+1] = A[j];
				j = j - 1;
			}
			//把这个数放入数组中
			A[j + 1] = key;
		}
	}

	
	public static void main(String[] args) {
		int[] A = { 4, 6, 9, 10, 5, 3};
		InsertionSort(A);
		for(int a: A){
			System.out.print(a+" ");
		}
	}
	
}