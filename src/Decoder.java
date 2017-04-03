import java.util.*;


public class Decoder 
{
	public static void main(String [] args)
	{
		GenerateDecodedFiles generateDF = new GenerateDecodedFiles();
		generateDF.generateDecodedFiles(args[0], args[1]);
	}

}
