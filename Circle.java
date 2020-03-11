public class Circle extends Shape
{
    //Constructor
    public Circle(double _centerXaxis, double _centerYaxis, double _radius)
    {
        super(_centerXaxis, _centerYaxis, _radius);
    }

    //Function to check if given point is in the shape or not
   @Override
    public boolean checkShape(double pointX, double pointY)
    {
        double d = Math.sqrt(Math.pow((pointX - centerXaxis), 2) + Math.pow((pointY - centerYaxis), 2));
        //The point (pointX,pointY) is inside of the shape if d<radius, on the shape if d=radius, and outside the
        // shape if d>radius.

        return d <= sideLength;
    }
}