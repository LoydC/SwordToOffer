package tech.loyd.offer.ch6;

import java.util.Arrays;

public class Question44 {
	public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }

        // 对元素进行排序
        Arrays.sort(numbers);
        
        int numberOfZero = 0;
        int numberOfGap = 0;
        
        // 求出王的个数
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numberOfZero++;
        }

        int small = numberOfZero;
        int big = small + 1;

        // 求出相邻数字之间的空缺总数
        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }

            numberOfGap += (numbers[big] - numbers[small] - 1);
            small = big;
            big++;
        }

        return numberOfGap <= numberOfZero;
    }


    public static void main(String[] args) {
    	
        int[] numbers1 = {1, 3, 2, 5, 4};
        System.out.println(isContinuous(numbers1));
        int[] numbers2 = {1, 3, 2, 6, 4};
        System.out.println(isContinuous(numbers2));
        int[] numbers3 = {0, 3, 2, 6, 4};
        System.out.println(isContinuous(numbers3));
        int[] numbers4 = {0, 3, 1, 6, 4};
        System.out.println(isContinuous(numbers4));
        int[] numbers5 = {1, 3, 0, 5, 0};
        System.out.println(isContinuous(numbers5));
        
    }
}
