import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Model {
	private double currentX;
	private double currentY;
	private double direction;
	private double distance;
	private double nextX;
	private double nextY;
	private double angle;
	private double angleBack;
	private Point2 point;
	private Point2 RGB;
	private List<Point2> points = new ArrayList<Point2>();
	private List<Color> col = new ArrayList<Color>();
	int b;
	
	public Model() {

	}

	public Model(List<Point2> p, double a, double l,List<Color> color) {

		for (int i = 0; i < p.size(); i++) {
			this.angle = a;
			this.currentX = (p.get(i)).getX();
			this.currentY = (p.get(i)).getY();
			this.direction = (p.get(i)).getAngle();
			this.angleBack = a;
			this.distance = l;
			this.col = color;
			b=i;
			
			if(b*3>600) {
				b=200;
			}
			drawBranchesAtpoint(b);

		}
	}

	public void drawBranchesAtpoint(int i) {
		branchA(i);
		branchB(i);
	}

	private void angleReset() {
		this.angle = angleBack;
	}

	public void branchA(int i) {
		turnClockWise();
	
		StdDraw.setPenColor((col.get(i*2)));
		StdDraw.line(currentX, currentY, this.nextX, this.nextY);
		point = new Point2(this.nextX, this.nextY, this.angle);
		points.add(point);
		
		System.out.println("/////#######"+points);
	}

	public void branchB(int i ) {
		angleReset();
		turnAntiClockWise();
		StdDraw.setPenColor((col.get(i*3)));
		StdDraw.line(currentX, currentY, this.nextX, this.nextY);
		point = new Point2(this.nextX, this.nextY, this.angle);
		this.points.add(point);

		System.out.println("/////#######"+points);
	

	}

	private void getNewCoodinates() {

		double deltax = Math.cos(((Math.PI / 180)) * (this.angle)) * distance;
		double deltay = Math.sin(((Math.PI / 180)) * (this.angle)) * distance;

		this.nextX = deltax + currentX;
		this.nextY = deltay + currentY;

	}

	public void turnClockWise() {

		this.angle = this.direction - this.angle;
		getNewCoodinates();
	}

	public void turnAntiClockWise() {
		this.angle = this.direction + this.angle;
		getNewCoodinates();
	}

	public List<Point2> getCurrentPonts() {
		return this.points;
	}
	


}
