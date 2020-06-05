class Book{
	private String title;
	private double price;
	public Book(){}
	public Book(String title, double price){
		this.title = title;
		this.price = price;
	}
	public String getTitle(){
		return this.title;
	}
	public double getPrice(){
		return this.price;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public boolean equals(Book book){
		if(book == null||this == null){
			return false;
		}
		if(this.title.equals(book.title)&&this.price == book.price){
			return true;
		}
		return false;
	}		
	public String toString(){
		return "book name:"+this.title+", book price:"+this.price;
	}
}
class Node{
	private Book book;
	private Node next = null;
	private int foot = 0;
	public Node(){}
	public Node(Book book){
		this.book = book;
	}
	public Book getBook(){
		return this.book;
	}
	public Node getNext(){
		return next;
	}
	public void setBook(Book book){
		this.book = book;
	}
	public void setNext(Node next){
		this.next = next;
	}
	public void addNode(Node newNode){
		if(this.next == null){
			this.next = newNode;
			return;
		}
		else{
			this.next.addNode(newNode);
		}
	}
	public String toString(){
		return this.book.toString();
	}
	
	public boolean equals(Node node){
		if(node == null||this==null){
			return false;
		}
		if(this == node){
			return true;
		}
		else if(this.book.equals(node.book)){
			return true;
		}
		else{
			return false;
		}
	}
	public int getNodeIndex(Book book, int foot){
		this.foot = foot;
		if(this.next == null){
			return -1;
		}
		else if(this.getNext().getBook().equals(book)){
			return foot;
		}
		else{
			foot++;
			return this.getNext().getNodeIndex(book, foot);
		}
	}
			
			
}
class Link{
	private Node root;
	private int count = 0;
	private int foot = 0;
	//private Node tail;
	public Link(){}
	public Link(Node root){
		this.root = root;
		count++;
		//this.tail = tail;
	}
	public Node getRoot(){
		return this.root;
	}
	//public Node getTail(){
		//return this.tail;
	//}
	//public void setTail(Node tail){
		//this.tail = tail;
	//}
	public int getFoot(){
		return foot;
	}
	public void setFoot(int foot){
		this.foot = foot;
	}
	
	public void setRoot(Node root){
		this.root = root;
	}
	public void add(Node newNode){
		if(this.root == null){
			this.root = newNode;
			//this.tail = newNode;
		}
		else{
			this.root.addNode(newNode);
		}
		count++;
	}
	
	public boolean isEmpty(Link link){
		if(root == null){
			return true;
		}
		return false;
	}
	
	public int getIndex(Book book){
		foot = 0;
		if(book == null){
			return -1;
		}
		else if(root == null){
			return -1;
		}
		else if(root.equals(book)){
			return foot;
		}
		else{
			foot++;
			return root.getNodeIndex(book,foot);
		}
	}
	public String toString(){
		if(this.root == null){
			return null;
		}
		String s = this.root.toString()+"\n";
		Node cur = this.root;
		while(!(cur.getNext() == null)){
			s += cur.getNext().toString()+"\n";
			cur = cur.getNext();
		}
		return s;
	}
		
}

public class bookLink{
	public static void main(String args[]){
		Node root = new Node(new Book("Java",99.8));
		Node n1 = new Node(new Book("android",87.9));
		Node n2 = new Node(new Book("orcal", 100.3));
		Link link = new Link(root);
		link.add(n1);
		link.add(n2);
		System.out.println(link);
		System.out.println(link.getIndex(new Book("Java",99.8)));
		System.out.println(link.getIndex(new Book("orcal",100.3)));
		System.out.println(link.getIndex(new Book("orcsfal", 100.3)));
	}
}