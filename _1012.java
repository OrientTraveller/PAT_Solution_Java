package PATFoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _1012 {
	
	public static class Student {
		private String id;
		private int c;
		private int m;
		private int e;
		private int a;
		private int[] ranks;
		public Student(String id , int c , int m ,int e) {
			this.id = id;
			this.c = c;
			this.m = m;
			this.e = e;
			this.a = (c + m + e)/3;
			ranks = new int[4];
		}
		
		public String getId() {
			return id;
		}
		public int getC() {
			return c;
		}
		public int getM() {
			return m;
		}
		public int getE() {
			return e;
		}
		public int getA() {
			return a;
		}
		public String getRanks() {
			int flag = 0;
			int rank = 5000;
			for(int i = 0 ; i < ranks.length ; i++) {
				if(rank > ranks[i]) {
					rank = ranks[i];
					flag = i;
				}	
			}
			String result = null;
			if(flag == 0)
				result = "A";
			else if(flag == 1)
				result = "C";
			else if(flag == 2)
				result = "M";
			else
				result = "E";
			result = String.valueOf(rank) + " " + result;
			return result;
		}
		public void setARanks(int rank) {
			ranks[0] = rank;
		}
		public void setCRanks(int rank) {
			ranks[1] = rank;
		}
		public void setMRanks(int rank) {
			ranks[2] = rank;
		}
		public void setERanks(int rank) {
			ranks[3] = rank;
		}
	}
	
	public static String[] sort(int[] ori) {
		String[] result = new String[ori.length];
		Arrays.sort(ori);
		for(int i = 0 ; i < ori.length ; i++) {
			result[i] = String.valueOf(ori[i]).substring(2);
		}
		
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Student> record = new ArrayList<Student>();
		int[] cs = null;
		int[] ms = null;
		int[] es = null;
		int[] as = null;
		String[] ids = null;
		Scanner scaner = new Scanner(System.in);
		int totalNum = scaner.nextInt();
		int checkNum = scaner.nextInt();
		scaner.nextLine();
		cs = new int[totalNum];
		ms = new int[totalNum];
		es = new int[totalNum];
		as = new int[totalNum];
		for(int i = 0 ; i < totalNum ; i++) {
			String[] strs = scaner.nextLine().split(" ");
			String id = strs[0];
			int c = Integer.parseInt(strs[1]);
			cs[i] = Integer.parseInt(strs[1] + id);
			int m = Integer.parseInt(strs[2]);
			ms[i] = Integer.parseInt(strs[2] + id);
			int e = Integer.parseInt(strs[3]);
			es[i] = Integer.parseInt(strs[3] + id);
			as[i] = Integer.parseInt(String.valueOf(Math.round((c + m + e)/3)) + id);
			record.add(new Student(id, c, m, e));
		}
		ids = new String[checkNum];
		for(int i = 0 ; i < checkNum ; i++) {
			String str = scaner.nextLine();
			ids[i] = str;
		}
		scaner.close();
		String[] arank = sort(as);
		String[] crank = sort(cs);
		String[] mrank = sort(ms);
		String[] erank = sort(es);
		for(int i = 0 ; i < arank.length ; i++) {
			for(int j = 0 ; j < record.size() ; j++) {
				if(arank[i].equals(record.get(j).getId())) {
					record.get(j).setARanks(totalNum - i);
				}
				if(crank[i].equals(record.get(j).getId())) {
					record.get(j).setCRanks(totalNum - i);
				}
				if(mrank[i].equals(record.get(j).getId())) {
					record.get(j).setMRanks(totalNum - i);
				}
				if(erank[i].equals(record.get(j).getId())) {
					record.get(j).setERanks(totalNum - i);
				}
			} 
		}
		for(int i = 0 ; i < ids.length ; i++) {
			boolean flag = false;
			for(int j = 0 ; j < record.size() ; j++) {
				if(ids[i].equals(record.get(j).getId())) {
					flag = true;
					System.out.println(record.get(j).getRanks());
					break;
				}
			}
			if(flag == false)
				System.out.println("N/A");
		}
		

	}

}
