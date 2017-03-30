import java.util.*;


public class FourWayHeap 
{
	public void generateFourWayHeap(HashMap<Integer,Long> hash)
	{
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
		System.out.println("after creating array list");

		for(int i = 3; i < freq_tableArray.size(); i++)
		{
			System.out.println(freq_tableArray.get(i).data + "---->"+ freq_tableArray.get(i).frequency);
		}


		for(int i= (((freq_tableArray.size()-1)/4)+2);i>=3;i--)
		{
			minHeapify(freq_tableArray,i);
		}

		System.out.println("after minheapifying array list");
		for(int i = 3; i < freq_tableArray.size(); i++)
		{
			System.out.println(freq_tableArray.get(i).data + "---->"+ freq_tableArray.get(i).frequency);
		}


		while(freq_tableArray.size()!=4)
		{
			Node nodeObject1 = new Node();
			Node nodeObject2 = new Node();
			Node nodeObject3 = new Node();
			Node nodeObject4 = new Node();
			Node nodeObject5 = new Node();
			nodeObject1 = extractMin(freq_tableArray);
			System.out.println("extractmin 1");
			for(int i = 3; i < freq_tableArray.size(); i++)
			{
				System.out.println(freq_tableArray.get(i).data + "---->"+ freq_tableArray.get(i).frequency);
			}
			nodeObject2 = extractMin(freq_tableArray);
			System.out.println("extractmin 2");
			for(int i = 3; i < freq_tableArray.size(); i++)
			{
				System.out.println(freq_tableArray.get(i).data + "---->"+ freq_tableArray.get(i).frequency);
			}
			nodeObject3 = extractMin(freq_tableArray);
			System.out.println("extractmin 3");
			for(int i = 3; i < freq_tableArray.size(); i++)
			{
				System.out.println(freq_tableArray.get(i).data + "---->"+ freq_tableArray.get(i).frequency);
			}
			nodeObject4 = extractMin(freq_tableArray);
			System.out.println("extractmin 4");
			for(int i = 3; i < freq_tableArray.size(); i++)
			{
				System.out.println(freq_tableArray.get(i).data + "---->"+ freq_tableArray.get(i).frequency);
			}
			nodeObject5.data = 0;
			nodeObject5.frequency = nodeObject1.frequency+nodeObject2.frequency+nodeObject3.frequency+nodeObject4.frequency;
			freq_tableArray.add(nodeObject5);
			System.out.println("after adding new node");
			for(int i = 3; i < freq_tableArray.size(); i++)
			{
				System.out.println(freq_tableArray.get(i).data + "---->"+ freq_tableArray.get(i).frequency);
			}
			int parent = ((freq_tableArray.size()-1)/2)+2;
			int child = (freq_tableArray.size())-1;
			while(child >3 && freq_tableArray.get(parent).frequency > freq_tableArray.get(child).frequency )
			{
				Collections.swap(freq_tableArray, parent, child);
				child=parent;
				parent = ((child)/2)+2;
			}
			System.out.println("after minheapifying again");
			for(int i = 3; i < freq_tableArray.size(); i++)
			{
				System.out.println(freq_tableArray.get(i).data + "---->"+ freq_tableArray.get(i).frequency);
			}

		}


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
