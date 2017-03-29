
import java.io.*;

public class GenerateFreqTable 
{
	public int [] generateFreqTable(String fileName)
	{
		int[] countArray = new int[1000000];
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
				countArray[input]+=1;
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

		return countArray;
	}
}