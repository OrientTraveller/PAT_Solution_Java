package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1105 {

	static int[] factorize(int num) {
		int temp1 = 0;
		int temp2 = 0;
		for (int i = (int) Math.sqrt(num); i >= 1; i--)
			if (num % i == 0) {
				temp1 = Math.max(i, num / i);
				temp2 = num / temp1;
				break;
			}
		return new int[] { temp1, temp2 };
	}
    /*
     * 这是错误版本的判断循环次数的方法
     * 正确的方法：
     * 若m为偶数，则循环次数为m/2；
     * 若m为奇数，则循环次数为m/2 + 1；
     * 因为偶数对2取余为0，对奇数取余为1，所以正确计算公式为：
     * round = m/2 + m%2
     */
//	static int cal(int m, int n) {
//		int round = 0;
//		while (m * n > 0) {
//			round++;
//			m -= 2;
//			n -= 2;
//		}
//		return round;
//	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int[] element = new int[num];
		int[] factor = factorize(num);
		int m = factor[0];
		int n = factor[1];
		int[][] matrix = new int[m][n];
		for (int i = 0; i < num; i++)
			element[i] = scaner.nextInt();
		scaner.close();
		Arrays.sort(element);
		int round = m / 2 + m % 2;        //正确的判断循环次数的方法
		int index = element.length - 1;
		for (int i = 0; i < round; i++) {
			// 上横
			for (int j = i; j < n - 1 - i && index >= 0; j++)
					matrix[i][j] = element[index--];
			// 右竖
			for (int j = i; j < m - 1 - i && index >= 0; j++)
					matrix[j][n - 1 - i] = element[index--];
			// 下横
			for (int j = i; j < n - 1 - i && index >= 0; j++)
					matrix[m - 1 - i][n - 1 - j] = element[index--];
			// 左竖
			for (int j = i; j < m - 1 - i && index >= 0; j++)
					matrix[m - 1 - j][i] = element[index--];
		}
		if(matrix[m/2][n/2] == 0)
			matrix[m/2][n/2] = element[0];
		for(int[] i : matrix) {
			String result = "";
			for(int j : i)
				result += j + " ";
			System.out.println(result.trim());
		}
	}

}
