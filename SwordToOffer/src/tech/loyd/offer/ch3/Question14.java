package tech.loyd.offer.ch3;

public class Question14 {

	private static int[] resort(int[] array){
		if(array==null || array.length == 1){
			return array;	
		}
		int front = 0;
		int end = array.length-1;
		
		while(front < end){
			if(array[front] % 2 == 0){
				while(array[end] % 2 == 0){
					end--;
				}
				
				if(end <= front){
					break;
				}else{
					int temp = array[front];
					array[front] = array[end];
					array[end] = temp;
					front++;
					end--;
				}
			}else{
				front++;
			}
		}
		
		return array;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,3,6,5,4,2,8,9,0};
		
		array = resort(array);
		
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}
