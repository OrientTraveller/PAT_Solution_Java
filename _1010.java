package PATFoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class _1010 {

	public static int cal(int[] num, int radix) {
		int current = 0;
		int value = 0;
		for (int i = num.length - 1; i >= 0; i--) {
			if (num[i] >= radix)
				value = -1;
			else {
				value = (int) (value + num[i] * Math.pow(radix, current));
				current++;
			}
		}
		return value;
	}

	public static void check(int[] num, int value) {
		int radix = -1;
		int current = 0;
		int sum = 0;
		for (int i = 2; i <= 36; i++) {
			for (int j = num.length - 1; j >= 0; j--) {
				if (num[j] >= i)
					break;
				else {
					sum = (int) (sum + num[j] * Math.pow(i, current));
					current++;
				}
			}
			current = 0;
			if (sum == value) {
				radix = i;
				break;
			} else {
				sum = 0;
			}
		}
		if (radix == -1)
			System.out.print("Impossible");
		else
			System.out.print(radix);
	}

	public static int[] convert(char[] str) {
		int[] value = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			if ((int) str[i] <= 57) {
				value[i] = (int) str[i] - '0';
			} else {
				value[i] = (int) str[i] - 87;
			}
		}
		return value;
	}

	public static char[] delete(char[] ori) {
		if (ori[0] != '-')
			return ori;
		else {
			char[] result = new char[ori.length - 1];
			for (int i = 1; i < ori.length; i++) {
				result[i - 1] = ori[i];
			}
			return result;
		}
	}

	public static void main(String[] args) throws IOException {
		String[] str = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split(" ");
		char[] str1 = str[0].toCharArray();
		char[] str2 = str[1].toCharArray();
		if ((str1[0] == '-' && str2[0] != '-') || (str1[0] != '-' && str2[0] == '-'))
			System.out.print("Impossible");
		else {
			int[] num1 = convert(delete(str1));
			int[] num2 = convert(delete(str2));
			int tag = Integer.parseInt(str[2]);
			int radix = Integer.parseInt(str[3]);
			br.close();
			int value = 0;
			if (tag == 1) {
				value = cal(num1, radix);
				if (value == -1)
					System.out.print("Impossible");
				else {
					check(num2, value);
				}
			} else {
				value = cal(num2, radix);
				if (value == -1)
					System.out.print("Impossible");
				else {
					check(num1, value);
				}
			}
		}
	}

}
