

	import java.util.*;

	class Node {
	    int data;
	    Node left, right;

	    public Node(int data) {
	        this.data = data;
	        left = right = null;
	    }
	}

	public class BST {

	    Node root;

	    public BST() {
	        root = null;
	    }

	    public void insert(int data) {
	        root = insertRec(root, data);
	    }

	    private Node insertRec(Node root, int data) {
	        if (root == null) {
	            root = new Node(data);
	            return root;
	        }
	        if (data < root.data) {
	            root.left = insertRec(root.left, data);
	        } else if (data > root.data) {
	            root.right = insertRec(root.right, data);
	        }
	        return root;
	    }

	    public boolean findPair(Node root, int sum, Set<Integer> set) {
	        if (root == null) {
	            return false;
	        }
	        if (findPair(root.left, sum, set)) {
	            return true;
	        }
	        if (set.contains(sum - root.data)) {
	            System.out.println("Pair found: " + (sum - root.data) + ", " + root.data);
	            return true;
	        } else {
	            set.add(root.data);
	        }
	        return findPair(root.right, sum, set);
	    }

	    public Node findLCA(Node root, int n1, int n2) {
	        if (root == null) {
	            return null;
	        }
	        if (root.data > n1 && root.data > n2) {
	            return findLCA(root.left, n1, n2);
	        }
	        if (root.data < n1 && root.data < n2) {
	            return findLCA(root.right, n1, n2);
	        }
	        return root;
	    }

	    public static void main(String[] args) {
	        BST tree = new BST();
	        tree.insert(10);
	        tree.insert(20);
	        tree.insert(30);
	        tree.insert(40);
	        tree.insert(50);
	        tree.insert(60);
	        tree.insert(70);

	        int sum = 130;
	        Set<Integer> set = new HashSet<>();
	        if (!tree.findPair(tree.root, sum, set)) {
	            System.out.println("Nodes not found.");
	        }

	        int n1 = 60, n2 = 70;
	        Node lca = tree.findLCA(tree.root, n1, n2);
	        System.out.println("Lowest common ancestor of (" + n1 + ", " + n2 + "): " + lca.data);

	        n1 = 40; n2 = 30;
	        lca = tree.findLCA(tree.root, n1, n2);
	        System.out.println("Lowest common ancestor of (" + n1 + ", " + n2 + "): " + lca.data);

	        n1 = 20; n2 = 40;
	        lca = tree.findLCA(tree.root, n1, n2);
	        System.out.println("Lowest common ancestor of (" + n1 + ", " + n2 + "): " + lca.data);
	    }
	}


