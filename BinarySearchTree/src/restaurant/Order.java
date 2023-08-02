package restaurant;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Order {
	private BSTNode root;
	private String tableNumber;

	static String name = "Chipotle";

	public Order(String tableNumber) {
		this.tableNumber = tableNumber;
		root = null;
	}

	public void insert(MenuItem menuItem) {
		if (root == null) {
			root = new BSTNode(menuItem, null, null);
		} else {
			insert(root, menuItem);
		}
	}

	public void insert(BSTNode current, MenuItem menuItem) {
		if (menuItem.compareTo((MenuItem) current.getData()) <= 0) {
			if (current.getLeft() == null) {
				current.setLeft(new BSTNode(menuItem, null, null));
			} else {
				insert(current.getLeft(), menuItem);
			}
		} else {
			if (current.getRight() == null) {
				current.setRight(new BSTNode(menuItem, null, null));
			} else {
				insert(current.getRight(), menuItem);
			}
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	public void preOrder(BSTNode node) {
		if (node == null)
			return;
		System.out.print(node.data + "->");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder() {
		inOrder(root);
	}

	public void inOrder(BSTNode current) {
		if (current != null) {
			inOrder(current.getLeft());
			System.out.println(current);
			inOrder(current.getRight());
		}
	}

	public void postOrder() {
		postOrder(root);
	}

	public void postOrder(BSTNode node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + "->");
	}

	public int size(BSTNode node) {
		if (node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}

	public int size() {

		return size(root);
	}

	public int depth() {
		int height = 0;
		if (root == null)
			height = -1;
		if (root.getLeft() != null && root.getRight() != null) {
			height = 0;
		}
		return height;
	}

	public int getTotalQty() {
		return getTotalQty(root);

	}

	public int getTotalQty(BSTNode<MenuItem> node) {
		if(node == null){
          return 0;
        } else{
        	return   getTotalQty(node.getLeft()) + getTotalQty(node.getRight()) + node.data.getQuantity() ;

        }
	
	}

	public MenuItem search(String target) {
		while (root != null) {
			if (root.getData().toString().compareTo(target) < 1)
				root = root.getRight();
			else if (root.getData().toString().compareTo(target) > 1)
				root = root.getLeft();
			else
				return (MenuItem) root.getData();
		}
		return null;
	}

	public double getTotalBeforeTax() {
		if (root == null)
			return 0;
		Queue<BSTNode<MenuItem>> queue = new LinkedList<BSTNode<MenuItem>>();
		queue.add(root);
		int total = 0;
		while (!queue.isEmpty()) {
			BSTNode<MenuItem> temp = queue.poll();
			total += temp.getData().getPrice() * temp.getData().getQuantity();
			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				queue.add(temp.getRight());
			}
		}
		return total;
	}

	public double getTax(double percent) {
		return getTotalBeforeTax() * percent / 100;
	}

	public double getTip(double percent) {
		return getTotalBeforeTax() * percent / 100;
	}

	@Override
	public String toString() {
		StringBuilder tableMenu = new StringBuilder();
		if (root != null) {
			Stack<BSTNode<MenuItem>> s = new Stack<BSTNode<MenuItem>>();
			BSTNode<MenuItem> curr = root;
			while (curr != null || s.size() > 0) {
				while (curr != null) {
					s.push(curr);
					curr = curr.getLeft();
				}
				curr = s.pop();
				tableMenu.append(curr.getData().toString()).append("\n");
				curr = curr.getRight();
			}
		}
		DecimalFormat dec = new DecimalFormat("#0.00");
		return name + "\t" + tableNumber + "\n" + "---------------------------------------------\n"
				+ "Item \t\t Price \t\t  Qty \t\t Total\n" + "----------------------------------------------\n"
				+ tableMenu.toString() + "------------------------------------------------\n" + "Total \t\t$"
				+ dec.format(getTotalBeforeTax()) + "\n" + "Tax \t\t$" + dec.format(getTax(8)) + "\n" + "Tip \t\t$"
				+ dec.format(getTip(20)) + "\n" + "----------------------------------------------\n" + "Grand total: $"
				+ dec.format(getTotalBeforeTax() + getTax(8) + getTip(20)) + "\n\n";
	}

}
