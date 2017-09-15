
public class Vocalist 
{
	private double[][] melody;
	private int songlength;
	private double midRangeFreq;
	
	public Vocalist(Guitar guitar, double mid)
	{
		midRangeFreq = mid;
		songlength = guitar.getSongLength();
		melody = new double[2][songlength];
		choose(guitar);
		melody[1] = guitar.getArray()[guitar.getNumbStr()];
		System.out.println("Vocalist(): midRangeFreq: " + mid
				+ "Vocalist(): songlength: " + songlength);
		
	}
	
	public void choose(Guitar g)
	{
		melody[0] = new double[(g.getSongLength())];
		int track;
		double minimum, difference;
		for(int i = 0; i < g.getSongLength(); i++)
		{
			track = 0;
			minimum = 5000;
			for(int j = 0; j < g.getNumbStr(); j ++)
			{
				difference = g.getArray()[j][i] - midRangeFreq;
				if(difference < 0)
					difference *= -1;
				if(difference < minimum)
				{
					track = j;
					minimum = difference;
				}
			}
			melody[0][i] = g.getArray()[track][i];
		}
	}
	
	public void sing()
	{
		for(int i = 0; i < songlength; i++)
		{
			StdAudio.playTone(melody[0][i], melody[1][i]);
		}
		StdAudio.close();
	}
	
	public String toString()
	{
		String result = "";
		for(double d : melody[0])
		{
			result += String.format("  %8.2f", d);
		}
		result += "\n";
		for(double d : melody[1])
		{
			result += String.format("  %8.1f", d);
		}
		result += "\n";
		return result;
	}
}
