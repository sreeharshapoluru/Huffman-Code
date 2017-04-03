import java.util.*;
public class BinaryHeap 
{
	public void  generateBinaryHeap( HashMap<Integer,Long> hash,String fileName)
	{
		Testing test = new Testing();

		ArrayList<Node> freq_tableArray = new ArrayList<Node>();
		for(Map.Entry<Integer,Long> entry : hash.entrySet())
		{
			Node nodeObject = new Node();
			nodeObject.data = entry.getKey();
			nodeObject.frequency = entry.getValue();
			freq_tableArray.add(nodeObject);
		}

//		System.out.println("after creating array list");
//		test.displayBinary(freq_tableArray);



		for(int i= (freq_tableArray.size()/2)-1;i>=0;i--)
		{
			minHeapify(freq_tableArray,i);
		}
//		System.out.println("after minheapifying array list");
//		test.displayBinary(freq_tableArray);

		while(freq_tableArray.size()!=1)
		{
			Node nodeObject1 = new Node();
			Node nodeObject2 = new Node();

			nodeObject1 = extractMin(freq_tableArray);
//			System.out.println("extractmin 1");
//			test.displayBinary(freq_tableArray);
			
			nodeObject2 = extractMin(freq_tableArray);
//			System.out.println("extractmin 2");
//			test.displayBinary(freq_tableArray);

			Node nodeObject3 = new Node(nodeObject1,nodeObject2);
			freq_tableArray.add(nodeObject3);
//			System.out.println("after adding new node");
//			test.displayBinary(freq_tableArray);

			int parent = (freq_tableArray.size()/2)-1;
			int child = (freq_tableArray.size())-1;
			while(child >1 && freq_tableArray.get(parent).frequency > freq_tableArray.get(child).frequency )
			{
				Collections.swap(freq_tableArray, parent, child);
				child=parent;
				parent = ((child+1)/2)-1;
			}
//			System.out.println("after minheapifying again");
//			test.displayBinary(freq_tableArray);


		}
		System.out.println("Final output");
		test.displayBinary(freq_tableArray);
		
		
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
		Node minElement = arrayList.get(0);
		Collections.swap(arrayList, 0, (arrayList.size()-1));
		arrayList.remove((arrayList.size()-1));
		minHeapify(arrayList, 0);
		return minElement;

	}

}
