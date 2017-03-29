import java.util.*;
public class Encoder 
{
	public static void main(String[] args)
	{
		GenerateFreqTable generateFT = new GenerateFreqTable();
		HashMap<Integer,Long> freq_table = generateFT.generateFreqTable(args[0]);
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.generateBinaryHeap(freq_table);
	}

}