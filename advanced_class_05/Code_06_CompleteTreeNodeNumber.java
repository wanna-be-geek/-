package advanced_class_05;

//1 找到完全二叉树的最左节点，也就是求左子树的深度
//2 找到完全二叉树头节点右子树中的最左节点，记录右子树深度
//3 如果两个深度相等，说明头节点左子树是一棵满二叉树，使用公式求得长度再加上头节点，然后对于右子树使用递归求解
//4 如果左子树深度大于右子树深度，说明右子树是一棵完全二叉树，使用公式求得长度再加上头节点，然后对于左子树使用递归求解.

public class Code_06_CompleteTreeNodeNumber {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}

	public static int bs(Node node, int l, int h) {
		if (l == h) {
			return 1;
		}
		if (mostLeftLevel(node.right, l + 1) == h) {
			return (1 << (h - l)) + bs(node.right, l + 1, h);
		} else {
			return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
		}
	}

	public static int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}

}
