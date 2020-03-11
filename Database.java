import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Database
{
    private final List<Shape> shapeList;        //To contain the objects
    private final List<Character> shapeType;    //To contain the types

    public Database()
    {
        shapeList=new ArrayList<Shape>();
        shapeType=new ArrayList<Character>();
    }

    public void readFile(String filename)   throws FileNotFoundException, InputMismatchException
    {
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
        int numberOfShapes = scanFile.nextInt();

        char typeOfTheShape;
        double centerXaxisToRead;
        double centerYaxisToRead;
        double sideLengthToRead;

        while(numberOfShapes != 0)
        {
            typeOfTheShape = scanFile.next().charAt(0);
            centerXaxisToRead = scanFile.nextDouble();
            centerYaxisToRead = scanFile.nextDouble();
            sideLengthToRead = scanFile.nextDouble();    //In case of circle, this is the radius

            Shape shape = null;

            switch (typeOfTheShape)
            {                                       //Create the objects
                case 'C':
                    shape = new Circle(centerXaxisToRead, centerYaxisToRead, sideLengthToRead);
                    break;
                case 'H':
                    shape = new Hexagon(centerXaxisToRead, centerYaxisToRead, sideLengthToRead);
                    break;
                case 'S':
                    shape = new Square(centerXaxisToRead, centerYaxisToRead, sideLengthToRead);
                    break;
                case 'T':
                    shape = new Triangle(centerXaxisToRead, centerYaxisToRead, sideLengthToRead);
                    break;
                default:
                    System.out.println("One of the Shapes is not recognised!");
                    System.exit(-1);
                    break;
            }
            
            shapeList.add(shape);
            shapeType.add(typeOfTheShape);
            
            --numberOfShapes;
        }
        scanFile.close();
    }

    //Get the point from user and do the necessary operations
    public int checkIfPointInShape() throws InputMismatchException
    {
        int counter=0;

        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Type the coordinates of the point you want to search:\n");
        
        System.out.println("X:\t");        
        double pointToSearchX = userInput.nextDouble();
        
        System.out.println("Y:\t");        
        double pointToSearchY = userInput.nextDouble();
        
        userInput.close();

        for (int i = 0; i < shapeType.size(); ++i)
        {
            if (shapeList.get(i).checkShape(pointToSearchX, pointToSearchY))
                ++counter;
        }
        return counter;
    }

    public void clearList()
    {
        shapeList.clear();
        shapeType.clear();
    }
}