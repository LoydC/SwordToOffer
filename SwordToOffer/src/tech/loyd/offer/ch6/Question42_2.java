package tech.loyd.offer.ch6;

import java.util.ArrayList;

public class Question42_2 {

	public static void reverse(char[] data, int start, int end) {
	    if (data == null || data.length < 1 || start < 0 || end > data.length || start > end) {
	        return;
	    }

	    while (start < end) {
	        char tmp = data[start];
	        data[start] = data[end];
	        data[end] = tmp;

	        start++;
	        end--;
	    }
	}
	
	public static String reverseSeentenceWithK(String str,int k) {
	    char[] data = str.toCharArray();
		
	    if(k<1 && k > data.length)
	    	return "";
	    
	    reverse(data, 0, k-1);
	    reverse(data,k,data.length-1);
	    reverse(data,0,data.length-1);
	    
	    return String.copyValueOf(data);
	}
	
	public static void main(String[] args) {
		String str = "abcdefg";
		System.out.println(reverseSeentenceWithK(str,2));
	}
}
