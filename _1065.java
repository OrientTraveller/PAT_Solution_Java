package PATFoo;

import java.util.Scanner;

/**
 * 注意虽然AB都是long但A+B可能溢出，可以根据溢出的性质进行判断，如第21、23行所示
 * 还有注意边界值，当A+B>C时输出true，小于等于的时候都是false
 * @author SunFeiran
 *
 */

public class _1065 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		for(int i = 1 ; i < round + 1 ; i++) {
			long temp1 = scaner.nextLong();
			long temp2 = scaner.nextLong();
			long temp3 = scaner.nextLong();
			if(temp1>0&&temp2>0&&temp1+temp2<0)
				System.out.println("Case #" + i + ": true");
			else if(temp1<0&&temp2<0&&temp1+temp2>=0)
				System.out.println("Case #" + i + ": false");
			else
				System.out.println("Case #" + i + ": " + (temp1 + temp2 > temp3));	
		}
		scaner.close();

	}

}
