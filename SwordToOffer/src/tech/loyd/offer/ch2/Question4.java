package tech.loyd.offer.ch2;

/*
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Question4 {
    public String replaceSpace(StringBuffer str) {
    	
    	char[] array = str.toString().toCharArray();
    	int count = 0;
    	
    	for(int i=0;i<array.length;i++){
    		if(array[i] == ' '){
    			count++;
    		}
    	}
    	
    	char[] newArray = new char[array.length+2 * count];
    	
    	int newIndex = newArray.length - 1; 
    	
    	for(int i=array.length-1;i>=0;i--){
    		if(array[i] != ' '){
    			newArray[newIndex] = array[i];
    			newIndex--;
    		}else{
    			newArray[newIndex--] = '0';
    			newArray[newIndex--] = '2';
    			newArray[newIndex--] = '%';
    		}
    	}
    	
    	return String.copyValueOf(newArray);
    }
    
    public static void main(String[] args) {

		StringBuffer sb = new StringBuffer(" we are happy   .");
		System.out.println(new Question4().replaceSpace(sb));

	}
}
