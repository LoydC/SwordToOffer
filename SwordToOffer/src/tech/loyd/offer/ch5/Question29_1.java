package tech.loyd.offer.ch5;

public class Question29_1 {
	private static int findNumMoreThanHalf(int[] array) {
		if (array == null)
			return -1;
		if (array.length == 1)
			return array[0];

		int num = array[0];
		int count = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == num) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				count = 1;
				num = array[i];
			}
		}

		return isMoreThanHalf(array,num) ? num : -1;
	}

	/*
	 * 验证传入的数的个数是否超过一半
	 */
	private static boolean isMoreThanHalf(int[] array,int num){
		int count = 0;
		
		for(int i=0;i<array.length;i++){
			if(array[i] == num){
				count++;
			}
		}
	
		return count>array.length/2 ? true : false;
	} 
	
	public static void main(String[] args) {
		
		int[] array1 = {1,2,3,2,2,2,5,4,2};
		int[] array2 = {1,2,3,2,2,2,5,4,2,1};
		int[] array3 = {1,2,2,1};
		int[] array4 = {2,1,2,1,2};
		
		System.out.println(findNumMoreThanHalf(array1));
		System.out.println(findNumMoreThanHalf(array2));
		System.out.println(findNumMoreThanHalf(array3));
		System.out.println(findNumMoreThanHalf(null));
		System.out.println(findNumMoreThanHalf(array4));
	}
}
