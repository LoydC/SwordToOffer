package tech.loyd.offer.ch2;

import java.util.Stack;

/*
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

public class Question7 {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if(stack2.isEmpty()){
			while(!stack1.empty()){
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}else{
			return stack2.pop();
		}
	}

	public static void main(String[] args) {
		Question7 q7 = new Question7();
		q7.push(3);
		q7.push(4);
		q7.push(5);
		System.out.println(q7.pop());
	}

}
