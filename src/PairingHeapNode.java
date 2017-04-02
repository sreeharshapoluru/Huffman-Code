
public class PairingHeapNode 
{
	PairingHeapNode child;
	PairingHeapNode leftSibling;
	PairingHeapNode rightSibling;
	Node dataNode;
	
	
	public PairingHeapNode()
	{
		child = null;
		leftSibling = null;
		rightSibling = null;
		dataNode = new Node();
	}
}
