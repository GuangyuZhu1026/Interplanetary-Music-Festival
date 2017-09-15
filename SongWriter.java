

public class SongWriter 
{
	public static void main(String[] args) throws Exception
	{
		int numbStr, songLength;
		double voiceRange;
		
		numbStr = Integer.parseInt(args[0]);
		songLength = Integer.parseInt(args[1]);
		voiceRange = Double.parseDouble(args[2]);
		
		Guitar guitar = new Guitar(numbStr, songLength);
		
		Vocalist singer = new Vocalist(guitar, voiceRange);
		
		System.out.println(singer.toString());
		
		singer.sing();
	}
}
