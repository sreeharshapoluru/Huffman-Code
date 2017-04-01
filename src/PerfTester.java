import java.util.HashMap;

public class PerfTester {
	
		
	
	public static void main(String[] args)
	{

		GenerateFreqTable generateFT = new GenerateFreqTable();
		HashMap<Integer,Long> freq_table = generateFT.generateFreqTable(args[0]);
		
//		// Binary Heap
		BinaryHeap binaryHeap = new BinaryHeap();
		long startTime = java.lang.System.nanoTime();
		for (int runCount = 0;runCount<10;runCount++)
		{
			binaryHeap.generateBinaryHeap(freq_table);
		}
		
		long endTime = java.lang.System.nanoTime();
		System.out.println("The elapsed time for Binary Heap is "+  (float)(endTime-startTime)/1000000000 + "s");
//	
		
		
		// 4-way Heap
		
		
	
	
	
	
	
	}
	
	
	
	
	
	

}
