package tech.loyd.offer.ch4;

public class Question20 {
	
	private static void clockwisePrint(int[][] array){
		if(array == null){
			return;
		}
		
		// 记录一圈（环）的开始位置的行
        int x = 0;
        // 记录一圈（环）的开始位置的列
        int y = 0;
        // 对每一圈（环）进行处理，
        // 行号最大是(numbers.length-1)/2
        // 列号最大是(numbers[0].length-1)/2
        while (x * 2 < array.length && y * 2 < array[0].length) {
            printMatrixInCircle(array, x, y);
            // 指向下一个要处理的的环的第一个位置
            x++;
            y++;
        }
		
	}
	
	public static void printMatrixInCircle(int[][] numbers, int x, int y) {
        // 数组的行数
        int rows = numbers.length;
        // 数组的列数
        int cols = numbers[0].length;

        // 输出环的上面一行，包括最中的那个数字
        for (int i = y; i <= cols - y - 1; i++) {
            System.out.print(numbers[x][i] + " ");
        }

        // 环的高度至少为2才会输出右边的一列
        if (rows - x - 1 > x) {
            for (int i = x + 1; i <= rows - x - 1; i++) {
                System.out.print(numbers[i][cols - y - 1] + " ");
            }
        }

        // 环的高度至少是2并且环的宽度至少是2才会输出下面那一行
        if (rows - x - 1 > x && cols - 1 - y > y) {
            for (int i = cols - y - 2; i >= y; i--) {
                System.out.print(numbers[rows - 1 - x][i] + " ");
            }
        }

        // 环的宽度至少是2并且环的高度至少是3才会输出最左边那一列
        if (cols - 1 - y > y && rows - 1 - x > x + 1) {
            for (int i = rows - 1 - x - 1; i >= x + 1; i--) {
                System.out.print(numbers[i][y] + " ");
            }
        }
    }
	
	public static void main(String[] args) {
		int[][] array1 = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };
		clockwisePrint(array1);
		System.out.println();
		
		int[][] array2 = {
                {1, 2, 3, 4, 5, 6, 7, 8}
        };
		clockwisePrint(array2);
		System.out.println();
		
		int[][] array3 = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8}
        };
		clockwisePrint(array3);
		System.out.println();
		
		int[][] array4 = {
				{1}
		};
		clockwisePrint(array4);
		System.out.println();
		
	}
}
