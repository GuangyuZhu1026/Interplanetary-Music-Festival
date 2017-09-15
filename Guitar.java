

public class Guitar 
{
	private int numbStr, songLength;
	private double songArray[][];
	
	public Guitar(int numbStr, int songLength) throws Exception
	{
		this.numbStr = numbStr;
		this.songLength = songLength;
		songArray = new double[numbStr+1][songLength];
		
		System.out.println("Guitar(): Generated new guitar with "
				+ this.numbStr + " strings. Song length is "
				+ songLength + " chords.");
		generateSong();
		printStr();
		simulateSong();
	}
	
	public void generateSong()
	{
		for (int i=0; i < numbStr; i++)
		{
			for(int j=0; j < songLength;j++)
			{
				songArray[i][j]= Math.random()*(4186-27.5)+27.5;
			}
		}
		
		for(int i = 0; i < songLength; i++)
		{
			double temp = (Math.random()*2 + 1);
			/*temp = (int)(temp + 0.5);
			temp /= 10;*/
			songArray[numbStr][i] = temp; 
		}
	}

	public void printStr()
	{
		for(int i = 0; i < numbStr; i++)
		{	
			for(int j = 0; j < songLength; j++)
			{
				//double k = songArray[i][j];
				//k = ((int)(k * 100 + 0.5))/100.0;
				System.out.printf("%7.2f ", songArray[i][j]);
				
			}
			//x += "\n";
			System.out.println();
		}
		for(int j = 0; j < songLength; j++)
		{
			//double k = songArray[numbStr][j];
			//k = ((int)(k * 100 + 0.5))/100.0;
			System.out.printf("%6.1f  ", songArray[numbStr][j]);
		}
		System.out.println();
	}
	
	public void simulateSong() throws Exception
	{
		System.out.println("\nGuitar.simulateSong()");
		for(int j = 0; j < songLength; j++)
		{
			for(int i = numbStr-1; i >= 0; i--)
			{
				System.out.printf(" %7.1f", songArray[i][j]);
			}
			double temp = songArray[numbStr][j];
			int beats = 0;
			String s = "";
			while(temp > 0)
			{
				temp -= 1;
				beats++;
			}
			Thread.sleep((long)(beats * 1000));
			for(int k = 0; k < beats; k++)
				s += ".";
			System.out.println(s);
		}
	}

	public double[] getChordAsArray(int choice)
	{
		double[] colomn = new double[numbStr];
		if(choice > songLength || choice <= 0)
		{
			System.out.println("No such chord!");
			return null;
		}
		else
		{
			for(int i = 0; i < numbStr; i++)
			{
				colomn[i] = songArray[i][choice-1];
			}
			return colomn;
		}
		
	}

	public int getNumbStr()
	{
		return numbStr;
	}
	
	public int getSongLength()
	{
		return songLength;
	}
	
	public double[][] getArray()
	{
		return songArray;
	}
}
