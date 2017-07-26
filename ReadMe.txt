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

