package PATFoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 这个题存储的结果字符串数组是以层为单位进行存储的，
 * 比如说数组第零个元素为“4” ， 
 * 第一个元素为“1 6” ， 
 * 每一个元素都代表了这一层所要输出的结果字符串
 */

public class _1020 {
	
	static String[] level;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		level = new String[num];
		for (int i = 0; i < num; i++)
			level[i] = "";
		String[] postorder = bf.readLine().split(" ");
		String[] inorder = bf.readLine().split(" ");
		levelorder(postorder, inorder, 0);
		String result = "";
		for (int i = 0; i < level.length; i++)
			result += level[i];
		System.out.println(result.trim());
	}

	static void levelorder(String[] post, String[] in, int floor) {
		String target = post[post.length - 1];
		System.out.println(target);
		level[floor] += target + " ";
		if (post.length == 1)
			return;
		int loc = -1;
		for (int i = 0; i < post.length; i++) {
			if (in[i].equals(target))
				loc = i;
		}

		int left = loc;
		int right = in.length - loc - 1;
		String[] post_right = new String[right];
		String[] in_right = new String[right];
		String[] post_left = new String[left];
		String[] in_left = new String[left];

		for (int i = 0; i < left; i++) {
			post_left[i] = post[i];
			in_left[i] = in[i];
		}
		for (int i = 0; i < right; i++) {
			post_right[i] = post[loc + i];
			in_right[i] = in[loc + 1 + i];
		}
		
		//深度优先，左先右后
		if (left > 0 || right == 0) {
			levelorder(post_left, in_left, floor + 1);
		}
		if (right > 0 || left == 0) {
			levelorder(post_right, in_right, floor + 1);
		}
	}

}
