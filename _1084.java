package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1084 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String ori = scaner.nextLine();
		String current = scaner.nextLine();
		scaner.close();
		ArrayList<Character> result = new ArrayList<Character>();
		if(current.equals("")) {
			for(char c : ori.toCharArray())
				if(!result.contains(Character.toUpperCase(c)))
					result.add(Character.toUpperCase(c));
		}
		else {
			int oriPoint = 0;
			int currentPoint = 0;
			while(currentPoint < current.length() && oriPoint < ori.length()) {
				if(ori.charAt(oriPoint) == current.charAt(currentPoint)) {
					oriPoint++;
					currentPoint++;
				}
				else {
					char c = Character.toUpperCase(ori.charAt(oriPoint));
					if(!result.contains(c))
						result.add(c);
					oriPoint++;
				}
			}
		}
		for(char c : result)
			System.out.print(c);
	}
}
