class SquareMatrixMultiply{
	public static void main(String[] args) {
		double[][] A = {
			{1,2},
			{3,4},
			{5,6}
	};
		double[][] B = {
			{1,2,3},
			{4,5,6}
		};
		double[][] C = SquareMatrixMultiply(A,B);
		for (int i=0; i<C.length; i++) {
			for (int j=0; j<C[0].length; j++) {
				System.out.print(C[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static double[][] SquareMatrixMultiply(double[][] A,double[][] B){
		if (A[0].length != B.length) {
			return null;
		}
		double[][] C = new double[A.length][B[0].length];
		for (int i=0; i < A.length; i++) {
			for (int j=0; j<B[0].length; j++) {
				C[i][j] = 0;
				for (int k=0; k<A[0].length; k++) {
					C[i][j] += A[i][k]*B[k][j];
				}
			}
		}
		return C;
	}
}