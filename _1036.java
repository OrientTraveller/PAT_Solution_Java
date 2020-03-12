package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _1036 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int temp = scaner.nextInt();
		scaner.nextLine();
		ArrayList<String> male = new ArrayList<>();
		ArrayList<String> female = new ArrayList<>();
		for(int i = 0 ; i < temp ; i++) {
			String[] strs = scaner.nextLine().split(" ");
			String str = "";
			if(strs[3].equals("100")) 
				str = "999" + " " + strs[0] + " " + strs[1] + " " + strs[2];
			else
				str = strs[3] + " " + strs[0] + " " + strs[1] + " " + strs[2];
			if(strs[1].equals("F"))
				female.add(str);
			else
				male.add(str);	
		}
		scaner.close();
		Collections.sort(female);
		Collections.sort(male);
		int f = 0;
		int m = 0;
		boolean flag = true;
		if(female.isEmpty()) {
			System.out.println("Absent");
			flag = false;
		}
		else {
			String[] strs = female.get(female.size() - 1).split(" ");
			String result = strs[1] + " " + strs[3];
			if(strs[0].equals("999"))
				strs[0] = "100";
			f = Integer.parseInt(strs[0]);
			System.out.println(result);
		}
		
		if(male.isEmpty()) {
			System.out.println("Absent");
			flag = false;
		}
		else {
			String[] strs = male.get(0).split(" ");
			String result = strs[1] + " " + strs[3];
			if(strs[0].equals("999"))
				strs[0] = "100";
			m = Integer.parseInt(strs[0]);
			System.out.println(result);
		}
		
		if(flag == false)
			System.out.println("NA");
		else
			System.out.println(f-m);

	}

}
