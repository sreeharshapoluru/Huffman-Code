import java.util.HashMap;

public class PerfTester {
	
		
	
	public static void main(String[] args)
	{

		GenerateFreqTable generateFT = new GenerateFreqTable();
		HashMap<Integer,Long> freq_table = generateFT.generateFreqTable(args[0]);
		
	// Binary Heap
//		BinaryHeap binaryHeap = new BinaryHeap();
//		long startTimeBinary = java.lang.System.nanoTime();
//		for (int runCount = 0;runCount<10;runCount++)
//		{
//			binaryHeap.generateBinaryHeap(freq_table,args[0]);
//		}
//		
//		long endTimeBinary = java.lang.System.nanoTime();
//		System.out.println("The elapsed time for Binary Heap is "+  (float)(endTimeBinary-startTimeBinary)/1000000000 + "s");
//	
		
		
		// 4-way Heap
	
			FourWayHeap fourWayHeap = new FourWayHeap();
				long startTimeFourWay = java.lang.System.nanoTime();
			for (int runCount = 0;runCount<10;runCount++)
			{
					fourWayHeap.generateFourWayHeap(freq_table,args[0]);
			}
				
				long endTimeFourWay= java.lang.System.nanoTime();
				System.out.println("The elapsed time for Four Way Heap encoding is "+  (float)(endTimeFourWay-startTimeFourWay)/1000000000 + "s");
		
				

				
				
				// Pairing Heap
				
				
				
	
	
	
	}
	
	
	
	
	
	

}
