# 정렬

### 퀵 정렬
- (분할) Pivot을 기준으로  두개의 비균등한 크기로 분할하고 
- (정복) 분할된 부분 배열을 정렬 
- (결합) 두개의 정렬된 부분 배열을 합한다.
- 재귀 호출을 사용하여 항목 정렬
- 배열 안에 정렬할 항목이 1개이거나 없다면 리턴
- 배열 안의 항목을 기준(Pivot)으로 선택
- 배열 기준보다 큰 항목과 작은 항목 두 부분으로 나눔
- 원본 배열 두 반쪽에 대해 알고리즘 재귀적 반복
- 복잡도
  - 최악: O(n^2)
  - 최선: O(nlog₂n)
  - 평균: O(nlogn)
````
quicksort(int A[], int low, int high) {
	int pivot;
	if (high > low) {
		pivot = partition(A, low, high);
		quicksort(A, low, pivot-1);
		quicksort(A, pivot +1, high);
	}
}

int partition(int A, int low, int high) {
	int left, right, pivot_item = A[low];
	left = low;
	right = high;
	while (left < right) {
		while (A[left] <= pivot_item)
			left++;
		while (A[right] > pivot_item)
			right--;
		if (left < right)
			swap(A, left, right);
	}

	A[low] = A[right];
	A[right] = pivot_item;

	return right;
}
````

## 삽입 정렬
- 배열의 한 원소 key를 가지고 있고, key를 알맞는 순서에 삽입
- key보다 큰 값은 하나씩 밀어내고, key보다 작은 값은 뒤에 삽입
- 입력 배열이 선정렬(완전하지 않아도)되어있는 경우 효율적인 정렬
- 복잡도
  - 최악: O(n^2)
  - 최선: O(n^2)
  - 평균: O(n^2)
 ````
 void insertionSort(int A[], int size) {
 	int i, j, key;
 	for (int = 1; i < size; i++) {
 		key = A[i];
 		j = i - 1;
 		while(A[j] > key && j >= 0) {
 			A[j + 1] = A[j];
 				j--;
 		}
 		A[j + 1] = key;
 	}
 }
 ````

## 합병 정렬
- 병합: 두 개의 정렬된 파일을 합쳐서 하나의 큰 정렬된 파일을 만드는 과정
- 선택: 파일을 두 부분 k개 작은 항목들, n-k개 큰 항목으로 나누는 과정
- (분할) 입력 배열을 같은 크기 2개의 부분 배열로 분할
- (정복) 부분 배열을 정렬, 부분 배열의 크기가 충분히 작지 않다면 재귀호출로 다시 분할 정복 적용
- (결합) 정렬된 부분 배열을 하나로 합병
- 복잡도
  - 최악: O(nlog₂n)
  - 최선: O(nlog₂n)
  - 평균: O(nlog₂n)

### 버블 정렬
- 첫 번째 항목부터 마지막까지 입력 배열을 반복
- 각 항목 쌍을 비교하고 필요하면 교환하는 동작
- 교환이 필요 없을 때까지 반복
- n-1, n-2, ..., 2, 1 = n(n-1)/2
- 복잡도
  - 최악: O(n^2)
  - 최선: O(n)
  - 평균: O(n^2)
````
void bubbleSort(int A [], int n) {
	for(int pass = n - 1; pass >= 0; pass--) {
		for (int i = 0; i < pass - 1; i++) {
			if (A[i] > A[i+1]) {
				int temp = A[min];
				A[i] = A[i + 1];
				A[i + 1] = temp;
			}
		}
	}
}
````

### Java Sorting
- Java Arrays.sort()
 - Dual-Pivot Quick Sort 사용
 - 피봇을 2개 사용하여, 3개 구간을 만들고 Quick Sort 진행
 - 랜덤 데이터에 대해 평균적으로 Quick Sort보다 좋은 성능을 가진다고 함
- Collections.sort
 - Tim 정렬
 - Insertion + Merge 결합 정렬
 - Java 7에서 채택
- 정렬 알고리즘이 다른 이유
  - 참조 지역성 원리 (Local of Reference): 동일한 값 또는 해당 값 근처에 있는 스토리지 위치가 자주 액세스되는 특성
  - 정렬 동작 시간: C * 시간복잡도 + a
    - C: 참조 지역성 영향받음
  - Array는 메모리적으로 각 값이 연속적인 주소를 가지고 있어, C 값이 낮음
    그래서 참조 지역성이 좋은 Quick Sort 사용하여 충분한 성능 제공
  - Collection은 메모리가 산발적인 LinkedList 등의 자료형도 함께 존재하고 있음
    그래서 참조 인접성이 좋지 않고 C 값이 상대적으로 높음
    Tim Sorting이 상대적으로 좋은 성능 제공
- Tim Sort: https://d2.naver.com/helloworld/0315536