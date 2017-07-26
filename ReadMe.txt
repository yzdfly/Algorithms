目录：
	1.InsertionSort直接插入排序
	2.MergeSort归并排序

1,InsertionSort 直接插入排序
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

2,MergeSort 归并排序
排序思想：1，分解待排序的n个元素为两个子列，各为n/2个元素
		  2，若子列没有排好序，重复一步骤，每个子列继续分解，直至被分解的子列个数为1
		  3，子列元素个数为1，说明这个子列已经排好序，开始逐级合并子序列进行排序

该算法需要合并分解的子序列，所以需要额外一个辅助过程Merge(A,p,q,r)来完成两个子列的合并，A为数组，p,q,r为数组下标，其中A[p,q]和A[q+1,r]为两个已经排好序的子序列，∞代表哨兵值。
Merge伪代码：
	Merge(A,p,q,r)
	n1 = q - p + 1
	n2 = r - q
	let L[1..n1+1] and R[1..n2+1] be new arrays