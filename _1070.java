package PATFoo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _1070 {

	static class MoonCake{
		int storage;
		double price;
		float value;
		public MoonCake(int storage , double price , float value) {
			this.storage = storage;
			this.price = price;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		int total = scaner.nextInt();
		int[] storage = new int[round];
		float[] value = new float[round];
		MoonCake[] priceList = new MoonCake[round];
		for(int i = 0 ; i < round ; i++) {
			storage[i] = scaner.nextInt();
		}
		for(int i = 0 ; i < round ; i++) {
			value[i] = scaner.nextFloat();
		}
		scaner.close();
		for(int i = 0 ; i < round ; i++) {
			double price = (double)value[i]/storage[i];
			priceList[i] = new MoonCake(storage[i], price, value[i]);
		}
		Comparator<MoonCake> cmp = new Comparator<MoonCake>() {
			@Override
			public int compare(MoonCake o1 , MoonCake o2) {
				if(o1.price > o2.price)
					return -1;
				else
					return 1;
			}
		};
		Arrays.sort(priceList, cmp);
		double profit = 0;
		for(int i = 0 ; i < round ; i++) {
			if(priceList[i].storage<=total) {
				profit += priceList[i].value;
				total -= priceList[i].storage;
			}
			else {
				profit += (double)total/priceList[i].storage*priceList[i].value;
				total = 0;
			}
			if(total == 0)
				break;
		}
		System.out.println(String.format("%.2f", profit));
	}

}
