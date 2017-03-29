import java.util.*;
public class BinaryHeap 
{
	public void generateBinaryHeap( HashMap<Integer,Long> hash)
	{

		ArrayList<Node> freq_tableArray = new ArrayList<Node>();
		for(Map.Entry<Integer,Long> entry : hash.entrySet())
		{
			Node nodeObject = new Node();
			nodeObject.data = entry.getKey();
			nodeObject.frequency = entry.getValue();
			freq_tableArray.add(nodeObject);
		}
		
//		System.out.println("after creating array list");
//          
//		for(int i = 0; i < freq_tableArray.size(); i++)
//		{
//		System.out.println(freq_tableArray.get(i).data + "---->"+ freq_tableArray.get(i).frequency);
//		}
		
		//System.out.println("after printing  array list");
		
		for(int i= (freq_tableArray.size()/2)-1;i>=0;i--)
		{
			minHeapify(freq_tableArray,i);
		}
		
// System.out.println("after minheapifying array list");
		
//		for(int i = 0; i < freq_tableArray.size(); i++)
//		{
//		System.out.println(freq_tableArray.get(i).data + "---->"+ freq_tableArray.get(i).frequency);
//		}
//		
//		System.out.println("after printing  array list again");

	}
	public void minHeapify(ArrayList<Node> arrayList, int i)
	{
		int minElement =i;
		int l = 2*i+1;
		int r = 2*i+2;
		if (l< arrayList.size() && (arrayList.get(l).frequency < arrayList.get(i).frequency))
		{
			minElement = l;
		}
		if (r<arrayList.size() && (arrayList.get(r).frequency < arrayList.get(minElement).frequency))
		{
			minElement = r;
		}
		if (minElement != i)
		{
			Collections.swap(arrayList, i, minElement);
		    minHeapify(arrayList, minElement);
		}
		
	}
	public Node extractMin(ArrayList<Node> arrayList)
	{
		
	}
	
}
