package PATFoo;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _1087 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int cityNum = scaner.nextInt();
		int roadNum = scaner.nextInt();
		String dep = scaner.next();
		Map<Integer, Integer> happiness = new TreeMap<Integer, Integer>();
		Map<String, Integer> index = new TreeMap<String, Integer>();
		Map<Integer, String> revIndex = new TreeMap<Integer, String>();
		int[][] matrix = new int[cityNum][cityNum];
		for (int i = 0; i < cityNum; i++)
			for (int j = 0; j < cityNum; j++)
				if (i != j)
					matrix[i][j] = 99999;
		index.put(dep, 0);
		revIndex.put(0, dep);
		happiness.put(0, 0);
		for (int i = 1; i <= cityNum - 1; i++) {
			String city = scaner.next();
			int hap = scaner.nextInt();
			index.put(city, i);
			revIndex.put(i, city);
			happiness.put(i, hap);
		}
		for (int i = 0; i < roadNum; i++) {
			int c1 = index.get(scaner.next());
			int c2 = index.get(scaner.next());
			matrix[c1][c2] = matrix[c2][c1] = scaner.nextInt();
		}
		scaner.close();
		int[] dis = new int[cityNum];
		int[] hap = new int[cityNum];
		float[] avg = new float[cityNum];
		int[] pre = new int[cityNum];
		int[] maxRoadNum = new int[cityNum];
		boolean[] flag = new boolean[cityNum];
		int[] num = new int[cityNum];
		int depInt = index.get(dep);
		for (int i = 0; i < cityNum; i++)
			dis[i] = matrix[depInt][i];
		pre[depInt] = -1;
		int current = 0;
		while (current < cityNum) {
			current++;
			int minIndex = 0;
			int minDis = 99999;
			for (int i = 0; i < cityNum; i++) {
				if (!flag[i] && dis[i] < minDis) {
					minIndex = i;
					minDis = dis[i];
				}
			}
			flag[minIndex] = true;
			num[minIndex]++;
			avg[minIndex] = (float) (avg[minIndex]*(num[minIndex] - 1) + happiness.get(minIndex)) / num[minIndex];
			hap[minIndex] += happiness.get(minIndex);
			maxRoadNum[depInt] = 1;
			for (int j = 0; j < cityNum; j++) {
				if (!flag[j]) {
					if (dis[j] > dis[minIndex] + matrix[minIndex][j]) {
						dis[j] = dis[minIndex] + matrix[minIndex][j];
						pre[j] = minIndex;
						hap[j] = hap[minIndex];
						avg[j] = avg[minIndex];
						num[j] = num[minIndex];
						maxRoadNum[j] = maxRoadNum[minIndex];
					} 
					else if (dis[j] < 99999 && dis[j] == dis[minIndex] + matrix[minIndex][j]) {
						if (hap[j] < hap[minIndex]) {
							pre[j] = minIndex;
							hap[j] = hap[minIndex];
							avg[j] = avg[minIndex];
							num[j] = num[minIndex];
						}
						else if (hap[j] == hap[minIndex] && avg[j] < avg[minIndex]) {
							pre[j] = minIndex;
							avg[j] = avg[minIndex];
							num[j] = num[minIndex];
						}else;
						maxRoadNum[j]+=maxRoadNum[minIndex];
					} else;
				} else;
			}
		}
		int ROMIndex = index.get("ROM");
		int tempIndex = ROMIndex;
		String result = "";
		while(tempIndex != -1) {
			if(tempIndex != depInt)
				result = "->" + revIndex.get(tempIndex) + result;
			else
				result = revIndex.get(tempIndex) + result;
			tempIndex = pre[tempIndex];
		}
		System.out.println(maxRoadNum[ROMIndex] + " " + dis[ROMIndex] + " " + hap[ROMIndex] + " " + (int)avg[ROMIndex]);
		System.out.println(result);
	}

}
