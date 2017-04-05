
import java.util.*;

public class PairingHeap 
{
	PairingHeapNode pairingHeapRoot;
	int nodesSize;
	public PairingHeap()
	{
		pairingHeapRoot = null;
		nodesSize = 0;
		
	}
	public void generatePairingHeap(HashMap<Integer,Long> hash, String fileNames)
	{
		
		Testing test = new Testing();

		ArrayList<Node> freq_tableArray = new ArrayList<Node>();
		for(Map.Entry<Integer,Long> entry : hash.entrySet())
		{
			Node nodeObject = new Node();
			nodeObject.data = entry.getKey();
			nodeObject.frequency = entry.getValue();
			freq_tableArray.add(nodeObject);
//			System.out.println("After inserting an element");
//			test.displayPairing(freq_tableArray);
		}
		
		
		for(int i=0;i<freq_tableArray.size();i++)
		{
			Node tempNode = new Node();
			PairingHeapNode tempPairingHeapNode = new PairingHeapNode();
			tempNode.data = freq_tableArray.get(i).data;
			tempNode.frequency = freq_tableArray.get(i).frequency;
			tempPairingHeapNode.dataNode = tempNode;
			this.meldHeap(tempPairingHeapNode);
		}
		while(nodesSize >1 )
		{
			Node nodeObject1 = new Node();
			Node nodeObject2 = new Node();
			PairingHeapNode pairingHeapNodeObject = new PairingHeapNode();
			Node nodeObject3 = new Node();
			nodeObject1 = this.extractMin();
			nodeObject2 = this.extractMin();
			long freq = nodeObject1.frequency+nodeObject2.frequency;
			nodeObject3.frequency = freq;
			nodeObject3.data =-1;
			pairingHeapNodeObject.dataNode = nodeObject3;
			this.meldHeap(pairingHeapNodeObject);
		}
	
		
		
		
	}
	
	public   void meldHeap(PairingHeapNode nodeObject)
	{
		if(pairingHeapRoot == null)
				pairingHeapRoot = nodeObject;
		
		else if(pairingHeapRoot.dataNode.frequency< nodeObject.dataNode.frequency)
		{
			pairingHeapRoot.children.add(nodeObject);
		}
		else
		{
			nodeObject.children.add(pairingHeapRoot);
			pairingHeapRoot = nodeObject;
		}
		nodesSize++;
	
			
	}
	public Node extractMin()
	{
		//System.out.println(nodesSize);
		Node minNode = pairingHeapRoot.dataNode;
		ArrayList<PairingHeapNode> tempArrayList = new ArrayList<PairingHeapNode>();
		for(int i=pairingHeapRoot.children.size()-1;i>0;i=i-2)
		{
			if(pairingHeapRoot.children.get(i).dataNode.frequency > pairingHeapRoot.children.get(i-1).dataNode.frequency)
			{
				tempArrayList.add(pairingHeapRoot.children.get(i-1));
				pairingHeapRoot.children.get(i-1).children.add(pairingHeapRoot.children.get(i));
			}
			else
			{
				tempArrayList.add(pairingHeapRoot.children.get(i));
				pairingHeapRoot.children.get(i).children.add(pairingHeapRoot.children.get(i-1));
			}
			pairingHeapRoot.children.remove(pairingHeapRoot.children.size()-1);
			pairingHeapRoot.children.remove(pairingHeapRoot.children.size()-1);
			
		}
			if(pairingHeapRoot.children.size()>0)
			{
				tempArrayList.add(pairingHeapRoot.children.get(pairingHeapRoot.children.size()-1));
				pairingHeapRoot.children.remove(pairingHeapRoot.children.size()-1);
				
			}
			PairingHeapNode tempRoot = null;
			//System.out.println("temparray size"+ tempArrayList.size());
			if(tempArrayList.size()>0)
			{
				tempRoot = tempArrayList.get(tempArrayList.size()-1);
				for(int i=tempArrayList.size()-2;i>=0;i--)
				{
					if(tempArrayList.get(i).dataNode.frequency > tempRoot.dataNode.frequency)
						tempRoot.children.add(tempArrayList.get(i));
					else
					{
						tempArrayList.get(i).children.add(tempRoot);
						tempRoot = tempArrayList.get(i);
					}
				}
			}
			this.pairingHeapRoot = tempRoot;
			nodesSize--;
			return minNode;
			
		}
	
		
	}
	
	


