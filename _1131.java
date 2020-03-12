package PATFoo;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class _1131 {
	
	static Vector<Vector<Integer>> g;
	static HashMap<Integer, Integer> map;
	static Vector<Integer> tempList;
	static Vector<Integer> minList;
	static int[] visit;
	static int minTStationNum;
	static int minStationNum;
	static int start;
	static int end;
	
	static int transferNum(Vector<Integer> v) {
		int num = -1;
		int preLine = 0;
	    for (int i = 1; i < v.size(); i++) {
	    	if (map.get(v.get(i-1)*10000+v.get(i)) != preLine) num++;
	        preLine = map.get(v.get(i-1)*10000+v.get(i));
	    }
	    return num;
	}
	
	static void dfs(int stationNum, int num) {
		if (stationNum == end && (num < minStationNum || (num == minStationNum && transferNum(tempList) < minTStationNum))) {
	        minStationNum = num;
	        minTStationNum = transferNum(tempList);
	        minList.clear();
	        minList.addAll(tempList);
	    }
	    if (stationNum == end) return;
	    for (int i = 0; i < g.get(stationNum).size(); i++) {
	        if (visit[g.get(stationNum).get(i)] == 0) {
	            visit[g.get(stationNum).get(i)] = 1;
	            tempList.add(g.get(stationNum).get(i));
	            dfs(g.get(stationNum).get(i), num + 1);
	            visit[g.get(stationNum).get(i)] = 0;
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	 
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		g = new Vector<Vector<Integer>>();
		for(int i = 0 ; i < 10000 ; i++)
			g.add(new Vector<Integer>());
		map = new HashMap<Integer, Integer>();
		tempList = new Vector<Integer>();
		minList = new Vector<Integer>();
		visit = new int[10000];
		int lineNum = scaner.nextInt();
		for(int i = 0 ; i < lineNum ; i++) {
			int stationNum = scaner.nextInt();
			int pre = scaner.nextInt();
			for(int j = 1 ; j < stationNum ; j++) {
				int temp = scaner.nextInt();
				map.put(pre*10000 + temp, i+1);
				map.put(temp*10000 + pre, i+1);
				g.get(pre).add(temp);
				g.get(temp).add(pre);
				pre = temp;
			}
		}
		int round = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			start = scaner.nextInt();
			end = scaner.nextInt();
			minStationNum = minTStationNum = 10000;
	        tempList.clear();
	        tempList.add(start);
	        visit[start] = 1;
	        dfs(start, 0);
	        System.out.println(minStationNum);
	        visit[start] = 0;
	        int preLine = 0, preTransfer = start;
	        for (int j = 1; j < minList.size(); j++) {
	            if (map.get(minList.get(j - 1) * 10000 + minList.get(j)) != preLine) {
	                if (preLine != 0) System.out.println("Take Line#" + preLine + " from " + String.format("%04d", preTransfer) + " to " + String.format("%04d", minList.get(j - 1)) + ".");
	                preLine = map.get(minList.get(j - 1) * 10000 + minList.get(j));
	                preTransfer = minList.get(j - 1);
	            }
	        }
	        System.out.println("Take Line#" + preLine + " from " + String.format("%04d", preTransfer) + " to " + String.format("%04d", end) + ".");
		}
		scaner.close();
	}
}
