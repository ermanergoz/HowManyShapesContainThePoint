public class Triangle extends Shape
{
    //Constructor
    public Triangle(double _centerXaxis, double _centerYaxis, double _sideLength)
    {
        super(_centerXaxis, _centerYaxis, _sideLength);
    }

    //Funcion to check if given point is in the shape or not
    @Override
    public boolean checkShape(double pointX, double pointY)
    {
        double Ax=centerXaxis;
        double Ay=centerYaxis + sideLength / Math.sqrt(3.0);

        double Bx=centerXaxis - sideLength / 2.0;
        double By=centerYaxis - sideLength / ( 2.0 * Math.sqrt(3.0));

        double Cx=centerXaxis + sideLength / 2.0;
        double Cy=centerYaxis - sideLength / ( 2.0 * Math.sqrt(3.0));

        double m_a = (Cy - By) / (Cx - Bx); //calculating m's of the lines
        double m_b = (Ay - Cy) / (Ax - Cx);
        double m_c = (By - Ay) / (Bx - Ax);

        double b_a = By - m_a * Bx; //calculating b's of the lines
        double b_b = Cy - m_b * Cx;
        double b_c = Ay - m_c * Ax;

        double y_at_a_x0 = m_a * pointX + b_a;  // what is the line point in the same x position as P? 
        double y_at_b_x0 = m_b * pointX + b_b;
        double y_at_c_x0 = m_c * pointX + b_c;

        double x_at_b_y0 = (pointY - b_b) / m_b;    // what is the line point in the same y position as P?
        double x_at_c_y0 = (pointY - b_c) / m_c;

        boolean is_p_above_a    = (pointY >= y_at_a_x0);    //for line a

        boolean is_p_left_to_b  = (pointX <= x_at_b_y0);    //for line b
        boolean is_p_below_b    = (pointY <= y_at_b_x0);

        boolean is_p_right_to_c = (pointX >= x_at_c_y0);    //for line c
        boolean is_p_below_c    = (pointY <= y_at_c_x0);

        return (is_p_above_a && is_p_left_to_b && is_p_below_b && is_p_right_to_c && is_p_below_c);
    }
}