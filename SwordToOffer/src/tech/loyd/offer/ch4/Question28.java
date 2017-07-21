package tech.loyd.offer.ch4;

public class Question28 {

	private static void printFullArrangement(char[] str){
		
		if(str != null && str.length > 0){
			printFullArrangement(str,0);
		}
		return;
	}
	
	private static void printFullArrangement(char[] str,int start){
		if(start == str.length-1){
			System.out.println(String.copyValueOf(str));
		}else{
			char temp;
			for(int i=start;i<str.length;i++){
				
				//那当前字符和后面的逐个交换
				if(start != i){
					temp = str[start];
					str[start] = str[i];
					str[i] = temp;
				}
				
				printFullArrangement(str,start+1);
				
				//再变为原始序列
				if(start != i){
					temp = str[i];
					str[i] = str[start];
					str[start] = temp;
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		char[] chars1 = {'a','b','c'};
		printFullArrangement(chars1);
		
		char[] chars2 = {'a','b','c','d'};
		printFullArrangement(chars2);
	}

}
