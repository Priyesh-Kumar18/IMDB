//Priyesh Kumar
package Main;

import database.Database;
import Keyboardinput.keyboardInput;
import movie.Movie;

import java.io.IOException;
import java.util.Locale;

public class FinalProject
{
    public static void main(String[] args) throws IOException {
        Database d = new Database("db.txt");
        keyboardInput k = new keyboardInput();

        boolean test = true;
        while (test)
        {
            p(" ");
            p("Welcome to Priyesh Movie Database! (PMDB)");
            p("This is a movie database system to search or add movies");
            p("Type the letter to do that action");
            p("Choose option a-g");
            p("a) Add Entry");
            p("b) Search by Title");
            p("c) Search by Actor");
            p("d) Search by Director");
            p("e) Search by Year");
            p("f) Search by Runtime (in minutes)");
            p("g) Quit");
            p("");

            String choice = k.getKeyboardLine().toLowerCase(Locale.ROOT);

            switch (choice)
            {
                case "a":
                    p("Enter Title Name: ");
                    String title = k.getKeyboardLine();
                    if (title.length() < 3)
                    {
                        p("Please try again");
                        p("Enter Title Name: ");
                        title = k.getKeyboardLine();
                    }

                    p("Enter actor1: ");
                    String actor1 = k.getKeyboardLine();


                    p("Enter actor 2: ");
                    String actor2 = k.getKeyboardLine();


                    p("Enter director: ");
                    String director = k.getKeyboardLine();

                    p("Enter year: ");
                    int year = Integer.parseInt(k.getKeyboardLine());

                    p("Enter runtime (in minutes)");
                    int runtimeMinutes = Integer.parseInt(k.getKeyboardLine());

                    Movie n = new Movie(title, actor1, actor2, director, year, runtimeMinutes);
                    d.addEntry(n);
                    break;

                case "b":
                    System.out.println("Enter Title Name: ");
                    d.searchByTitle(k.getKeyboardLine());
                    break;

                case "c":
                    System.out.println("Enter Actor name: ");
                    d.searchByActor(k.getKeyboardLine());
                    break;

                case "d":
                    System.out.println("Enter Director Name");
                    d.searchByDirector(k.getKeyboardLine());
                    break;

                case "e":
                    System.out.println("Enter Year");
                    int year2 = Integer.parseInt(k.getKeyboardLine());
                    d.searchByYear(year2);
                    break;

                case "f":
                    System.out.println("Enter Runtime");
                    int runtime = Integer.parseInt(k.getKeyboardLine());
                    d.searchByRuntime(runtime);
                    break;

                case "g":
                    test = false;
                    d.save("db.txt");
                    p("Closed program");
                    break;

                default:
                    p("Wrong Input");
            }
        }
        k.closeKeyboard();
    }

    public static <E> void p(E item)
    {
        System.out.println(item);
    }

}


