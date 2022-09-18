package Tree;

public class Binary_SearchTree {
	public class Node{
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data){
            this.setData(data);
            setLeft(null);
            setRight(null);
        }
		
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
	}
	public Node root;
	Binary_SearchTree(){
		root = null;
	}
	public boolean search(int target) {
		Node currentNode = root;
		while(currentNode != null) {
			if(currentNode.getData() == target)
				return true;
			else if(currentNode.getData() > target)
				currentNode = currentNode.getLeft();
			else
				currentNode = currentNode.getRight();
		}
		return false;
	}
	
	public void insert(int data) {
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
			return;
		}
		Node currentNode = root;
		while(true) {
			Node parentNode = currentNode;
			if(data > currentNode.getData()) {
				currentNode = currentNode.getRight();
				if(currentNode == null) {
					parentNode.setRight(newNode);
					return;
				}
			}
			else {
				currentNode = currentNode.getLeft();
				if(currentNode == null) {
					parentNode.setLeft(newNode);
					return;
					}
				}
			
		}
	}
	
	public boolean delete(int data) {
		Node currentNode = root;
		Node parentNode = null;
		while(currentNode.data != data) {
			parentNode = currentNode;
			if(currentNode.data > data)
				currentNode = currentNode.left;
			else
				currentNode = currentNode.right;
			if(currentNode == null)
				return false;
		}
		if(currentNode.left == null && currentNode.right == null) {
			if(currentNode == root)
				root = null;
			else if(currentNode == parentNode.right)
				parentNode.right = null;
			else
				parentNode.left = null;
		}
		else if(currentNode.left == null) {
			if(currentNode == root)
				root = currentNode.right;
			else if(currentNode == parentNode.right)
				parentNode.right = currentNode.right;
			//else
			//	parentNode.left = currentNode.right;
		}
		else if(currentNode.right == null) {
			if(currentNode == root)
				root = currentNode.left;
			else if(currentNode == parentNode.right)
				parentNode.right = currentNode.left;
			//else
			//	parentNode.left = currentNode.left;
		}
		//삭제할 노드의 왼쪽 트리의 가장 큰 값을 루트로 올리거나 오른쪽 트리의 가장 작은 값을 루트로 올리면 됨.
		else {
			Node parent_Replace = currentNode;
			Node replace = parent_Replace.right;
			while(replace.left != null) {
				parent_Replace = replace;
				replace = replace.left;
			}
			if(replace != currentNode.right) {
				parent_Replace = replace.right;
				replace.right = currentNode.right;
			}
			if(currentNode == root)
				root = replace;
			else if(currentNode == parentNode.right)
				parentNode.right = replace;
			else
				parentNode.left = replace;
			replace.left = currentNode.left;
		}
		return true;
	}
	
	public static void inorder(Node root) {
		if(root!=null) {
			inorder(root.getLeft());
			System.out.print(root.getData() + " ");
			inorder(root.getRight());
		}
	}
	
	public static void preorder(Node root) {
		if(root!=null) {
			System.out.print(root.getData() + " ");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	
	public static void postorder(Node root) {
		if(root != null) {
			postorder(root.getLeft());
			postorder(root.getRight());
			System.out.print(root.getData());
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_SearchTree tree = new Binary_SearchTree();
		tree.insert(10);
		tree.insert(7);
		tree.insert(9);
		tree.insert(3);
		tree.insert(1);
		tree.insert(5);
		tree.insert(15);
		tree.insert(6);
		tree.insert(13);
		tree.insert(12);
		tree.insert(17);
		tree.insert(11);
		tree.insert(14);
		tree.insert(18);
		tree.insert(16);
		tree.insert(20);
		tree.delete(17);
		tree.delete(5);
		inorder(tree.root);
	}

}
