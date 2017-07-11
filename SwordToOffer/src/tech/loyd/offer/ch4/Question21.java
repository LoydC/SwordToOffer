package tech.loyd.offer.ch4;

import java.util.Stack;

public class Question21 {

	private static class MinStack<AnyType extends Comparable<? super AnyType>>{
		
		private Stack<AnyType> dataStack;
		private Stack<AnyType> minStack;
		
		public MinStack(){
			dataStack = new Stack<AnyType>();
			minStack = new Stack<AnyType>();
		}
		
		public AnyType pop(){
			if(!dataStack.empty()){
				minStack.pop();
				return dataStack.pop();
			}else{
				throw new RuntimeException("the stack is empty");
			}
		}
		
		public void push(AnyType x){
			AnyType min;
			if(dataStack.isEmpty()){
				min = x;
			}else{
				min = minStack.peek();
				if(min.compareTo(x) >= 0){
					min = x;
				}
			}
			dataStack.push(x);
			minStack.push(min);
		}
		
		public AnyType getMin(){
			return minStack.peek();
		}
	}
	
	public static void main(String[] args) {
		MinStack<Double> stack = new MinStack<Double>();
		stack.push(12.3);
		System.out.println(stack.getMin());
		stack.push(2.8);
		System.out.println(stack.getMin());
		stack.push(2.9);
		System.out.println(stack.getMin());
		stack.push(7.6);
		System.out.println(stack.getMin());
		stack.push(0.0);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}

}
