package tech.loyd.offer.ch6;

import java.util.ArrayList;

public class Question41_1 {

	public static ArrayList<Integer> findResultAddEqualSum(int[] array, int sum) {
		ArrayList<Integer> result = new ArrayList<Integer>(2);

		if (array == null || array.length < 2) {
			return result;
		}

		int ahead = array.length - 1;
		int behind = 0;
		long curSum; // 统计和，取long是防止结果溢出

		while (behind < ahead) {
	        curSum = array[behind] + array[ahead];

	        if (curSum == sum) {
	            result.add(array[behind]);
	            result.add(array[ahead]);
	            break;
	        } else if (curSum < sum) {
	            behind++;
	        } else {
	            ahead--;
	        }
	    }
		
		return result;
	}

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,8};
		ArrayList<Integer> result = findResultAddEqualSum(array,11);
		for(int i : result){
			System.out.println(i);
		}

	}

}
