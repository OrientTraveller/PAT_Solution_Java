package PATFoo;

import java.util.Scanner;

public class _1011 {

	public static void main(String[] args) {
		float odd1 = 1;
		float flag1= 0;
		float odd2 = 1;
		float flag2= 0;
		float odd3 = 1;
		float flag3= 0;
		Scanner scaner = new Scanner(System.in);
		for(int i = 0 ; i < 3 ; i++) {
			float result = 1;
			float flag = 0;
			for(int j = 0 ; j < 3 ; j++) {
				float mid = scaner.nextFloat();
				if(mid > result) {
					result = mid;
					flag = j;
				}
			}
			if(i == 0) {
				odd1 = result;
				flag1 = flag;
			}
			else if(i == 1) {
				odd2 = result;
				flag2 = flag;
			}
			else {
				odd3 = result;
				flag3 = flag;
			}
		}
		scaner.close();
		float[] flags = new float[] {flag1 , flag2 , flag3};
		double sum = (odd1 * odd2 * odd3 * 0.65 - 1) * 2;
		String total = String.format("%.2f",sum);
		for(int i = 0 ; i < flags.length ; i++) {
			if(flags[i] == 0)
				System.out.print("W" + " ");
			else if(flags[i] ==1)
				System.out.print("T" + " ");
			else
				System.out.print("L" + " ");
		}
		System.out.print(total);
	}

}
