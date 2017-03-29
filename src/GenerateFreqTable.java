
import java.io.*;
import java.util.*;

public class GenerateFreqTable 
{
	public HashMap<Integer,Long> generateFreqTable(String fileName)
	{
		HashMap<Integer,Long> countHash = new HashMap<Integer,Long>();
		try
		{
			// Reading the input from the arguments
			FileReader inputFile = new FileReader(fileName); 
			BufferedReader bufferedInput = new BufferedReader(inputFile);

			//Storing frequency count
			String inputStr;
			while((inputStr=bufferedInput.readLine())!= null)
			{
				int input = Integer.parseInt(inputStr);
				if(!countHash.containsKey(input))
				{
					countHash.put(input,(long)1);
				}
				else
				{
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