package tech.loyd.offer.ch5;

import java.util.Arrays;

public class Question30_1 {

	private static int[] minTopK(int[] array, int k) {

		int start = 0;
		int end = array.length-1;
		int index = adjustPosition(array, start, end);

		while (index != k) {
			if (index < k) {
				start++;
			} else {
				end--;
			}
			index = adjustPosition(array, start, end);
		}

		return Arrays.copyOfRange(array, 0, k);
	}

	/*
	 * 调整序列的第一个元素的位置，使得左边的元素都比它小，右边的元素都比它大
	 * 
	 * @return 返回调整后的位置
	 */
	private static int adjustPosition(int[] array, int start, int end) {
		int temp = array[start];
		int i = start;
		int j = end;

		while (i < j) {
			while (i < j && array[j] >= temp)
				j--;

			if (i < j)
				array[i++] = array[j];

			while (i < j && array[i] <= temp)
				i++;

			if(i < j)
				array[j--] = array[i];

		}

		array[i] = temp;
		return i;
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
