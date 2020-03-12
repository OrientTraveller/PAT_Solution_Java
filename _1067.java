package PATFoo;
import java.util.Scanner;
public class _1067 {
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int[] seq = new int[num];
		for(int i = 0 ; i < num ; i++) {
			seq[i] = scaner.nextInt();
		}
		scaner.close();
		int round = 0;
		for(int i = 0 ; i < num ; i++) {
			if(seq[i] == i)continue;
			while(seq[0] != 0) {
				int temp = seq[seq[0]];
				seq[seq[0]] = seq[0];
				seq[0] = temp;
				round++;
			}
			if(seq[i] != i) {
				int temp = seq[i];
				seq[i] = seq[0];
				seq[0] = temp;
				round++;
			}
		}
		System.out.println(round);
	}
}
