package tech.loyd.offer.ch6;

public class Question47 {

	public static int add(int x, int y) {
        int sum;
        int carry;

        do {
        	//异或，相同为0，不同为1
            sum = x ^ y;
            // x&y的某一位是1说明，它是它的前一位的进位，所以向左移动一位
            carry = (x & y) << 1;

            x = sum;
            y = carry;
        } while (y != 0);

        return x;
    }


    public static void main(String[] args) {
        //System.out.println(add(1, 2) + ", " + (1 + 2));
        System.out.println(add(17, 31)+ ", " + (13 + 34));
    }
    
}
