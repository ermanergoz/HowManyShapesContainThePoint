public abstract class Shape
{
    double centerXaxis;
    double centerYaxis;
    double sideLength;

    //Constructor
    public Shape(double _centerXaxis, double _centerYaxis, double _sideLength)
    {
        this.centerXaxis=_centerXaxis;
        this.centerYaxis=_centerYaxis;
        this.sideLength=_sideLength;
    }

    //Function to check if given point is in the shape or not. Implemented in children ckasses
    public abstract boolean checkShape(double pointX, double pointY);
}