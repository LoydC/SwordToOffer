package tech.loyd.offer.ch4;

import java.util.Stack;

public class Question22 {

	/*
	 * A为进栈顺序，判断B是否是正确的出栈顺序
	 */
	private static boolean isCorrectOutSequence(int[] A,int[] B){
		if(A == null ||B == null ||A.length==0||B.length==0||A.length != B.length)
			return false;

		// 用于存放入栈时的数据
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        // 如果还有出栈元素要处理
        while (popIndex < B.length) {
            // 入栈元素还未全部入栈的条件下，如果栈为空，或者栈顶的元素不与当前处理的相等，则一直进行栈操作，
            // 直到入栈元素全部入栈或者找到了一个与当出栈元素相等的元素
            while (pushIndex < A.length && (stack.isEmpty() || stack.peek() != B[popIndex])) {
                stack.push(A[pushIndex]);
                pushIndex++;
            }

            // 如果在上一步的入栈过程中找到了与出栈的元素相等的元素
            if (stack.peek() == B[popIndex]) {
                stack.pop();
                popIndex++;
            }
            // 如果没有找到与出栈元素相等的元素，说明这个出栈顺序是不合法的
            else {
                return false;
            }
        }
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		int[] B1 = {4, 5, 3, 2, 1};
        int[] B2 = {3, 5, 4, 2, 1};
        int[] B3 = {4, 3, 5, 1, 2};
        int[] B4 = {3, 5, 4, 1, 2};


		System.out.println(isCorrectOutSequence(A,B1));
		System.out.println(isCorrectOutSequence(A,B2));
		System.out.println(isCorrectOutSequence(A,B3));
		System.out.println(isCorrectOutSequence(A,B4));
	}

}
