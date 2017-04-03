import java.io.*;
import java.util.*;

public class GenerateDecodedFiles 
{
	public void generateDecodedFiles(String encodedBin, String codeTable)
	{
		try
		{
					FileReader inputFile = new FileReader(codeTable); 
					BufferedReader bufferedInput = new BufferedReader(inputFile);

					Node huffmanRoot = new Node();
					Node tempPointer = new Node();
					
					String inputStr;
					while((inputStr=bufferedInput.readLine())!= null)
					{
						tempPointer = huffmanRoot;
						ArrayList<Character> codeArray = new ArrayList<Character>();
						String [] code = inputStr.split(" ");
						//System.out.println(code[1]);
						for(int i=0;i<code[1].length();i++)
						{
							codeArray.add(code[1].charAt(i));
						}
						for(int i=0;i<codeArray.size();i++)
						{
							if(codeArray.get(i)== 0)
							{
								if(tempPointer.leftChild != null)
								{
									if(i == codeArray.size()-1)
										tempPointer.leftChild = new Node(-1,-1);
									else
										tempPointer.leftChild = new Node(Integer.parseInt(code[0]),-1);
								}
								else
									tempPointer = tempPointer.leftChild;
							}
							else
							{
								if(tempPointer.rightChild != null)
								{
									if(i == codeArray.size()-1)
										tempPointer.rightChild = new Node(-1,-1);
									else
										tempPointer.rightChild = new Node(Integer.parseInt(code[0]),-1);
								}
								else
									tempPointer = tempPointer.rightChild;
								
							}
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
	}
	
	public void

}
