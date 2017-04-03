import java.util.*;
public class Encoder 
{
	public static void main(String[] args)
	{
		GenerateFreqTable generateFT = new GenerateFreqTable();
		HashMap<Integer,Long> freq_table = generateFT.generateFreqTable(args[0]);
		
		// Binary Heap
		
//		BinaryHeap binaryHeap = new BinaryHeap();
//		binaryHeap.generateBinaryHeap(freq_table,args[0]);
		
		// 4-way Heap
		
		FourWayHeap fourWayHeap = new FourWayHeap();
		fourWayHeap.generateFourWayHeap(freq_table,args[0]);
		
		// Pairing Heap
//		
//		PairingHeap pairingHeap = new PairingHeap();
//		pairingHeap.generatePairingHeap(freq_table,args[0]);
		
		
	}

}
