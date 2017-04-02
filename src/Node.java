
public class Node {
	 int data;
	 long frequency;
	 Node leftChild = null;
	 Node rightChild = null;
	
	public Node()
	{
		this.leftChild = null;
		this.rightChild = null;
	}
	public Node(Node object1 , Node object2)
	{
		this.data = -1;
		this.frequency = object1.frequency+object2.frequency;
		this.leftChild = object1 ;
		this.rightChild = object2;
		
	}
	

}
