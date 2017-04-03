
import java.io.*;
import java.util.*;

public class GenerateFreqTable 
{
	public HashMap<Integer,Long> generateFreqTable(String fileName)
	{
//		System.out.println("Hello World");
		HashMap<Integer,Long> countHash = new HashMap<Integer,Long>();
		try
		{
			// Reading the input from the arguments
			FileReader inputFile = new FileReader(fileName); 
			BufferedReader bufferedInput = new BufferedReader(inputFile);

			//Storing frequency count
			String inputStr;
//			System.out.println("Hello World");
			while((inputStr=bufferedInput.readLine())!= null)
			{
				inputStr = inputStr.replaceAll("\\s+","");
				//System.out.println("Hello World");
				int input = Integer.parseInt(inputStr);
				if(!countHash.containsKey(input))
				{
					// System.out.println(input);
					countHash.put(input,(long)1);
				}
				else
				{
					// System.out.println("Existing Input"+input);
					long countValue = countHash.get(input);
					countValue++;
					countHash.put(input, countValue);
				}
				
			}
			
			bufferedInput.close();
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

		return countHash;
	}
}