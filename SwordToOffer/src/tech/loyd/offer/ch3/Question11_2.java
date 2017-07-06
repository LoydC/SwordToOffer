package tech.loyd.offer.ch3;

public class Question11_2 {

	public static double Power(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}

		double result;
		if (exponent > 0) {
			result = powerWithUnExpinent(base, exponent);
		} else {
			result = powerWithUnExpinent(base, -exponent);
			result = 1.0 / result;
		}

		return result;
	}

	private static double powerWithUnExpinent(double base, int exponent) {

		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}

		double result = powerWithUnExpinent(base, exponent >> 1);
		result *= result;
		if ((exponent & 0x1) == 1) {
			result *= base;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Power(0.0005,3));
	}
}
