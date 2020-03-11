public class Hexagon extends Shape
{
    //Constructor
    public Hexagon(double _centerXaxis, double _centerYaxis, double _sideLength)
    {
        super(_centerXaxis, _centerYaxis, _sideLength);
    }

    @Override
    public boolean checkShape(double pointX, double pointY) 
    {
        if( ! ( pointY <= centerYaxis + (sideLength*Math.sqrt(3))/2.0 &&
                pointY >= centerYaxis - (sideLength*Math.sqrt(3))/2.0 )
          ) //to check if the point is in the boundary of line b and e
        {
            return false;
        }

        double Bx=centerXaxis-((double) sideLength/2.0);        //calculate coordinates of the edges
        double By=centerYaxis+((sideLength*Math.sqrt(3))/2);

        double Ax=centerXaxis-sideLength;
        double Ay=centerYaxis;

        double Cx=centerXaxis+((double) sideLength/2.0);
        double Cy=centerYaxis+((sideLength*Math.sqrt(3))/2);

        double Dx=centerXaxis+sideLength;
        double Dy=centerYaxis;

        double Ex=centerXaxis+((double) sideLength/2.0);
        double Ey=centerYaxis-((sideLength*Math.sqrt(3))/2.0);

        double Fx=centerXaxis-((double) sideLength/2.0);
        double Fy=centerYaxis-((sideLength*Math.sqrt(3))/2.0);

        double m_a = (By - Ay) / (Bx - Ax); //calculating m's of the lines
        double m_c = (Dy - Cy) / (Dx - Cx);
        double m_d = (Ey - Dy) / (Ex - Dx);
        double m_f = (Ay - Fy) / (Ax - Fx);

        double b_a = Ay - m_a * Ax; //calculating b's of the lines
        double b_c = Cy - m_c * Cx;
        double b_d = Dy - m_d * Dx;
        double b_f = Fy - m_f * Fx;

        double y_at_a_x0 = m_a * pointX + b_a;  //what is the line point in the same x position as P? 
        double y_at_c_x0 = m_c * pointX + b_c;
        double y_at_d_x0 = m_d * pointX + b_d;
        double y_at_f_x0 = m_f * pointX + b_f;

        double x_at_a_y0 = (pointY - b_a) / m_a;    //what is the line point in the same y position as P? 
        double x_at_c_y0 = (pointY - b_c) / m_c;
        double x_at_d_y0 = (pointY - b_d) / m_d;
        double x_at_f_y0 = (pointY - b_f) / m_f;

        boolean is_p_right_to_a = (pointX >= x_at_a_y0);    //check the boundaries
        boolean is_p_below_a    = (pointY <= y_at_a_x0);

        boolean is_p_left_to_c  = (pointX <= x_at_c_y0);
        boolean is_p_below_c    = (pointY <= y_at_c_x0);

        boolean is_p_left_to_d  = (pointX <= x_at_d_y0);
        boolean is_p_above_d    = (pointY >= y_at_d_x0);

        boolean is_p_right_to_f = (pointX >= x_at_f_y0);
        boolean is_p_above_f    = (pointY >= y_at_f_x0);

        return (is_p_right_to_a && is_p_below_a && is_p_left_to_c && is_p_below_c && is_p_left_to_d && is_p_above_d && is_p_right_to_f && is_p_above_f);
    }
}