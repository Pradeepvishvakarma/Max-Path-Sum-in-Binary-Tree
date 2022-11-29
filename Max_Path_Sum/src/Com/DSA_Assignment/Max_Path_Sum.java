package Com.DSA_Assignment;

class Node {

		int data;
		Node left, right;

		public Node(int item)
		{
			data = item;
			left = null;
			right = null;
			
		}
	}

public class Max_Path_Sum {

	
		// Root of the Binary Tree
		Node root;

		int findMaxFunction(Node node, Result result)
		{

			if (node == null)
				return 0;

			int leftPathSum = findMaxFunction(node.left, result);
			int rightPathSum = findMaxFunction(node.right, result);

			int max_single = Math.max(
				Math.max(leftPathSum, rightPathSum) + node.data, node.data);

			int max_top	= Math.max(max_single, leftPathSum + rightPathSum + node.data);

			// Store the Maximum Result.
			result.value = Math.max(result.value, max_top);

			return max_single;
		}
		
		class Result 
		{
			public int value;
		}

		int findMaxSumPath() 
		{
			return findMaxSumPath(root); 
		}

		// It Returns maximum path sum in tree with given root
		int findMaxSumPath(Node node)
		{

			Result result = new Result();
			result.value = Integer.MIN_VALUE;

			findMaxFunction(node, result);
			return result.value;
		}

	
		public static void main(String args[])
		{
			Max_Path_Sum Binarytree = new Max_Path_Sum();
			Binarytree.root = new Node(1);
			Binarytree.root.left = new Node(2);
			Binarytree.root.right = new Node(3);
			Binarytree.root.left.left = new Node(4);
			Binarytree.root.left.right = new Node(5);
			Binarytree.root.right.left = new Node(6);
			Binarytree.root.right.right = new Node(7);

			//It prints output of Maximum Path Sum in Binary Tree 
			System.out.println(Binarytree.findMaxSumPath());
		}
	}
