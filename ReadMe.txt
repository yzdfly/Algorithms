目录：
	1.InsertionSort直接插入排序
	2.MergeSort归并排序

1.InsertionSort 直接插入排序
排序思想：
	相当于一堆数字，一开始先取出2个数排序，2个数排好序之后，再从一堆数字里面取一个数排序，直到结束
伪代码：
	INSERTION_SORT(A)
	for j = 2 to A.length
		key = A[j]
		//Insert A[j] into sorted sequence A[1...j-1].
		i = j - 1
		while i>0 and A[i]>key
			A[i+1] = A[j]
			i = i - 1
		A[i + 1] = key 


2.MergeSort 归并排序
排序思想：1，分解待排序的n个元素为两个子列，各为n/2个元素
		  2，若子列没有排好序，重复1步骤，每个子列继续分解为两个子列，直至被分解的子列个数为1
		  3，子列元素个数为1，说明这个子列已经排好序，开始逐级合并子序列进行排序

该算法需要合并分解的子序列，所以需要额外一个辅助过程Merge(A,p,q,r)来完成两个子列的合并，A为数组，p,q,r为数组下标，其中A[p,q]和A[q+1,r]为两个已经排好序的子序列，∞代表哨兵值。
Merge伪代码：
	Merge(A,p,q,r)
	n1 = q - p + 1
	n2 = r - q
	let L[1..n1+1] and R[1..n2+1] be new arrays
	for i = 1 to n1
		L[i] = A[p+i-1]
	for j = 1 to n2
		R[j] = a[q+j]
	L[n1+1] = ∞
	R[n2+1] = ∞
	i = 1
	j = 1
	for k = p to r
		if L[i] <= R[j]
			A[k] = L[i]
			i = i + 1
		else 
			A[k] = R[j]
			j = j + 1

MergeSort(归并排序)伪代码:
	MergeSort(A,p,r)
	if p < r
		q = (p+r)/2
		MergeSort(A,p,q)
		MergeSort(A,q+1,r)
		Merge(A,p,q,r)


3.一个最大子数组
实现内容：
	假如有这样一个数组，A[] = {13,-2,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};要求得到一个总值最大的子数组。例如A[]的一个最大子数组为A[7..10]={18,20,-7,12}。

求解思想:
	1）暴力求解
		循环每一个元素，并从每一个元素的下标开始累加，每次选取较大的和。例如从第一个元素开始，第一次累加是13，那么记录最大的maxSubArray为13；第二次累加为13-2=11，比13小，maxSubArray还是为13；然后继续累加，选择最大的maxSubArray;最后循环下一个元素。A为输入数组，n起始元素下标,m终止元素下标,maxSum为最大子数组的和
	   伪代码：
	   FindMaxSubArray(A)
	   maxSum=0
	   for i = 1 to A.length
	   		let curSum = 0
	   		for j = i to A.length
	   			curSum = curSum + A[j]
	   			if curSum > maxSum
	   				maxSum = curSum
	   				let n = i,m = j
	   	return i,j,maxSum
		
	2）分治思想
	3）最优解