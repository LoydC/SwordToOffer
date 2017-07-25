package tech.loyd.offer.ch5;

public class Question32 {
	
	public static int numberOf1Between1AndN(int n){
		
		if(n <= 0)
			return 0;
		
		String s = n + "";
		int[] array = new int[s.length()];
		for(int i=0;i<s.length();i++){
			array[i] = s.charAt(i) - '0';
		}
		
		return numberOf1(array,0);
	}
	
	/*
	 * 求0到当前位置表示的数字中1的个数
	 * 若array为{1,2,3,4,5} curIdx为2，则表示数字345
	 * 
	 * @param array 数字转的数组
	 * @param curIdx 当前位置
	 * 
	 */
	private static int numberOf1(int[] array,int curIdx){
		
		if (array == null || curIdx >= array.length || curIdx < 0) {
            return 0;
        }
		
		int first = array[curIdx];
		int length = array.length - curIdx;
		
		// 如果只有一位且这一位是0返回0
        if (length == 1 && first == 0) {
            return 0;
        }
		
        //若数字为21345，则numFirstDigit表示10000-19999的个数
        int numFirstDigit = 0;
        //numOtherDigits是[1346, 21345]中，除了第一位之外（不看21345中的第一位2）的数位中的1的数目
        int numOtherDigits;
        //numRecursive是递归计算[1-1234]中1的的数目
        int numRecursive;
        
		if(first > 1){
			numFirstDigit = (int)Math.pow(10, length-1);
		}else if(first == 1){
			for(int i = curIdx+1;i<array.length;i++){
				numFirstDigit = numFirstDigit * 10 + array[i];
			}
			numFirstDigit++;
		}
		
		numOtherDigits = first * (length-1) * (int)Math.pow(10, length-2);
		numRecursive = numberOf1(array,curIdx+1);
		
		return numFirstDigit + numOtherDigits + numRecursive;
	}
	
	public static void main(String[] args) {
		System.out.println(numberOf1Between1AndN(1));
		System.out.println(numberOf1Between1AndN(6));
		System.out.println(numberOf1Between1AndN(10));
		System.out.println(numberOf1Between1AndN(11));
		System.out.println(numberOf1Between1AndN(92));
		System.out.println(numberOf1Between1AndN(21345));
	}
}
