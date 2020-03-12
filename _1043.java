package PATFoo;

import java.util.Scanner;

public class _1043 {

	public static void main(String[] args) {
		long startTime=System.nanoTime();   //获取开始时间  
		Scanner scaner = new Scanner(System.in);
		Tree tree = new Tree();
		int round = scaner.nextInt();
		String ori = "";
		for(int i = 0 ; i < round ; i++) {
			int temp = scaner.nextInt();
			ori += temp + " ";
			tree.insert(temp);
		}
		scaner.close();
		ori = ori.trim();
		String pre = tree.preOrder(tree.root,"").trim();
		String mPre = tree.mPreOrder(tree.root,"").trim();
		if(ori.equals(pre)) {
			System.out.println("YES");
			String postResult = tree.postOrder(tree.root,"").trim();
			System.out.println(postResult);
		}
		else if(ori.equals(mPre)) {
			System.out.println("YES");
			String mPostResult = tree.mPostOrder(tree.root,"").trim();
			System.out.println(mPostResult);
		}
		else {
			System.out.println("NO");
		}
		long endTime=System.nanoTime(); //获取结束时间  
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns"); 
		
	}

}

class Node{
	private int key;
	private Node leftChild;
	private Node rightChild;
	public Node(int key) {
		this.key = key;
		leftChild = null;
		rightChild = null;
	}
	public int getKey() {
		return key;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
}

class Tree{
	Node root;
	public Tree() {
		root = null;
	}
	
	public void insert(int key) {
		if(root == null) {
			root = new Node(key);
		}
		else {
			Node temp = root;
			while(true) {
				if(key < temp.getKey()) {
					if(temp.getLeftChild() == null) {
						temp.setLeftChild(new Node(key));
						break;
					}
					else
						temp = temp.getLeftChild();
				}
				else {
					if(temp.getRightChild() == null) {
						temp.setRightChild(new Node(key));
						break;
					}
					else
						temp = temp.getRightChild();
				}
			}
		}
	}
	
	public String preOrder(Node root , String result) {
		result += root.getKey() + " ";
		Node leftChild = root.getLeftChild();
		if(leftChild != null) {
			result = preOrder(leftChild , result);
		}
		Node rightChild = root.getRightChild();
		if(rightChild != null) {
			result =  preOrder(rightChild , result);
		}
		return result;
	}
	
	public String postOrder(Node root , String result) {
		Node leftChild = root.getLeftChild();
		if(leftChild != null) {
			result = postOrder(leftChild , result);
		}
		Node rightChild = root.getRightChild();
		if(rightChild != null) {
			result =  postOrder(rightChild , result);
		}
		result += root.getKey() + " ";
		return result;
	}
	
	public String mPreOrder(Node root , String result) {
		result += root.getKey() + " ";
		Node rightChild = root.getRightChild();
		if(rightChild != null) {
			result =  mPreOrder(rightChild , result);
		}
		Node leftChild = root.getLeftChild();
		if(leftChild != null) {
			result = mPreOrder(leftChild , result);
		}
		return result;
	}
	
	public String mPostOrder(Node root , String result) {
		Node rightChild = root.getRightChild();
		if(rightChild != null) {
			result =  mPostOrder(rightChild , result);
		}
		Node leftChild = root.getLeftChild();
		if(leftChild != null) {
			result = mPostOrder(leftChild , result);
		}
		result += root.getKey() + " ";
		return result;
	}
}
