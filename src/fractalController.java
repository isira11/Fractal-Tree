
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class fractalController {

	public static void main(String[] args) {
		
		//Change these
		int noOfLevels = 13;
		double startingLength = 0.1;
		double pensize = 0.02;
		double StatinPOint = 0.7;
		double startingdirection =60;
		double startingAngle= 20;
		double angle = 40;
		//------------------------
		
		
		
		
		List<Color> colors = new ArrayList<Color>();      		
		for (int r=0; r<100; r++) colors.add(new Color(r*255/100,       100,         0));
		for (int g=100; g>0; g--) colors.add(new Color(      255, g*255/100,         0));
		for (int b=0; b<100; b++) colors.add(new Color(      255,         0, b*255/100));
		for (int r=100; r>0; r--) colors.add(new Color(r*255/100,         0,       255));
		for (int g=0; g<100; g++) colors.add(new Color(        0, g*255/100,       255));
		for (int b=100; b>0; b--) colors.add(new Color(        0,       50, b*255/100));
		                          colors.add(new Color(        0,       255,         0));		
		StdDraw.clear(Color.BLACK);
		StdDraw.setPenRadius(.021);
		StdDraw.setPenColor(colors.get(600));
		StdDraw.line(StatinPOint, 0, StatinPOint, 0.5);
		StdDraw.setPenRadius(pensize);
		List<Point2> points = new ArrayList<Point2>();
		Point2 point = new Point2(StatinPOint, 0.5, startingdirection);
		points.add(point);
		Model model = new Model(points, angle, 0.1,colors);
		for (int i = 0; i < noOfLevels; i++) {

			pensize = pensize/1.7;
			StdDraw.setPenRadius(pensize);
			model = new Model(model.getCurrentPonts(), startingAngle, startingLength,colors);
			startingLength -= 0.007;

			if (startingLength < 0 || pensize <0) {
				break;
			}
		}

	}
}
