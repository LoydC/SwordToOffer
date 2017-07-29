package tech.loyd.offer.ch5;

public class Question38 {

	public static int getTimesOfK(int[] array,int k){
		int number = 0;
        if (array != null && array.length > 0) {
            int first = getFirstK(array, k, 0, array.length - 1);
            int last = getLastK(array, k, 0, array.length - 1);

            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }

        return number;
	}
	
	public static int getFirstK(int[] array,int k,int start,int end){
		
		if(array == null || array.length < 1 || start > end)
			return -1;
		
		int midIdx = start + (end-start)/2;
		int midData = array[midIdx];
		
		if(k == midData){
			if(midIdx>0 && array[midIdx-1] != k || midIdx == 0){
				return midIdx;
			}else{
				end = midIdx -1;
			}
		}else if( midData > k){
			end = midIdx-1;
		}else{
			start = midIdx+1;
		}
		
		return getFirstK(array, k, start, end);
	}
	
	public static int getLastK(int[] array,int k,int start,int end){
		
		if(array == null || array.length < 1 || start > end)
			return -1;
		
		int midIdx = start + (end-start)/2;
		int midData = array[midIdx];
		
		if(k == midData){
			if(midIdx+1<array.length && array[midIdx+1] != k || midIdx == array.length-1){
				return midIdx;
			}else{
				start = midIdx + 1;
			}
		}else if( midData > k){
			end = midIdx-1;
		}else{
			start = midIdx+1;
		}
		
		return getLastK(array, k, start, end);
	}
	
	public static void main(String[] args) {
		// 查找的数字出现在数组的中间
        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getTimesOfK(data1, 3)); // 4

        // 查找的数组出现在数组的开头
        int[] data2 = {3, 3, 3, 3, 4, 5};
        System.out.println(getTimesOfK(data2, 3)); // 4

        // 查找的数组出现在数组的结尾
        int[] data3 = {1, 2, 3, 3, 3, 3};
        System.out.println(getTimesOfK(data3, 3)); // 4

        // 查找的数字不存在
        int[] data4 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getTimesOfK(data4, 2)); // 0
	}

}
