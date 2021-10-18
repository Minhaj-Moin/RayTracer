// Starting the RayTracing in OneWeekend in Java to practice my Java Skills as well as to understand what is being done in the Tutorial on a code level.

import java.lang.Math;

public class Main {
  public static void main(String[] args) {
    
    // Set Resolution for the resulting Image
    int width = 640;
    double aspect_ratio = 16.0/9.0;
    int height = (int) (width/aspect_ratio); 

    // Write the header for the file
    System.out.println("P3\n" + width + " " + height + "\n255");


    // Vec3 test1 = new Vec3();
    // Vec3 test2 = new Vec3(5.0, 5.45, 5.3);
    // test2.printerr();
    // test1.printerr();
    // Ray ray1 = new Ray(test1, test2);
    // Vec3 test3 = ray1.at(2);
    // test3.printerr();

    // Camera Setup
    double vwport_height = 1.0;
    double vwport_width  = (int) (vwport_height*aspect_ratio);
    double focal_length = 2.0;

    Vec3 origin = new Vec3(0,0,0);
    Vec3 horizontal = new Vec3(vwport_width, 0 ,0);
    Vec3 vertical = new Vec3(0, vwport_height ,0);
    Vec3 lowLeftCorner = origin.diff(horizontal.div(2)).diff(vertical.div(2)).diff(new Vec3(0,0,focal_length));

    // Fill in color values for each pixel 
    for (int j = height-1; j >= 0; --j){
      for (int i = 0; i<width; ++i){
        double u = (i*1.0)/(width-1);
        double v = (j*1.0)/(height-1);
        Ray r = new Ray(origin, lowLeftCorner.add(horizontal.mult(u)).add(vertical.mult(v)).diff(origin));

        Vec3 color = r.ray_color();
        // color.printerr();
        // Vec3 color = new Vec3((int) (i * 255.99)/width, (int) (j * 255.99)/height, (int) (0.25 * 255.99)/height);
        color.writecolor();
      }
    }

  }
}