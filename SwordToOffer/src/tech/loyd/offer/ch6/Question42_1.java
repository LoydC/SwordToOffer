package tech.loyd.offer.ch6;

import java.util.ArrayList;

public class Question42_1 {

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
	
	public static String reverseSentence(String str) {
	    char[] data = str.toCharArray();
		
	    reverse(data, 0, data.length - 1);

	    int start = 0;
	    int end = 0;

	    while (start < data.length) {
	        if (data[start] == ' ') {
	            start++;
	            end++;
	        } else if (end == data.length || data[end] == ' ') {
	            reverse(data, start, end - 1);
	            end++;
	            start = end;
	        } else {
	            end++;
	        }
	    }

	    return String.copyValueOf(data);
	}
	
	public static void main(String[] args) {
		String str = "I am a student.";
		System.out.println(reverseSentence(str));
	}
}
