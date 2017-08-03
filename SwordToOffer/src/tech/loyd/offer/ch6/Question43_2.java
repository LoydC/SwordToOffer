package tech.loyd.offer.ch6;

public class Question43_2 {
	
	private static final int MAX = 6;//骰子的最大点数

    public static void printProbability(int number) {
        if (number < 1) {
            return;
        }

        int[][] probabilities = new int[2][MAX * number + 1];
        for (int i = 0; i < MAX * number + 1; i++) {
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }

        // 标记当前要使用的是第0个数组还是第1个数组
        int flag = 0;

        for (int i = 1; i <= MAX; i++) {
            probabilities[flag][i] = 1;
        }

        // 抛出其它骰子
        for (int k = 2; k <= number; k++) {
            // 如果抛出了k个骰子，那么和为[0, k-1]的出现次数为0
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;
            }

            // 抛出k个骰子，所有和的可能
            for (int i = k; i <= MAX * k; i++) {
                probabilities[1 - flag][i] = 0;

                // 每个骰子的出现的所有可能的点数
                for (int j = 1; j <= i && j <= MAX; j++) {
                    // 统计出和为i的点数出现的次数
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }

            flag = 1 - flag;
        }


        double total = Math.pow(MAX,number);
		
		for (int i = number; i <= number * MAX; i++) {
            double ratio = probabilities[flag][i] / total;
            System.out.println("出现" + i + "的概率为：" + ratio); 
        }
    }
	
	public static void main(String[] args) {
		printProbability(2);
	}
}
