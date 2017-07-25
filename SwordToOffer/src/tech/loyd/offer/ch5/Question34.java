package tech.loyd.offer.ch5;

public class Question34 {
	
	public static int uglyNumOfIndexK(int k){
		
		if(k <= 0)
			return 0;
		
		int[] array = new int[k];
		array[0] = 1;
		int nextNum = 1;
		int multi2 = 0;
		int multi3 = 0;
		int multi5 = 0;
		
		while(nextNum < k){
			
			array[nextNum] = Math.min(Math.min(array[multi2] * 2, array[multi3] * 3),array[multi5] * 5);
			
			while(array[multi2] * 2 <= array[nextNum]){
				multi2++;
			}
			while(array[multi3] * 3 <= array[nextNum]){
				multi3++;
			}
			while(array[multi5] * 5 <= array[nextNum]){
				multi5++;
			}
			nextNum++;
		}
		
		return array[nextNum-1];
	}
	
	public static void main(String[] args) {
		System.out.println(uglyNumOfIndexK(11));
	}
}
