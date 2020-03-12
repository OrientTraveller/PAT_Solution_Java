package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _1055 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int peopleNum = scaner.nextInt();
		int queryNum = scaner.nextInt();
		scaner.nextLine();
		ArrayList<String> people = new ArrayList<String>();
		for(int i = 0 ; i < peopleNum ; i++) {
			people.add(scaner.nextLine());
		}
		Comparator<String> cmp = new strcmp();
		Collections.sort(people,cmp);
		for(int i = 0 ; i < queryNum ; i++) {
			System.out.println("Case #" + (i + 1) + ":");
			int num = scaner.nextInt();
			int low = scaner.nextInt();
			int high = scaner.nextInt();
			int output = 0;
			boolean flag = false;
			for(int j = 0 ; j < peopleNum ; j++) {
				String temp = people.get(j);
				String[] tempArr = temp.split(" ");
				int age = Integer.parseInt(tempArr[1]);
				if(age >= low && age <= high) {
					System.out.println(temp);
					output++;
					flag = true;
				}
				if(output == num)
					break;
				
			}
			if(!flag)
				System.out.println("None");
		}
		scaner.close();
	}

}

class strcmp implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		String[] temp1 = o1.split(" ");
		String[] temp2 = o2.split(" ");
		int value1 = Integer.parseInt(temp1[2]);
		int value2 = Integer.parseInt(temp2[2]);
		int age1 = Integer.parseInt(temp1[1]);
		int age2 = Integer.parseInt(temp2[1]);
		String name1 = temp1[0];
		String name2 = temp2[0];
		if(value1 > value2)
			return -1;
		else if(value1 < value2)
			return 1;
		else {
			if(age1 > age2) {
				return 1;
			}
			else if(age1 < age2)
				return -1;
			else
				return name1.compareTo(name2);
		}
	}
}
