package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _1048 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int coinNum = scaner.nextInt();
		int totalMoney = scaner.nextInt();
		ArrayList<Integer> coin = new ArrayList<Integer>();
		int[] valueNum = new int[1005];
		for(int i = 0 ; i < coinNum ; i++) {
			int temp = scaner.nextInt();
			coin.add(temp);
			valueNum[temp]++;
		}
		scaner.close();
		boolean flag = false;
		Collections.sort(coin);
		for(int i = 0 ; i < coinNum && coin.get(i) <= totalMoney/2 ; i++) {
			int temp = coin.get(i);
			if((temp == totalMoney - temp&&valueNum[temp]>=2)||(temp != totalMoney - temp&&valueNum[totalMoney - temp]>=1)) {
				flag = true;
				System.out.println(temp + " " + (totalMoney - temp));
				break;
			}
		}
		if(!flag)
			System.out.println("No Solution");
	}

}
