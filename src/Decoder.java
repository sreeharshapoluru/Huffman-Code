


public class Decoder 
{
	public static void main(String [] args)
	{
		//long startTimeFourWay = java.lang.System.nanoTime();
		GenerateDecodedFiles generateDF = new GenerateDecodedFiles();
		generateDF.generateDecodedFiles(args[0], args[1]);
		//long endTimeFourWay= java.lang.System.nanoTime();
		//System.out.println("The elapsed time for Four Way Heap decoding is "+  (float)(endTimeFourWay-startTimeFourWay)/1000000000 + "s");
	}

}
