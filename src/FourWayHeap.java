import java.io.*;
import java.util.*;


public class FourWayHeap 
{
	public void generateFourWayHeap(HashMap<Integer,Long> hash,String fileName)
	{
		
		Testing test = new Testing();
		ArrayList<Node> freq_tableArray = new ArrayList<Node>();

		//		Adding 3 dummy elements into the array list
		for(int i=0;i<3;i++)
		{
			// System.out.println("in dummy");
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
			// System.out.println(nodeObject.data+ "   " + nodeObject.frequency);
			freq_tableArray.add(nodeObject);
		}
		
//				System.out.println("after creating array list");
//				test.displayFourWay(freq_tableArray);
//				System.out.println(freq_tableArray.size());

		// Minheapifying the arraylist
		for(int i= (((freq_tableArray.size()-1)/4)+2);i>=3;i--)
		{
			minHeapify(freq_tableArray,i);
		}

//				System.out.println("after minheapifying array list");
//				test.displayFourWay(freq_tableArray);
//				System.out.println(freq_tableArray.size());

		// Creating the Huffman tree
		while(freq_tableArray.size()>4)
		{
			//System.out.println("in huffman tree");
			Node nodeObject1 = new Node();
			Node nodeObject2 = new Node();


			nodeObject1 = extractMin(freq_tableArray);
						//System.out.println("extractmin 1");
						//test.displayFourWay(freq_tableArray);
			nodeObject2 = extractMin(freq_tableArray);
						//System.out.println("extractmin 2");
						//test.displayFourWay(freq_tableArray);
			Node nodeObject3 = new Node(nodeObject1,nodeObject2);
			freq_tableArray.add(nodeObject3);
						//System.out.println("after adding new node");
						//test.displayFourWay(freq_tableArray);
			int parent = ((freq_tableArray.size()-1)/4)+2;
			int child = (freq_tableArray.size())-1;
			while(child >3 && freq_tableArray.get(parent).frequency > freq_tableArray.get(child).frequency )
			{
				Collections.swap(freq_tableArray, parent, child);
				child=parent;
				parent = ((child)/4)+2;
			}
//						System.out.println("after minheapifying again");
//						test.displayFourWay(freq_tableArray);

			if(freq_tableArray.size() == 4)
			{
				ArrayList<String> nodeCode = new ArrayList<String>();
				HashMap<Integer,StringBuilder> codeTable = new HashMap<Integer,StringBuilder>();
				this.generateCodeTable(codeTable,nodeCode,nodeObject3);
//				for(Map.Entry<Integer, StringBuilder> entry : codeTable.entrySet())
//				{
//					System.out.println(entry.getKey() + "--" + entry.getValue());
//				}
				this.generateEncoderFiles(codeTable, fileName);

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

	public void  generateCodeTable(HashMap<Integer,StringBuilder> hash, ArrayList<String> arrayList, Node root )
	{

		//System.out.println("in generate codetable");

		if(root == null)
			return;
		if(root.leftChild == null && root.rightChild == null )
		{
			StringBuilder code = new StringBuilder();
			for(int i =0;i<arrayList.size();i++)
			{
				code.append(arrayList.get(i));

			}
			hash.put(root.data, code);
		}
		else
		{
			arrayList.add("0");
			this.generateCodeTable(hash,arrayList, root.leftChild);
			arrayList.set(arrayList.size()-1, "1");
			this.generateCodeTable(hash,arrayList, root.rightChild);
			arrayList.remove(arrayList.size()-1);


		}
	}

	public void generateEncoderFiles(HashMap<Integer,StringBuilder> hash, String fileName)
	{

			//System.out.println("in write");

		try

		{
			// generating code_table.txt
			PrintWriter printWriter = new PrintWriter("/home/harsha/code_table.txt", "UTF-8");
			for(Map.Entry<Integer,StringBuilder> entry : hash.entrySet())
			{
				printWriter.println(entry.getKey() + " " + entry.getValue());
			}
			printWriter.close();

			// generating encoded.bin file
			FileReader inputFile = new FileReader(fileName); 
			BufferedReader bufferedInput = new BufferedReader(inputFile);
			
			FileOutputStream fileOutputStream = new FileOutputStream("/home/harsha/encoded.bin");
			


			String inputStr;
			StringBuilder stringBuilder = new StringBuilder();
			while((inputStr=bufferedInput.readLine())!= null)
			{
				stringBuilder.append(hash.get(Integer.parseInt(inputStr)));
			}

			//System.out.println(stringBuilder);
			for(int i =0; i<stringBuilder.length();i+=8)
			{
				String codeString = stringBuilder.substring(i, i+8);
				//System.out.println(codeString);
				int integerCodeString = Integer.parseInt(codeString, 2);
				fileOutputStream.write(integerCodeString);
			}
			
			bufferedInput.close();
			fileOutputStream.close();

		}
		catch(FileNotFoundException exp)
		{
			System.out.println("File Not Found");
			exp.printStackTrace();
		}
		catch(IOException exp)
		{
			System.out.println("Cannot read the file");
			exp.printStackTrace();
		}


	}
}
