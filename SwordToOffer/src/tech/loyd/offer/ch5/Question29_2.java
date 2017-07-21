package tech.loyd.offer.ch5;

public class Question29_2 {

	private static int findNumMoreThanHalf(int[] array){
		
		if(array == null)
			return -1;
		if(array.length == 1)
			return array[0];
		
		//获取中位数
		int start = 0;
		int end = array.length -1;
		
		int index = findMid(array,start,end);
		
		while(index != array.length/2){
			
			if(index > array.length/2){
				end = index-1;
			}else{
				start = index+1;
			}
			index = findMid(array,start,end);
		}
		
		//验证该中位数的个数是否超过一半
		
		return isMoreThanHalf(array,array[index]) ? array[index] : -1;
	}
	
	/*
	 * 递归找到中位数，返回的是array[start]排序后的位置
	 */
	private static int findMid(int[] array,int start,int end){
		int mid = array[start];
		int i= start;
		int j = end;
		
		while(i< j){
			while(i < j &&array[j] >= mid)
				j--;
			
			if(i<j){
				array[i++] = array[j];
			}
			
			while(i < j &&array[i] <= mid)
				i++;
			
			if(i<j){
				array[j--] = array[i];
			}
			
		}
		array[i] = mid;
		return i;
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
		
		System.out.println(findNumMoreThanHalf(array1));
		System.out.println(findNumMoreThanHalf(array2));
		System.out.println(findNumMoreThanHalf(array3));
		System.out.println(findNumMoreThanHalf(null));
	}

}
