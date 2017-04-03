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
								
									tempPointer = tempPointer.leftChild;
								
								else
								{
									if(i != codeArray.size()-1)
										tempPointer.leftChild = new Node(-1,-1);
									else
										tempPointer.leftChild = new Node(Integer.parseInt(code[0]),-1);
								}
									
							}
							else
							{
								if(tempPointer.rightChild != null)
									tempPointer = tempPointer.rightChild;
								else
								{
									if(i == codeArray.size()-1)
										tempPointer.rightChild = new Node(-1,-1);
									else
										tempPointer.rightChild = new Node(Integer.parseInt(code[0]),-1);
								}
									
								
							}
						}
						
					}
					bufferedInput.close();
					this.generateDecodedText(huffmanRoot,encodedBin);
					
					
						
					
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
	
	public void generateDecodedText(Node huffmanRoot, String encodedBin)
	{
		try
		{
			
		
		Node tempRoot = new Node();
		tempRoot = huffmanRoot;
		FileInputStream fileInputStream = new FileInputStream(encodedBin);
		FileOutputStream fileOutputStream = new FileOutputStream("/home/harsha/decoded.txt");
		
		
		//readiong from encoded.bin
		
	    byte []  codeByte = new byte[fileInputStream.available()];
	    fileInputStream.read(codeByte);
	    fileInputStream.close();
	    StringBuilder codeString = new StringBuilder();
	    for(int i=0; i<codeByte.length;i++)
	    {
	    	byte individualByte = codeByte[i];
	    	codeString.append(String.format("%8s", Integer.toBinaryString(individualByte & 0xFF)).replace(' ', '0'));
	    }
	    System.out.println(codeString);
	    
	
		// -------------
		for(int i =0;i< codeString.length();i++)
		{
			if(codeString.charAt(i) == 0)
			{
				tempRoot = tempRoot.leftChild;
				if(tempRoot.leftChild == null && tempRoot.rightChild == null)
				{
					System.out.println(tempRoot.data);
					fileOutputStream.write(tempRoot.data);
					tempRoot = huffmanRoot;
				}
				
			}
			if(codeString.charAt(i) == 1)
			{
				tempRoot = tempRoot.rightChild;
				if(tempRoot.rightChild == null && tempRoot.leftChild == null)
				{
					System.out.println(tempRoot.data);
					fileOutputStream.write(tempRoot.data);
					tempRoot = huffmanRoot;
				}
			}
		}
	//--------------
		
		
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

}
