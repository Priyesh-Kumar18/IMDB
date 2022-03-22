//Priyesh Kumar
package Fileread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileRead
{
	// Fields
	private ArrayList<String> lines;

	// Constructor
	public fileRead(String filename)
	{
		lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			while (br.ready())
			{
				lines.add(br.readLine());
			}
		}

		catch (IOException e)
		{
			e.printStackTrace();
		}

		//TODO: Open the filename, read in the data into the lines arraylist, and close the file when done...
	}
	
	// Methods
	public int getNumberOfLines()
	{
		// TODO
		return lines.size();
	}
	
	public String getLine(int index)
	{
		// TODO
		return lines.get(index);
	}
}
