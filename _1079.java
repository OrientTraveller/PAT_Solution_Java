package PATFoo;

import java.util.Scanner;

public class _1079 {

	static float sum = 0;
	static float price;
	static float percent;
	
	static class Shop {
		int[] retailers;
		int amount;
		public Shop() {
			retailers = null;
			amount = 0;
		}
	}
	
	static void cal(Shop[] chain , int index , int deep) {
		if(chain[index].retailers != null) {
			for(int i : chain[index].retailers)
				cal(chain,i,deep+1);
		}
		else
			sum += chain[index].amount * price *  Math.pow((double)percent/100 + 1, deep);
	}	
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		price = scaner.nextFloat();
		percent = scaner.nextFloat();
		Shop[] chain = new Shop[num];
		for(int i = 0 ; i < num ; i++) {
			int temp = scaner.nextInt();
			chain[i] = new Shop();
			if(temp != 0) {
				chain[i].retailers = new int[temp];
				for(int j = 0 ; j < temp ; j++)
					chain[i].retailers[j] = scaner.nextInt();
			}
			else
				chain[i].amount = scaner.nextInt();	
		}
		scaner.close();
		cal(chain,0,0);
		System.out.println(String.format("%.1f", sum));
	}
}
