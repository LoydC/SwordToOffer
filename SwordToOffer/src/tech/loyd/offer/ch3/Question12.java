package tech.loyd.offer.ch3;

public class Question12 {

    public static void printOneToNthDigits(int n) {  
        // 输入的数字不能为小于1  
        if (n < 1) {  
            throw new RuntimeException("The input number must larger than 0");  
        }  
        // 创建一个数组用于打存放值  
        int[] arr = new int[n];  
        printOneToNthDigits(0, arr);  
    }  
  
    public static void printOneToNthDigits(int n, int[] arr) {  
  
        // 说明所有的数据排列选择已经处理完了  
        if (n >= arr.length) {  
            // 可以输入数组的值  
            printArray(arr);  
        } else {  
            // 对  
            for (int i = 0; i <= 9; i++) {  
                arr[n] = i;  
                printOneToNthDigits(n + 1, arr);  
            }  
        }  
    }  
  
    public static void printArray(int[] arr) {  
        // 找第一个非0的元素  
        int index = 0;  
        while (index < arr.length && arr[index] == 0) {  
            index++;  
        }  
  
        // 从第一个非0值到开始输出到最后的元素。  
        for (int i = index; i < arr.length; i++) {  
            System.out.print(arr[i]);  
        }  
        // 条件成立说明数组中有非零元素，所以需要换行  
        if (index < arr.length) {  
            System.out.println();  
        }  
    }  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        printOneToNthDigits(5);  
	}

}
