package PATFoo;

import java.util.Scanner;

public class _1042 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		scaner.nextLine();
		String[] card = new String[] {
				"S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "S11", "S12", "S13",
				"H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12", "H13",
				"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13",
				"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13",
				"J1","J2"};
		String[] order = scaner.nextLine().split(" ");
		scaner.close();
		for(int i = 0 ; i < round ; i++) {
			String[] newOrder = new String[54];
			for(int j = 0 ; j < 54 ; j++) {
				newOrder[Integer.parseInt(order[j]) - 1] = card[j];
			}
			for(int j = 0 ; j < 54 ; j++) {
				 card[j] = newOrder[j];
			}
		}
		for(int j = 0 ; j < 54 ; j++) {
			if(j == 53)
				System.out.print(card[j]);
			else
				System.out.print(card[j] + " ");
		}
	}

}
