package tech.loyd.offer.ch5;

public class Question31 {

	private static int largestSubArray(int[] array){
		if(array == null)
			return 0;
		
		int tempSum = 0;
		int returnSum = Integer.MIN_VALUE;
		
		for(int i=0;i<array.length;i++){
			if(tempSum <= 0){
				tempSum = array[i];
			}else{
				tempSum += array[i];
			}
			
			if(tempSum > returnSum){
				returnSum = tempSum;
			}
		}
		
		return returnSum;
	}
	
	public static void main(String[] args) {
		int[] arary1 = {1,3,-1,4,2,-10,9,7};
		System.out.println(largestSubArray(arary1));
		
		int[] array2 = {-1,-3,-1};
		System.out.println(largestSubArray(array2));
	}

}
