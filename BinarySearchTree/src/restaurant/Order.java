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
	
    public void insert(MenuItem menuItem){
        BSTNode<MenuItem> bstNode = new BSTNode<MenuItem>(menuItem, null, null);
        BSTNode<MenuItem> x = root;

        BSTNode<MenuItem> y = null;
        while(x != null){
            y = x;
            if(menuItem.compareTo(x.getData()) < 0){
                x = x.getLeft();
            }
            else if (menuItem.compareTo(x.getData()) >= 0){
                x = x.getRight();
            }
        }
        if(y == null)
            y = bstNode;
        else if (menuItem.compareTo(y.getData()) < 0){
            y.setLeft(bstNode);
        }
        else if(menuItem.compareTo(y.getData()) > 0){
            y.setRight(bstNode);
        }
        else {
            y.getData().setQuantity(y.getData().getQuantity() + 1);
        }
        if(root == null)
            root = y;
    }
    
    public void preorder(){
        if (root == null) {
            return;
        }
        Stack<BSTNode<MenuItem>> stack = new Stack<BSTNode<MenuItem>>();
        stack.push(root);
        while (!stack.empty()) {
            BSTNode<MenuItem> mynode = stack.peek();
            System.out.print(mynode.getData() + " ");
            stack.pop();
            if (mynode.getRight() != null) {
                stack.push(mynode.getRight());
            }
            if (mynode.getLeft() != null) {
                stack.push(mynode.getLeft());
            }
        }
    }
    
    public void inorder(){
        if (root == null)
            return;
        Stack<BSTNode<MenuItem>> stack = new Stack<BSTNode<MenuItem>>();
        BSTNode<MenuItem> curr = root;
        while (curr != null || stack.size() > 0)
        {
            while (curr !=  null)
            {
            	stack.push(curr);
                curr = curr.getLeft();
            }
            curr = stack.pop();
            System.out.print(curr.getData() + " ");
            curr = curr.getRight();
        }
    }
    
    public void postorder(){
        Stack<BSTNode<MenuItem>> stack = new Stack<>();
        BSTNode<MenuItem> x = root;
        while(true) {
            while(x != null) {
                stack.push(x);
                stack.push(x);
                x = x.getLeft();
            }
            if(stack.empty()) return;
            x = stack.pop();
            if(!stack.empty() && stack.peek() == x) x = x.getRight();
            else {
                System.out.print(x.getData() + " "); x = null;
            }
        }

    }
    
    public int size(){
        if (root==null)
            return 0;

        Queue<BSTNode<MenuItem>> queue = new LinkedList<BSTNode<MenuItem>>();
        queue.add(root);
        int count=0; 
        while (!queue.isEmpty())
        {
            BSTNode<MenuItem> z = queue.poll();
                count++;
            if (z.getLeft() != null)
            {
                queue.add(z.getLeft());
            }
            if (z.getRight() != null)
            {
                queue.add(z.getRight());
            }
        }
        return count;
    }
    
    public int depth(){
        if (root == null)
            return -1;
        Queue<BSTNode<MenuItem>> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while (1 == 1)
        {
            int count = queue.size();
            if (count == 0)
                return height;
            height++;
            while (count > 0)
            {
                BSTNode<MenuItem> newnode = queue.peek();
                queue.remove();
                if (newnode.getLeft() != null)
                    queue.add(newnode.getLeft());
                if (newnode.getRight() != null)
                    queue.add(newnode.getRight());
                count--;
            }
        }
    }
    
    public int getTotalQty(){
        if (root==null)
            return 0;
        Queue<BSTNode<MenuItem>> queue = new LinkedList<BSTNode<MenuItem>>();
        queue.add(root);
        int count=0; 
        while (!queue.isEmpty())
        {
            BSTNode<MenuItem> z = queue.poll();
           count += z.getData().getQuantity();

            if (z.getLeft() != null)
            {
                queue.add(z.getLeft());
            }
            if (z.getRight() != null)
            {
                queue.add(z.getRight());
            }
        }
        return count;
    }
    
    public MenuItem search(String target){
        while (root != null) {
            if (   root.getData().toString().compareTo(target) < 1)
                root = root.getRight();
            else if (   root.getData().toString().compareTo(target)  > 1)
                root = root.getLeft();
            else
                return (MenuItem) root.getData(); 
        }
        return null;
    }
    
    public double getTotalBeforeTax(){
        if (root==null)
            return 0;
        Queue<BSTNode<MenuItem>> queue = new LinkedList<BSTNode<MenuItem>>();
        queue.add(root);
        int total=0; 
        while (!queue.isEmpty())
        {
            BSTNode<MenuItem> temp = queue.poll();
            total += temp.getData().getPrice()*temp.getData().getQuantity();
            if (temp.getLeft() != null)
            {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null)
            {
                queue.add(temp.getRight());
            }
        }
        return total;
    }
    
    public double getTax(double percent){
        return  getTotalBeforeTax()*percent/100;
    }
    public double getTip(double percent){
        return getTotalBeforeTax()*percent/100;
    }
    
    @Override
    public String toString(){
        StringBuilder tableMenu = new StringBuilder();
        if (root!= null) {
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
        return name+"\t"+
                tableNumber+"\n"+
                "---------------------------------------------\n"+
                "Item \t\t Price \t\t  Qty \t\t Total\n"+
                "----------------------------------------------\n"+
                tableMenu.toString()+
                "------------------------------------------------\n"+
                "Total \t\t$"+dec.format(getTotalBeforeTax())+"\n"+
                "Tax \t\t$"+dec.format(getTax(8))+"\n"+
                "Tip \t\t$"+dec.format(getTip(20))+"\n"+
                "----------------------------------------------\n"+
                "Grand total: $"+dec.format(getTotalBeforeTax()+getTax(8)+getTip(20))+"\n\n";
    }
    
}
