/**
 *
 * @author Yusuf Erman ERGÖZ
 */

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Main
{
    public static void main(String[] args)
    {
        Database database = new Database();
        
        try
        {
            database.readFile("input.txt");
        }

        catch (FileNotFoundException err)
        {
            System.out.println("Unable to read the input file.\n" + err);
            System.exit(-1);
        }
        catch (InputMismatchException err2)
        {
            System.out.println("Unable to read some of the data.\nCheck input file!" + err2);
            System.exit(-1);
        }
        try
        {
            System.out.println("Number of shapes contain the given point: " + database.checkIfPointInShape());
        }

        catch(InputMismatchException err3)
        {
            System.out.println("Try again! " + err3);
            System.out.println("Number of shapes contain the given point: " + database.checkIfPointInShape());
        }
        database.clearList();
    }
}