package PATFoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _1022 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int bookNum = scaner.nextInt();
		scaner.nextLine();
		ArrayList<String[]> library = new ArrayList<String[]>();
		for(int i = 0 ; i < bookNum ; i++) {
			String str = scaner.nextLine();
			str = str + "%" + scaner.nextLine();
			str = str + "%" + scaner.nextLine();
			str = str + "%" + scaner.nextLine().replace(' ', '%');
			str = str + "%" + scaner.nextLine();
			str = str + "%" + scaner.nextLine();
			String[] info = str.split("%");
			library.add(info);
		}
		int checkNum = scaner.nextInt();
		String[] check = new String[checkNum];
		scaner.nextLine();
		for(int i = 0 ; i < checkNum ; i++) {
			check[i] = scaner.nextLine();
		}
		scaner.close();
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0 ; i < checkNum ; i++) {
			String checkInfo = check[i].split(": ")[1];
			System.out.println(check[i]);
			for(int j = 0 ; j < library.size() ; j++) {
				String[] temp = library.get(j);
				for(int k = 0 ; k < temp.length ; k++) {
					if(temp[k].equals(checkInfo)) {
						result.add(temp[0]);
						break;
					}
				}
			}
			Collections.sort(result);
			if(result.size() == 0)
				System.out.println("Not Found");
			else {
				for(int j = 0 ; j < result.size() ; j++) {
					System.out.println(result.get(j));
				}
			}
			result.clear();
		}

	}

}
