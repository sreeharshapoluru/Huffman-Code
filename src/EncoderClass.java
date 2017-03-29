
public class EncoderClass 
{
	public static void main(String[] args)
	{
		GenerateFreqTable generateFT = new GenerateFreqTable();
		int[] freq_table=generateFT.generateFreqTable(args[0]);
		for(int i=0;i<freq_table.length;i++)
		{
			if(freq_table[i]!=0)
			{
				System.out.println(i + "---");
				System.out.print(freq_table[i]);
			}
		}
	}

}
