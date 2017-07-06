package tech.loyd.offer.ch3;

/*
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */

public class Question11_1 {

	public static double Power(double base, int exponent) {
        if(exponent == 0){
        	return 1;
        }
        
        double result = 1;
        
        if(exponent > 0){
        	while(exponent !=0){
        		result *= base;
        		exponent--;
        	}
        }else{
        	while(exponent !=0){
        		result *= base;
        		exponent++;
        	}
        	result = 1/result;
        }
        
        return result;
	  }
	
	public static void main(String[] args) {
		
			System.out.println(Power(3, -5));
	}

}
