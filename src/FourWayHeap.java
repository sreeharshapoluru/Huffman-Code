import java.util.*;


public class FourWayHeap 
{
	public void generateFourWayHeap(HashMap<Integer,Long> hash)
	{
		Testing test = new Testing();
		ArrayList<Node> freq_tableArray = new ArrayList<Node>();

		//		Adding 3 dummy elements into the array list
		for(int i=0;i<3;i++)
		{
			Node dummyObject= new Node();
			dummyObject.data = 0;
			dummyObject.frequency=0;
			freq_tableArray.add(dummyObject);

		}

		// Adding the elements of hash map to array list 
		for(Map.Entry<Integer,Long> entry : hash.entrySet())
		{
			Node nodeObject = new Node();
			nodeObject.data = entry.getKey();
			nodeObject.frequency = entry.getValue();
			freq_tableArray.add(nodeObject);
		}
//		System.out.println("after creating array list");
//		test.displayFourWay(freq_tableArray);


		for(int i= (((freq_tableArray.size()-1)/4)+2);i>=3;i--)
		{
			minHeapify(freq_tableArray,i);
		}

//		System.out.println("after minheapifying array list");
//		test.displayFourWay(freq_tableArray);


		while(freq_tableArray.size()>4)
		{
			Node nodeObject1 = new Node();
			Node nodeObject2 = new Node();
			

			nodeObject1 = extractMin(freq_tableArray);
//			System.out.println("extractmin 1");
//			test.displayFourWay(freq_tableArray);
			nodeObject2 = extractMin(freq_tableArray);
//			System.out.println("extractmin 2");
//			test.displayFourWay(freq_tableArray);
			Node nodeObject3 = new Node(nodeObject1,nodeObject2);
			freq_tableArray.add(nodeObject3);
//			System.out.println("after adding new node");
//			test.displayFourWay(freq_tableArray);
			int parent = ((freq_tableArray.size()-1)/4)+2;
			int child = (freq_tableArray.size())-1;
			while(child >3 && freq_tableArray.get(parent).frequency > freq_tableArray.get(child).frequency )
			{
				Collections.swap(freq_tableArray, parent, child);
				child=parent;
				parent = ((child)/4)+2;
			}
//			System.out.println("after minheapifying again");
//			test.displayFourWay(freq_tableArray);

		}
		System.out.println("Final output");
		test.displayFourWay(freq_tableArray);


	}
	public void minHeapify(ArrayList<Node> arrayList, int i)
	{
		int minElement =i;
		int child1 = 4*i-8;
		int child2 = 4*i-7;
		int child3 = 4*i-6;
		int child4 = 4*i-5;
		if (child1< arrayList.size() && (arrayList.get(child1).frequency < arrayList.get(i).frequency))
		{
			minElement = child1;
		}
		if (child2< arrayList.size() && (arrayList.get(child2).frequency < arrayList.get(minElement).frequency))
		{
			minElement = child2;
		}
		if (child3< arrayList.size() && (arrayList.get(child3).frequency < arrayList.get(minElement).frequency))
		{
			minElement = child3;
		}
		if (child4< arrayList.size() && (arrayList.get(child4).frequency < arrayList.get(minElement).frequency))
		{
			minElement = child4;
		}

		if (minElement != i)
		{
			Collections.swap(arrayList, i, minElement);
			minHeapify(arrayList, minElement);
		}

	}
	public Node extractMin(ArrayList<Node> arrayList)
	{
		Node minElement = arrayList.get(3);
		Collections.swap(arrayList, 3, (arrayList.size()-1));
		arrayList.remove((arrayList.size()-1));
		minHeapify(arrayList, 3);
		return minElement;

	}






}
