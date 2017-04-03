
import java.util.*;

public class PairingHeap 
{
	public void generatePairingHeap(HashMap<Integer,Long> hash, String fileNames)
	{
		Testing test = new Testing();

		ArrayList<PairingHeapNode> freq_tableArray = new ArrayList<PairingHeapNode>();
		for(Map.Entry<Integer,Long> entry : hash.entrySet())
		{
			PairingHeapNode nodeObject = new PairingHeapNode();
			nodeObject.dataNode.data = entry.getKey();
			nodeObject.dataNode.frequency = entry.getValue();
			freq_tableArray.add(nodeObject);
//			System.out.println("After inserting an element");
//			test.displayPairing(freq_tableArray);
		}
	
		
		while(freq_tableArray.size()>1)
		{
		PairingHeapNode nodeObject1 = new PairingHeapNode();
		PairingHeapNode nodeObject2 = new PairingHeapNode();
		PairingHeapNode nodeObject3 = new PairingHeapNode();
		nodeObject1= freq_tableArray.remove(0);
		nodeObject2 = freq_tableArray.remove(0);
		nodeObject3 = meldHeap(nodeObject1,nodeObject2);
		
		freq_tableArray.add(nodeObject3);
//		System.out.println("After adding the element");
//		test.displayPairing(freq_tableArray);
		
		}
		test.displayPairing(freq_tableArray);
		
	
		
		
		
	}
	
//	public ArrayList<PairingHeapNode> twoPassScheme(ArrayList<PairingHeapNode> arrayList)
//	{
//		while(arrayList.size()>1)
//		{
//			PairingHeapNode nodeObject1 = arrayList.remove(arrayList.size()-1);
//			PairingHeapNode nodeObject2 = arrayList.remove(arrayList.size()-1);
//			PairingHeapNode nodeObject3 = meldHeap(nodeObject1, nodeObject2);
//			
//			
//			
//		}
//	}
	
	
	public PairingHeapNode  meldHeap(PairingHeapNode object1, PairingHeapNode object2)
	{
		if(object1.dataNode.frequency < object2.dataNode.frequency)
		{
			if (object1.child != null)
			{
			object1.child.leftSibling = object2;
			object2.rightSibling = object1.child;
			
			}
			
				object1.child = object2;
				object2.leftSibling = object1;
				return object1;
				
			
		}
		else
		{
			if (object2.child != null)
			{
			object2.child.leftSibling = object1;
			object1.rightSibling = object2.child;
			}
				object2.child = object1;
				object1.leftSibling = object2;
				return object2;
		}
			
	}
	public void extractMin(ArrayList<PairingHeapNode> arrayList)
	{
		
		
	}
	public void minHeapify(ArrayList<PairingHeapNode> arrayList, int i)
	{
		
	}
	

}
