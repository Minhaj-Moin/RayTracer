import java.lang.Math;

public class Ray {
  private Vec3 org;
  private Vec3 dest;
  private double t;

  public Ray(){
    org = new Vec3();
    dest = new Vec3();
  }
  public Ray(double x1,double y1, double z1, double x2,double y2, double z2){
    this.org = new Vec3(x1,y1,z1);
    this.dest = new Vec3(x2,y2,z2);
  }
  public Ray(Vec3 org, Vec3 dest){
    this.org = org;
    this.dest = dest;
  }
  public Vec3 at(double t) {return org.add(dest.mult(t));}
  public Vec3 direction() {return this.dest;}
  public Vec3 origin() {return this.org;}
  public Vec3 ray_color()
  {
    Vec3 unitDir = this.dest.unit_v();
    double t = 0.5*(unitDir.y() + 1.0);
    return (new Vec3(1.0, 1.0, 1.0).mult(1.0-t)).add(new Vec3(0, 0, 0.5).mult(t));
  }
}