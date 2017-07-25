package tech.loyd.offer.ch5;

public class Question30_2 {
	
	private static int[] minTopK(int[] array, int k) {
		if (array == null || array.length < k)
			return null;

		int[] arrayK = new int[k];

		for (int i = 0; i < array.length; i++) {
			if (i < k) {
				arrayK[i] = array[i];
				//建大顶堆
				if (i == k - 1) {
					arrayK[i] = array[i];
					for (int j = arrayK.length / 2 - 1; j >= 0; j--) {
						adjustHeapPosition(arrayK, j, arrayK.length);
					}
				}
			} else {
				if (array[i] < arrayK[0]) {
					arrayK[0] = array[i];
					//重新调整堆的位置
					adjustHeapPosition(arrayK, 0, arrayK.length);
				}
			}

		}

		return arrayK;
	}

	/*
	 * 构建大顶堆
	 * 
	 * @param array为带调整的序列
	 * 
	 * @param i 当前调整的位置
	 * 
	 * @param n 序列的逻辑长度
	 */
	private static void adjustHeapPosition(int[] array, int i, int n) {
		int child;
		int temp;

		for (temp = array[i]; i * 2 + 1 < n; i = child) {
			child = i * 2 + 1;
			if (child != n - 1 && array[child] < array[child + 1])
				child++;
			if (temp < array[child])
				array[i] = array[child];
			else
				break;
		}
		array[i] = temp;
	}

	private static void printTopK(int[] array) {
		if (array == null)
			return;

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = { 163, 221, 563, 342, 317, 359, 323, 954, 212, 317, 133, 422, 452, 82 };
		printTopK(minTopK(array, 3));
	}

}
