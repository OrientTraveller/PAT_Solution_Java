package PATFoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _1005 {

	public static void main(String[] args) throws IOException {
		String[] str = null; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split("");
		BigInteger sum = new BigInteger("0");
		for(int i = 0 ; i < str.length ; i++) {
			sum = sum.add(new BigInteger(str[i]));
		}
		String[] result = sum.toString().split("");
		for(int i = 0 ; i < result.length ; i++) {
			String output = null;
			if(result[i].equals("0"))
				output = "zero";
			else if(result[i].equals("1"))
				output = "one";
			else if(result[i].equals("2"))
				output = "two";
			else if(result[i].equals("3"))
				output = "three";
			else if(result[i].equals("4"))
				output = "four";
			else if(result[i].equals("5"))
				output = "five";
			else if(result[i].equals("6"))
				output = "six";
			else if(result[i].equals("7"))
				output = "seven";
			else if(result[i].equals("8"))
				output = "eight";
			else
				output = "nine";
			if(i != result.length-1)
				System.out.print(output + " ");
			else
				System.out.print(output);
		}

	}

}
