import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;

/* Connor Shea */

public class Cloud {
  private ArrayList<Point> points;  
  private boolean debug = false;
  
  /**
   * Given Constructor
   */
  public Cloud() {
    points = new ArrayList<Point>();
  }

  public void setDebug(Boolean debug) {
    this.debug = debug; 
  }
  
  /**
   * @return whether cloud is empty or not
   */
  public boolean isEmpty() {
    return this.points.isEmpty();
  }

  /**
   * @return number of points in the cloud
   */
  public int size() {
	  return this.points.size();
  }

  /**
   * 
   * @param p a Point
   * @return whether p in the cloud
   */
  public boolean hasPoint(Point p) {
    return this.points.contains(p);
  }

  /**
   * 
   * @param p
   * if p not in points, add p ***at the end*** of points (to keep same order)
   */
  public void addPoint(Point p) {
    this.points.add(p);
  }

  //Given Cloud.toString
  public String toString() {
    return points.toString();
  }

  /**
   * 
   * @return an array of doubles: left, right, top, and bottom of points, 
   *         null for empty cloud
   */
  public double[] extremes() {

    if (this.isEmpty()) {
      return null;
    }

    double left = 0;
    double right = 0;
    double top = 0;
    double bottom = 0;

    for (int i = 0; i < this.size(); i++) {
      Point p = this.points.get(i);
      if (p.getX() > right) {
        right = p.getX();
      }

      if (p.getX() < left) {
        left = p.getX();
      }

      if (p.getY() > top) {
        top = p.getY();
      }

      if (p.getY() < bottom) {
        bottom = p.getY();
      }
    }

    double[] extremeValues = new double[4];
    extremeValues[0] = left;
    extremeValues[1] = right;
    extremeValues[2] = top;
    extremeValues[3] = bottom;
    
    return extremeValues;
  }
  
  /**
   * 
   * @return: if (cloud not empty) create and return the center point
   *          else null;
   */
  public Point centerP() {
    double[] center = new double[2];
    center[0] = 0.0;
    center[1] = 0.0;

    for (int i = 0; i < this.size(); i++) {
      Point p = this.points.get(i);
      center[0] += p.getX();
      center[1] += p.getY();
    }

    center[0] = center[0] / this.size();
    center[1] = center[1] / this.size();

    return new Point(center[0], center[1]);
  }

  /**
   * 
   * @return minimal distance between 2 points in the cloud
   *         0.0 for a cloud with less than 2 points
   */
  public double minDist() {
    if (this.size() < 2) {
      return 0.0;
    }

    double minDistance = Double.POSITIVE_INFINITY;

    for (int i = 0; i < this.size(); i++) {
      Point p1 = this.points.get(i);

      for (int j = 0; j < this.size(); j++) {
        if (i != j) {
          Point p2 = this.points.get(j);
          if (p1.euclidDist(p2) < minDistance) {
            minDistance = p1.euclidDist(p2);
          }
        }
      }
    }

    return minDistance;
  }

  /**
   * 
   * @param p1 
   * @param p2
   * 
   * all Points outside the rectangle, line or point spanned
   * by p1 and p2 are removed
   *  
   */
  public void crop(Point p1, Point p2) {
    for (int i = 0; i < this.size(); i++) {
      Point p = this.points.get(i);
      // If the X values are the same, only compare the Y values.
      if (p1.getX() == p2.getX()) {
        // If the X value of p isn't the same as p1, remove it.
        if (p.getX() == p1.getX()) {
          if ((p.getY() >= p1.getY() && p.getY() <= p2.getY()) || (p.getY() <= p1.getY() && p.getY() >= p2.getY())) {
            continue;
          } else {
            this.points.remove(i);
          }
        } else {
          this.points.remove(i);
        }
      // If the Y values are the same, only compare the X values.
      } else if (p1.getY() == p2.getY()) {
        // If the Y value of p isn't the same as p1, remove it.
        if (p.getY() == p1.getY()) {
          if ((p.getX() >= p1.getX() && p.getX() <= p2.getX()) || (p.getX() <= p1.getX() && p.getX() >= p2.getX())) {
            continue;
          } else {
            this.points.remove(i);
          }
        } else {
          this.points.remove(i);
        }
      // Otherwise do it the normal way.
      } else {
    	  if ((p.getX() >= p1.getX() && p.getX() <= p2.getX()) || (p.getX() <= p1.getX() && p.getX() >= p2.getX()) && ((p.getY() >= p1.getY() && p.getY() <= p2.getY()) || (p.getY() <= p1.getY() && p.getY() >= p2.getY()))) {
    		  continue;
    	  } else {
          this.points.remove(i);
        }
      }
    }
  }
  

  /**
   * @param args:no args
   */
  public static void main(String[] args) {

    Cloud cloud = new Cloud();
    
    cloud.setDebug(false);
    System.out.println("cloud.debug OFF");
    System.out.println("cloud: " + cloud);
    
    if (!cloud.isEmpty()) {
      System.out.println("Error: cloud should be empty!");
    }
    
    if (cloud.extremes() != null) {
      System.out.println("Error: extremes should be null!");
    }
    
    if (cloud.minDist() != 0.0) {
      System.out.println("Error: minDist should return 0.0!");
    }

    Point p31 = new Point(3.0,1.0);
    cloud.addPoint(p31);
    
    Point p22 = new Point(2.0,2.0);
    cloud.addPoint(p22);
      
    Point p42 = new Point(4.0,2.0);
    cloud.addPoint(p42);
    
    Point p33 = new Point(3.0,3.0);
    cloud.addPoint(p33);

    System.out.println("cloud 1: " + cloud);
    
    if (cloud.debug) {
      System.out.println("cloud 1 isEmpty: " + cloud.isEmpty());
      System.out.println("cloud 1 size: " + cloud.size());
    }
    
    System.out.println("center point in cloud: " + cloud.centerP());

    System.out.println("cloud: " + cloud);
    System.out.println("cloud 2: " + cloud);
    

    Point p77 = new Point(7,7);

    if (cloud.hasPoint(p77)) {
      System.out.println("Error: point " + p77 + " should not be in cloud!");
    } else {
      System.out.println("OK: point " + p77 + " is not in cloud");
    }

    double[] extrs = cloud.extremes();

    if (extrs != null) {
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

    System.out.println("cloud 1: " + cloud);
    cloud.crop(p31, p33);
    System.out.println("CROPPED");
    System.out.println("cloud 1: " + cloud);

  }

}
