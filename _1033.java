package PATFoo;

import java.util.Scanner;

public class _1033 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		double capacity = scaner.nextDouble();
		double totalDis = scaner.nextDouble();
		double per = scaner.nextDouble();
		int stationNum = scaner.nextInt();
		double[] road = new double[(int) (totalDis + 2)];
		scaner.nextLine();
		for(int i = 0 ; i < road.length ; i++) {
			road[i] = Double.MAX_VALUE;
		}
		for(int i = 0 ; i < stationNum ; i++) {
			double temp1 = scaner.nextDouble();
			int temp2 = scaner.nextInt();
			scaner.nextLine();
			road[temp2] = temp1;
		}
		scaner.close();
		double start = (double) 0;
		double end = capacity*per;
		double maxDis = (double) 0;
		double totalPrice = 0;
		while(true) {
			if(road[0] == Double.MAX_VALUE)
				System.out.println("The maximum travel distance = 0.00");
			else {
				int minPriceDis = (int) start;
				for(int i = (int) start ; i < end ; i++) {
					if(road[i] < road[minPriceDis]) {
						minPriceDis = i;
					}
				}
				if(minPriceDis != start) {
					totalPrice = totalPrice + ((minPriceDis - start)/per)*road[(int) start];
					maxDis = minPriceDis;
					start = maxDis;
					end = start + capacity*per;
				}
				else {
					//totalPrice = totalPrice + (capacity - currentCapacity)*road[(int) start];
					int secondMinPriceDis = (int) (start + 1);
					for(int i = (int) start + 1 ; i < end ; i++) {
						if(road[i] < road[minPriceDis]) {
							secondMinPriceDis = i;
						}
					}
					start = secondMinPriceDis;
					end = start + capacity*per;
					maxDis = secondMinPriceDis;
				}
			}
		}
		
	}

}
