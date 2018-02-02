import java.util.Objects;
import java.text.DecimalFormat;

public class Point2 {

    private double x;
    private double y;
    private double Angle;
    

    public Point2() {
        this.set(0.0, 0.0,0.0);
    }
   

    public Point2(double newX, double newY, double newAngle) {
        this.set(newX, newY, newAngle);
    }
    

    public Point2(Point2 other) {
        this(other.x, other.y,other.Angle);
    }

    public double getX() {
        return this.x;
    }
    
  
    public double getY() {
        return this.y;
    }
    
    
    public double getAngle() {
        return this.Angle;
    }

    public void setX(double newX) {
        this.x = newX;
    }
    
  
    public void setY(double newAngle) {
        this.y = newAngle;
    }
    
    public void setAngle(double newAngle) {
        this.y = newAngle;
    }
    
    
    

    public void set(double newX, double newY, double newAngle) {
        this.x = newX;
        this.y = newY;
        this.Angle = newAngle;
    }
    

    @Override
    public String toString() {
    	DecimalFormat df = new DecimalFormat("#.00"); 
        String s = String.format("(%s, %s, %s)", df.format(this.getX()), df.format(this.getY()),this.Angle);
        return s;
    }


}
