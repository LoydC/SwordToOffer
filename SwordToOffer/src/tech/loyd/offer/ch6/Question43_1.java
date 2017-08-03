package tech.loyd.offer.ch6;

public class Question43_1 {
	
	private static final int MAX = 6;//骰子的最大点数

	public static void printProbability(int num) {
		if(num < 1)
			return;
		
		int maxSum = num * MAX;
		int[] probabilities = new int[maxSum - num + 1];
		
		probability(num, probabilities);
		
		double total = Math.pow(MAX,num);
		
		for (int i = num; i <= maxSum; i++) {
            double ratio = probabilities[i - num] / total;
            System.out.println("出现" + i + "的概率为：" + ratio); 
        }
		
	}
	
    /**
     * @param number        色子个数
     * @param probabilities 不同色子数出现次数的计数数组
     */
	private static void probability(int number, int[] probabilities) {
        for (int i = 1; i <= MAX; i++) {
            probability(number, number, i, probabilities);
        }
    }
	
    /**
     * @param original      总的色子数
     * @param current       剩余要处理的色子数
     * @param sum           已经前面的色子数和
     * @param probabilities 不同色子数出现次数的计数数组
     */
	private static void probability(int original, int current, int sum, int[] probabilities) {
        if (current == 1) {
            probabilities[sum - original]++;
        } else {
            for (int i = 1; i <= MAX; i++) {
                probability(original, current - 1, i + sum, probabilities);
            }
        }
    }
	
	public static void main(String[] args) {
		printProbability(2);
	}
}
