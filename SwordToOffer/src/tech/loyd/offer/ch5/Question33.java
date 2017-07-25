package tech.loyd.offer.ch5;

public class Question33 {

	/*
	 * 把数组排成最小的数
	 */
	public static String sortArrayToMinNum(int[] array){
		
		sort(array,0,array.length-1);
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<array.length;i++){
			sb.append(array[i]);
		}
		
		return sb.toString();
	} 
	
	/*
	 * 快速排序，改变排序的判断条件
	 */
	private static void sort(int[] array,int start,int end){
		
		if(start < end){
			int temp = array[start];
			int i = start;
			int j = end;
			
			while(i<j){
				while(i<j && (""+temp + array[j]).compareTo(""+array[j] + temp) <= 0 ){
					j--;
				}
				
				if(i<j)
					array[i++] = array[j];
				
				while(i<j && (""+temp + array[i]).compareTo(""+array[i] + temp) >= 0){
					i++;
				}
				
				if(i<j)
					array[j--] = array[i];
				
			}
			array[i] = temp;
			sort(array,start,i-1);
			sort(array,i+1,end);
			
		}

	}
	
	public static void main(String[] args) {
		int[] array = {3,321,32};
		System.out.println(sortArrayToMinNum(array));
	}
}
