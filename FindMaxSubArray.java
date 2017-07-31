class FindMaxSubArray{
	public static void main(String[] args) {
		int[] A= {13,-2,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		int[] result = new int[3];
		FindMaxSubArray1(A,result);
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
}