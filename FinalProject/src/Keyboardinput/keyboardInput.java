//Priyesh Kumar
package Keyboardinput;

import java.io.IOException;
import java.util.Scanner;

public class keyboardInput
{
	// Fields
	private Scanner keyb;
	
	// Constructor
	public keyboardInput()
	{
		keyb = new Scanner(System.in);
	}
	
	// Methods
	public String getKeyboardLine()
			throws IOException
	{
		// TODO: Use the scanner object to acquire a String and return this String to the caller

		String kb = keyb.nextLine();
		return kb;
	}


	
	/* Call this method before you exit the program! Do NOT close the scanner object inside of getKeyboardLine method! */
	public void closeKeyboard()
	{
		keyb.close();
	}
}
