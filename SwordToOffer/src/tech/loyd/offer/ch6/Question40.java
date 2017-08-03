package tech.loyd.offer.ch6;

public class Question40 {
	
	public static int[] findNumAppearanceOnce(int[] data){
		int[] result = {0,0};
		
		if(data == null || data.length < 2){
			return result;
		}
		
		int xor = 0;
		for(int i: data)
			xor ^= i;
		
		int n = 0;
		while ((xor & 1) == 0 && xor < 32) {
			//无符号右移
			xor >>>= 1;
            n++;
        }
		
		for(int i:data){
			if(isBit1(i,n)){
				result[0] ^= i;
			}else{
				result[1] ^= i;
			}
		}
		
		return result; 
	}
	
    private static boolean isBit1(int num, int indexBit) {
        num >>>= indexBit;
        return (num & 1) == 1;
    }
	
	public static void main(String[] args) {
		int[] data = {2,4,3,6,3,2,5,5};
		int[] result = findNumAppearanceOnce(data);
		System.out.println(result[0] + " " + result[1]);
		
	}

}
