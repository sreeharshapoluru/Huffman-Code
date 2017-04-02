import java.util.*;

public class Testing {
	public void displayBinary(ArrayList<Node> arrayList)
	{
		for(int i = 0; i < arrayList.size(); i++)
			{
				System.out.println(arrayList.get(i).data + "---->"+ arrayList.get(i).frequency);
			}
	}
	
	public void displayFourWay(ArrayList<Node> arrayList)
	{
		for(int i = 3; i < arrayList.size(); i++)
			{
				System.out.println(arrayList.get(i).data + "---->"+ arrayList.get(i).frequency);
			}
	}
	
	public void displayPairing(ArrayList<PairingHeapNode> arrayList)
	{
		for(int i = 0; i < arrayList.size(); i++)
			{
				System.out.println(arrayList.get(i).dataNode.data + "---->"+ arrayList.get(i).dataNode.frequency);
			}
	}

}
