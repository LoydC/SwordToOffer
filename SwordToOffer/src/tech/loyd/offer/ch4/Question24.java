package tech.loyd.offer.ch4;

public class Question24 {

	public static boolean verifySequenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        // 有数据，就调用辅助方法
        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

	
	private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {

		printSequence(sequence,start,end);
		
		if (start >= end) {
            return true;
        }
		
		int index = start;
        //从左向右找最后一个小于根结点（sequence[end]）的元素的位置
		while (index < end - 1 && sequence[index] < sequence[end]) {
            index++;
        }
        
        //right用于记录第一个不小于根结点的元素的位置
        int right = index;
        //从index向右找最后一个大于根结点（sequence[end]）的元素的位置
        while (index < end - 1 && sequence[index] > sequence[end]) {
            index++;
        }
        
        if (index != end - 1) {
            return false;
        }
        
        index = right;
        return verifySequenceOfBST(sequence, start, index - 1) && verifySequenceOfBST(sequence, index, end - 1);
	}

	private static void printSequence(int[] sequence, int start, int end){
		for(int i=start;i<=end;i++){
			System.out.print(sequence[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//      10
		//    /   \
		//   6     14
		//   /\     /\
		//  4  8  12  16
		int[] data = {4, 8, 6, 12, 16, 14, 10};
		System.out.println("true: " + verifySequenceOfBST(data));
	}
}
