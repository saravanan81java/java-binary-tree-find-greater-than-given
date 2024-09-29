package com.binary.tree.find.given;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class BinaryTreeFinder {

	public static void main(String[] args) {
		
		List<Integer> ll = Arrays.asList(10,5,15,2,7,12,17);
		
		ll = ll.stream().sorted().collect(Collectors.toList());
		
		System.out.println(ll);
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);
		
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(17);
		
		/*TreeNode [val=10, 
				left=TreeNode [val=5, 
					left=TreeNode [val=2, left=null, right=null], 
					right=TreeNode [val=7, left=null, right=null]], 
				right=TreeNode [val=15, 
					left=TreeNode [val=12, left=null, right=null], 
					right=TreeNode [val=17, left=null, right=null]]]*/
		
		int n = 5;
		System.out.println(n);
		Integer result = findMinimumGreaterThenGiven(root, n);
		
		if(result != null) {
			System.out.println("Eexpected Output " + result);
		}else {
			System.out.println("Expected Output is not in the binary tree");
		}
	}
	
	private static Integer findMinimumGreaterThenGiven(TreeNode root, int n) {
		 return findHelper1(root, n, null);
		 
	}
	

	private static Integer findHelper1(TreeNode root, int n, Integer minVal) {
		
		if(root == null) { //10 5 2 7 15 12 17
			return minVal;
		}
		if(root.val > n) {
			minVal = findHelper1(root.left, n, minVal);
		} 
		
		if(root.val > n && (minVal ==null || root.val < minVal)) {
			minVal = root.val;
		}
		
		return findHelper1(root.right, n, minVal);
	}

}
