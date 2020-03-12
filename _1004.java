package PATFoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _1004 {
	
	static class Node {
		private int layerNum;
		private boolean flag;
		public Node(int layerNum, boolean flag) {
			this.layerNum = layerNum;
			this.flag = flag;
		}
		public int getLayerNum() {
			return layerNum;
		}
		public boolean getFlag() {
			return flag;
		}
		public void setLayerNum(int layerNum) {
			this.layerNum = layerNum;
		}
		public void setFlag(boolean flag) {
			this.flag = flag;
		}
	}
	static class Tree {
		private ArrayList<Node> tree;
		public Tree() {
			tree = new ArrayList<Node>();
			for(int i = 0 ; i < 105 ; i++) {
				tree.add(new Node(-1,false));
			}
			tree.get(0).setLayerNum(0);
		}
		public void addNode(int seqNum, Node Node) {
			tree.set(seqNum-1, Node);
		}
		public Object[] cal() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int i = 0 ; i < 105 ; i++) {
				int sum = 0;
				boolean flag = false;
				for(int j = 0 ; j < tree.size() ; j++) {
					if(tree.get(j).getLayerNum() == i)
						flag = true;
					if(tree.get(j).layerNum == i && tree.get(j).getFlag() == false)
						sum++;
				}
				if(flag == true)
					result.add(sum);
			}
			return result.toArray();
		}
		public Node getNode(int seqNum) {
			return tree.get(seqNum-1);
		}
	}

	public static void main(String[] args) throws IOException {
		String[] str = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split(" ");
		int totalNum = Integer.parseInt(str[0]);
		int non_leafNum = Integer.parseInt(str[1]);
		if(totalNum == 0);
		else {
			if(totalNum == 1) {
				System.out.println("1");
			}else {
				Tree tree = new Tree();
				for(int i = 0 ; i < non_leafNum ; i++) {
					str = br.readLine().split(" ");
					String[] value = Arrays.copyOfRange(str, 2, str.length);
					int seqNum = Integer.parseInt(str[0]);
					tree.getNode(seqNum).setFlag(true);
					int currentLayerNum = tree.getNode(seqNum).getLayerNum();
					for(int j = 0 ; j < value.length ; j++) {
						tree.getNode(Integer.parseInt(value[j])).setLayerNum(currentLayerNum + 1);;
					}	
				}
				Object[] result = tree.cal();
				for(int i = 0 ; i < result.length - 1; i++) {
					System.out.print(result[i] + " ");
				}
				System.out.print(result[result.length - 1]);
			}
		}

	}

}
