class FindMaxSubArray{
	public static void main(String[] args) {
		int[] A= {13,-2,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		//存放最大字数组的起始下标，终止下标，数组和
		int[] result = new int[3];
		result = FindMaxSubArray2(A,result,0,A.length-1);
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
		getResult(result,i,j,maxSum);
		return result;
	}

	//分治思想
	public static int[] FindMaxSubArray2(int[] A,int[] result,int low,int high){
		if(low==high){
			result = getResult(result,low,high,A[low]);
			return result;
		}else{
			int mid = (low+high)/2;
			int[] leftResult = new int[3];
			int[] rightResult = new int[3];
			int[] crossResult = new int[3];
			leftResult = FindMaxSubArray2(A,leftResult,low,mid);
			rightResult = FindMaxSubArray2(A,rightResult,mid+1,high);
			crossResult = FindMaxCrossingSubArray(A,crossResult,low,mid,high);
			if(leftResult[2]>=rightResult[2]&&leftResult[2]>=crossResult[2]){
				result = leftResult;
				System.out.print("left: ");
				for(int i:result){
					System.out.print(i+" ");
				}
			}
			else if (rightResult[2]>=leftResult[2]&&rightResult[2]>=crossResult[2]) {
				result = rightResult;
				System.out.print("right: ");
				for(int i:result){
					System.out.print(i+" ");
				}
			}else{
				result = crossResult;
				System.out.print("cross: ");
				for(int i:result){
					System.out.print(i+" ");
				}
			}
			System.out.println();
			return result;
		}
	}

	//分治过程中用到的辅助函数
	public static int[] FindMaxCrossingSubArray(int[] A,int[] result,int low,int mid,int high){
		int leftSum = 0;
		int curLeftSum = 0;
		int left = 0;
		for(int i = mid; i >= low; i--){
			curLeftSum += A[i];
			if(curLeftSum > leftSum){
				leftSum = curLeftSum;
				left = i;
			}
		}

		int rightSum = 0;
		int curRightSum = 0;
		int right = 0;
		for(int i = mid+1; i <= high; i++){
			curRightSum += A[i];
			if(curRightSum > rightSum){
				rightSum = curRightSum;
				right = i;
			}
		}
		result = getResult(result,left,right,leftSum+rightSum);
		return result;
	}

	//最优解
	public static int[] FindMaxSubArray3(int[] A,int[] result){
		int m;
		int i = 0;//记录起始元素的下标
		int j = 0;//记录终止元素的下标

		/*//记录 上一次maxSum最大时终止元素的下标
		int k = 0;*/
	
		int flag = 0;//记录curSum又一次从负整数变为正整数时起始元素的下标
		int maxSum = 0;//最大子数组和
		int curSum = 0;//当前最大子数组和
		for (m=0;m<A.length ;m++ ) {
			curSum += A[m];
			if(curSum>maxSum){
				//当前最大子数组和较大时，更换起始元素下标
				if (flag != i) {
					i = flag;
				}
				j = m;//更换当前终止元素下标
				maxSum = curSum;

				//更换上一次最大子数组终止元素的下标
				/*if(k!=0||k!=j){
					k++;
				}
				if ((j-k)!=1||j==0){
					k = m;
				}*/
				
			}
			if(curSum<0){
				curSum = 0;
				//记录下一个正整数为起始元素的下标
				if (m<(A.length-1)) {
					if (A[m+1]>0) {
						flag = m+1;
					}
				}
			}
		}
		result = getResult(result,i,j,maxSum);
		return result;
	}

	public static int[] getResult(int[] result,int i,int j,int maxSum){
		result[0] = i;
		result[1] = j;
		result[2] = maxSum;
		return result;
	}
}