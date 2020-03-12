package PATFoo;

import java.util.Scanner;
import java.util.Vector;

public class _1103 {

	static Vector<Integer> result = new Vector<Integer>();
	static Vector<Integer> temp = new Vector<Integer>();
	static Vector<Integer> factorList;
	static int num;
	static int factorNum;
	static int power;
	static int max = -1;

	static void init() {
		for (int i = 1; i < Math.pow(num, 1.0 / power) + 1; i++) {
			int temp = (int) Math.pow(i, power);
			if (temp <= num)
				factorList.add(temp);
			else
				break;
		}
		temp.setSize(factorNum);
	}

	static void factorize(int index, int total, int sum, int factorSum) {
		if (total == factorNum) {
			if (sum == num && factorSum > max) {
				result.clear();
				result.addAll(temp);
				max = factorSum;
			}
			return;
		}
		while (index >= 0) {
			if (sum + factorList.get(index) <= num) {
				temp.set(total, index + 1);
				if(index == 1)
					if(max > factorSum + index + 1 + (sum + factorList.get(index) - num))
						return;
				factorize(index, total + 1, sum + factorList.get(index), factorSum + index + 1);
			}
			if (index == 0)
				return;
			index--;
		}
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		num = scaner.nextInt();
		factorNum = scaner.nextInt();
		power = scaner.nextInt();
		scaner.close();
		factorList = new Vector<Integer>();
		init();
		factorize(factorList.size() - 1, 0, 0, 0);
		if (max == -1)
			System.out.println("Impossible");
		else {
			System.out.print(num + " = ");
			for (int i = 0; i < result.size(); i++) {
		        if (i != 0) System.out.print(" + ");
		        System.out.print(result.get(i) + "^" + power);
		    }
		}
	}

}
