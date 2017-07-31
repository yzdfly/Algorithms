class FindMaxSubArray{
	public static void main(String[] args) {
		int[] A= {13,-2,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		int[] result = new int[3];
		FindMaxSubArray3(A,result);
		for (int i: result) {
			System.out.print(i+" ");
		}
	}

	//暴力求解
	public static int[] FindMaxSubArray1(int[] A,int[] result){
		int i = 0, j = 0;
		int maxSum = 0;
		int len = A.length;
		for (int m = 0;m < len; m++) {
			int curSum = 0;
			for (int n = m; n < len; n++) {
				curSum += A[n];
				if (curSum > maxSum){
					maxSum = curSum;
					i = m;
					j = n;
				}
			}
		}
		result[0] = i;
		result[1] = j;
		result[2] = maxSum;
		return result;
	}

	//分治思想
	public void FindMaxSubArray2(){

	}

	//最优解
	public static int[] FindMaxSubArray3(int[] A,int[] result){
		int m;
		//记录起始元素的下标
		int i = 0;
		//记录终止元素的下标
		int j = 0;
		// //记录 上一次maxSum最大时终止元素的下标
		// int k = 0;
		//记录curSum又一次从负整数变为正整数时起始元素的下标
		int flag = 0;
		//最大子数组和
		int maxSum = 0;
		//当前最大子数组和
		int curSum = 0;
		for (m=0;m<A.length ;m++ ) {
			curSum += A[m];
			if(curSum>maxSum){
				//当前最大子数组和较大时，更换起始元素下标
				if (flag != i) {
					i = flag;
				}
				//更换当前终止元素下标
				j = m;
				// //更换上一次最大子数组终止元素的下标
				// if(k!=0||k!=j){
				// 	k++;
				// }
				// if ((j-k)!=1||j==0){
				// 	k = m;
				// }
				maxSum = curSum;
			}
			if(curSum<0){
				curSum = 0;
				//记录下一个起始元素的下标
				if (m<(A.length-1)) {
					if (A[m+1]>0) {
						flag = m+1;
					}
				}
			}
		}
		result[0] = i;
		result[1] = j;
		result[2] = maxSum;
		return result;
	}
}