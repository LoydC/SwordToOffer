package tech.loyd.offer.ch2;

public class Question8_1 {

    public static int minNumberInRotateArray(int [] array) {
        int min = 0;
    	if(array == null)
    		return 0;
    	
    	int i=0;
    	int j = array.length-2;
    	while(array[i]>array[j] || array[j] <= array[array.length-1]){
    		min = Math.min(array[i], array[j]);
    		i++;
    		j--;
    	}
    	return min;
    }
	
	public static void main(String[] args) {
		int [] array ={0,1,1,1,1};
		System.out.println(minNumberInRotateArray(array));
	}

}
