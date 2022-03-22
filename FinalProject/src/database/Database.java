//Priyesh Kumar
package database;

import Fileread.fileRead;
import Filewrite.fileWrite;
import movie.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Database
{
	// Fields
	private ArrayList<Movie> movies;
	
	// Constructor
	public Database(String filename)
	{
		movies = new ArrayList<>();
		fileRead fr = new fileRead(filename);
		for(int i = 0; i < fr.getNumberOfLines(); i++)
		{
			String raw = fr.getLine(i);
			// TODO: Parse using the StringTokenizer here and place into movies as single entries...
				StringTokenizer st = new StringTokenizer(raw,",");
				String[] tokens = new String[st.countTokens()];

				for(int x = 0; x < tokens.length; x++)
				{
					tokens[x] = st.nextToken().trim();
				}

				String titles = tokens[0];
				String actor1 = tokens[1];
				String actor2 = tokens[2];
				String director = tokens[3];
				int years = Integer.parseInt(tokens[4]);
				int runtimes = Integer.parseInt(tokens[5]);

				Movie m = new Movie(titles,actor1,actor2,director,years,runtimes);
				movies.add(m);
		}
	}

	// Methods
	public void addEntry(Movie newEntry)
	{
		// TODO
		movies.add(newEntry);
	}
	
	public void searchByTitle(String title)
	{
		// TODO
		boolean test = false;
		for (Movie movie : movies)
		{
			if (movie.getTitle().equalsIgnoreCase(title))
			{
				System.out.println("Actors: " + movie.getActor1() + ", " + movie.getActor2());
				System.out.println("Director: " + movie.getDirector());
				System.out.println("Year: " + movie.getYear());
				System.out.println("Runtime: " + movie.getRuntime() + " minutes");
				test = true;
			}
		}
		if (!test)
		{
			System.out.println("Title is not found.");
			System.out.println(" ");
		}
	}
	
	public void searchByActor(String actor)
	{
		// TODO
		boolean test = false;
		for (Movie movie : movies)
		{
			if (movie.getActor1().equalsIgnoreCase(actor) || movie.getActor2().equalsIgnoreCase(actor))
			{
				System.out.println("Title: " + movie.getTitle());
				test = true;
			}
		}
		if (!test)
		{
			System.out.println("No titles found for actor.");
			System.out.println(" ");
		}
	}
	
	public void searchByDirector(String director)
	{
		// TODO
		boolean test = false;
		for (Movie movie : movies)
		{
			if (movie.getDirector().equalsIgnoreCase(director))
			{
				System.out.println("Movies: " + movie.getTitle());
				test = true;
			}
		}
		if (!test)
		{
			System.out.println("No titles found for director");
			System.out.println(" ");
		}
	}
	
	public void searchByYear(int year)
	{
		// TODO
		boolean test = false;
		for (Movie movie : movies)
		{
			if (movie.getYear() == year)
			{
				System.out.println("Titles: " + movie.getTitle());
				test = true;
			}
		}
		if (!test)
		{
			System.out.println("No titles found for year");
			System.out.println(" ");
		}
	}
	
	public void searchByRuntime(int runtime)
	{
		// TODO
		boolean test = false;
		for (Movie movie : movies)
		{
			if (movie.getRuntime() == runtime)
			{
				System.out.println("Movies: " + movie.getTitle());
				test = true;
			}
		}
		if (!test)
		{
			System.out.println("Nothing found");
		}
	}

	public void save(String filename)
			throws IOException
	{
		fileWrite fw = new fileWrite(filename);
		for (Movie movie : movies)
		{
			fw.writeLine(movie.getTitle() + ", " + movie.getActor1() + ", " + movie.getActor2() + ", " + movie.getDirector() + ", " + movie.getYear() + ", " + movie.getRuntime());
		}
		fw.saveFile();
	}
}
