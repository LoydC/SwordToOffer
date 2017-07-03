package tech.loyd.offer.ch2;

public class Question3 {
	public boolean Find(int target, int[][] array) {
		boolean found = false;
		if (array != null && array.length > 0 && array[0].length > 0) {
			int i = 0; // 数组的行
			int j = array[0].length - 1; // 数组的列
			while (i < array.length && j >= 0) {
				if (array[i][j] > target) {
					j--;
				} else if (array[i][j] < target) {
					i++;
				} else {
					found = true;
					break;
				}
			}
		}
		return found;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(new Question3().Find(1, matrix));
	}

}
