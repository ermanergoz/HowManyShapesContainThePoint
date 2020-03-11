public class Square extends Shape
{
    //Constructor
    public Square(double _centerXaxis, double _centerYaxis, double _sideLength)
    {
        super(_centerXaxis, _centerYaxis, _sideLength);
    }

    //Function to check if given point is in the shape or not
    @Override
    public boolean checkShape(double pointX, double pointY)
    {
        if(pointX <= centerXaxis + sideLength / 2.0 &&
           pointX >= centerXaxis - sideLength / 2.0 &&
           pointY <= centerYaxis + sideLength / 2.0 &&
           pointY >= centerYaxis - sideLength / 2.0 )
        {
            return true;
        }

        return false;
    }
}