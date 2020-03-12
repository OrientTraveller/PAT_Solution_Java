package PATFoo;

import java.util.Scanner;

public class _1072 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int houseNum = scaner.nextInt();
		int stationNum = scaner.nextInt();
		int[][] matrix = new int[houseNum + stationNum + 1][houseNum + stationNum + 1];
		for(int i = 0 ; i < houseNum + stationNum + 1 ; i++) {
			for(int j = 0 ; j < houseNum + stationNum + 1 ; j++) {
				if(i != j)
					matrix[i][j] = 999999999;
			}
		}
		int round = scaner.nextInt();
		int maxDis = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			String str1 = scaner.next();
			String str2 = scaner.next();
			int temp1 = str1.length() > 1? Integer.parseInt(str1.substring(1)) + houseNum : Integer.parseInt(str1);
			int temp2 = str2.length() > 1? Integer.parseInt(str2.substring(1)) + houseNum : Integer.parseInt(str2);
			int temp3 = scaner.nextInt();
			matrix[temp1][temp2] = matrix[temp2][temp1] = temp3;
		}
		scaner.close();
		int index = 0;
		int stationIndex = 0;
		int minDis = -1;
		double avg = 999999999;
		while(index < stationNum) {
			index++;
			boolean[] flag = new boolean[houseNum + stationNum + 1];
			int[] dis = new int[houseNum + stationNum + 1];
			for(int i = 1 ; i < houseNum + stationNum + 1 ; i++) {
				dis[i] = 999999999;
			}
			for(int i = 1 ; i < houseNum + stationNum + 1 ; i++) {
				if(matrix[index + houseNum][i] != 999999999)
					dis[i] = matrix[index + houseNum][i];
			}
			boolean stationService = true;//表示加油站能否覆盖全部居民区
			for(int j = 0 ; j <= houseNum + stationNum ; j++) {
				int minIndex = 0;
				int minDisTemp = Integer.MAX_VALUE;
				for(int i = 1 ; i < houseNum + stationNum + 1 ; i++) {
					if(dis[i] < minDisTemp && !flag[i]) {
						minIndex = i;
						minDisTemp = dis[i];
					}
				}
				if(minIndex >= 1 && minIndex <= houseNum && minDisTemp > maxDis) {
					stationService = false;
					break;
				}
				flag[minIndex] = true;
				for(int i = 1 ; i < houseNum + stationNum + 1 ; i++) {
					if(!flag[i] && dis[i] > dis[minIndex] + matrix[minIndex][i])
						dis[i] = dis[minIndex] + matrix[minIndex][i];
				}
			}
			if(stationService) {
				int sum = 0;
				int minTemp = 999999999;
				for(int i = 1 ; i <= houseNum ; i++) {
					sum += dis[i];
					if(i != index + houseNum && dis[i] < minTemp) {
						minTemp = dis[i];
					}
				}
				double avgTemp = (double)sum/houseNum;
				if(minTemp > minDis || (minTemp == minDis && avgTemp < avg)) {
					minDis = minTemp;
					stationIndex = index;
					avg = avgTemp;
				}
			}
		}
		if(minDis != -1) {
			System.out.println("G" + stationIndex);
			System.out.println(String.format("%.1f", (float)minDis) + " " + String.format("%.1f", avg));
		}
		else
			System.out.println("No Solution");
	}

}
