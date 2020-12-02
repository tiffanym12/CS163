
import java.util.ArrayList;


/* Tiffany Miao */

public class Cloud {
	private ArrayList<Point> points;	
    private boolean debug = false;
	

	/**
	 * Given Constructor
	 */
	public Cloud(){
		points = new ArrayList<Point>();
	}

	public void setDebug(Boolean debug){
		this.debug = debug;	
	}
	

	//TODO Implement Cloud.isEmpty
	/**
	 * 
	 * @return whether cloud is empty or not
	 */
	public boolean isEmpty(){
		if(this.points.size() == 0) {
			return true;
		} else {
		return false;
		}
	}


	//TODO Implement Cloud.size
	/**
	 * @return number of points in the cloud
	 */
	public int size(){
		return this.points.size();
	}

	
	//TODO Implement Cloud.hasPoint
	/**
	 * 
	 * @param p a Point
	 * @return whether p in the cloud
	 */
	public boolean hasPoint(Point p){
		for(int i = 0; i < points.size(); i++) {
			Point point = points.get(i);
			if(p.equals(point)) 
			return true;
		}
		return false;
	}

	//TODO Implement Cloud.addPoint
	/**
	 * 
	 * @param p
	 * if p not in points, add p ***at the end*** of points (to keep same order)

	 */
	public void addPoint(Point p){
		points.add(p);
	}

	//Given Cloud.toString
	public String toString(){
		return points.toString();
	}

	//TODO Implement Cloud.extremes
	/**
	 * 
	 * @return an array of doubles: left, right, top, and bottom of points, 
	 *         null for empty cloud
	 */
	public double[] extremes(){
		if(isEmpty())
		       return null;
		double[] extremePoints = new double[4];

		Point temp = points.get(0);
		extremePoints[0] = temp.getX();
		extremePoints[1] = temp.getX();
		extremePoints[2] = temp.getY();
		extremePoints[3] = temp.getY();

		for (int i = 0; i < points.size(); i++) {

		       Point point = points.get(i);

		       if(point.getX() < extremePoints[0])
		            extremePoints[0] = point.getX();
		       if(point.getX() > extremePoints[1])
		            extremePoints[1] = point.getX();
		       if(point.getY() > extremePoints[2])
		            extremePoints[2] = point.getY();
		       if(point.getY() < extremePoints[3])
		            extremePoints[3] = point.getY();
		}
		return extremePoints;

		}
	
	
	//TODO Implement Cloud.centerP
	/**
	 * 
	 * @return: if (cloud not empty) create and return the center point
	 *          else null;
	 */
	public Point centerP(){
		Point center = new Point();
		double sumX = 0;
		double sumY = 0;
		for(int i =0; i < points.size(); i++) {
			Point point = points.get(i);
			sumX += point.getX();
			sumY += point.getY();
		}
		return new Point(sumX / points.size(), sumY / points.size());
	}


	//TODO Implement Cloud.minDist
	/**
	 * 
	 * @return minimal distance between 2 points in the cloud
	 *         0.0 for a cloud with less than 2 points
	 */
	public double minDist(){
		if(points.size() < 2)
		       return 0.0;
		
		Point temp1 = points.get(0);
		Point temp2 = points.get(1);
		double minDistance = temp1.euclidDist(temp2);

		for(int i = 0; i < points.size(); i++) {
		       temp1 = points.get(i);
		       for(int j = 0; j < points.size() - i; j++) {
		            temp2 = points.get(j);
		double tempDist = temp1.euclidDist(temp2);
		 if(tempDist != 0 && tempDist < minDistance)
		                 minDistance = tempDist;
		       }
		}
		return minDistance;

		}

	//TODO Implement Cloud.crop
	/**
	 * 
	 * @param p1 
	 * @param p2
	 * 
	 * all Points outside the rectangle, line or point spanned
	 * by p1 and p2 are removed
	 *  
	 */
	public void crop(Point p1, Point p2){
		double top = 0;
		double bottom = 0;
		double right = 0;
		double left = 0;
		
		ArrayList<Point> cropCloud = new ArrayList<Point>();
		
		if(p1.getX() > p2.getX()) {
			right = p1.getX();
			left = p2.getX();
		} else {
			right = p2.getX();
			left = p1.getX();
		} if (p1.getY() > p2.getY()) {
			top = p1.getY();
			bottom = p2.getY();
		} else {
			top = p2.getY();
			bottom = p1.getY();
		}
		for (int i = 0; i < this.size(); i++) {
			Point j = this.points.get(i);
			boolean inside = true;
			if(j.getY() > top || j.getY() < bottom) {
			inside = false;		
			}
			if(j.getX() > right || j.getX() < left) {
				inside = false;
				
			} if(inside) {
				cropCloud.add(this.points.get(i));
			}
		}
		this.points = cropCloud;
 	
	}
	

	/**
	 * @param args:no args
	 */
	public static void main(String[] args) {

		Cloud cloud = new Cloud();
		
		cloud.setDebug(false);
		System.out.println("cloud.debug OFF");
		System.out.println("cloud: " + cloud);
		
		if(!cloud.isEmpty())
			System.out.println("Error: cloud should be empty!");
		
		if(cloud.extremes()!=null)
			System.out.println("Error: extremes should be null!");
		
		if(cloud.minDist()!=0.0)
			System.out.println("Error: minDist should return 0.0!");

			
		Point p31 = new Point(3.0,1.0);
		cloud.addPoint(p31);
		
		Point p22 = new Point(2.0,2.0);
		cloud.addPoint(p22);
			
		Point p42 = new Point(4.0,2.0);
		cloud.addPoint(p42);
		
		Point p33 = new Point(3.0,3.0);
		cloud.addPoint(p33);

		System.out.println("cloud 1: " + cloud);
		
		System.out.println("center point in cloud: " + cloud.centerP());

		System.out.println("cloud: " + cloud);
		System.out.println("cloud 2: " + cloud);
		

		Point p77 = new Point(7,7);
		if (cloud.hasPoint(p77))
			System.out.println("Error: point " + p77 + " should not be in cloud!");
		else
			System.out.println("OK: point " + p77 + " is not in cloud");

		double[] extrs = cloud.extremes();
		if(extrs!=null){
			System.out.println("left: " + extrs[0]);
		    System.out.println("right: " + extrs[1]);
		    System.out.println("top: " + extrs[2]);
		    System.out.println("bottom: " + extrs[3]);
		}
		double minD = cloud.minDist();			
		System.out.printf("min dist in cloud: %5.3f \n", minD);				
		
		System.out.println("Test cloud with 1 point");
		Cloud cloud1 = new Cloud();
		Point p = new Point();
		cloud1.addPoint(p);
	    minD = cloud1.minDist();
		System.out.printf("min dist in cloud1: %5.3f \n",  minD);

	}

}
