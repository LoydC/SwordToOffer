package tech.loyd.offer.ch2;

/*
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 */

public class Question9_2 {
	public static int Fibonacci(int n){
		if(n==0) return 0;
		if(n==1) return 1;
		int left =0,right =1,fib=0;
		if(n>1){
			for(int i=1;i<n;i++){
				fib = left+right;
				left =right;
				right = fib;
			}
		}
		return fib;
	}
}
