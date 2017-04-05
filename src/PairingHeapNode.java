import java.util.*;

public class PairingHeapNode 
{
	
	Node dataNode;
	ArrayList<PairingHeapNode> children;
	
	
	public PairingHeapNode()
	{
		children = new ArrayList<PairingHeapNode>();
		dataNode = new Node();
	}
}
