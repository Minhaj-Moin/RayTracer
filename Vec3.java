import java.lang.Math;

public class Vec3 {
  private double x, y, z;
  public Vec3(){
    x = 0.0;
    y = 0.0;
    z = 0.0;
  }
  public Vec3(double x,double y, double z){
    this.x = x;
    this.y = y;
    this.z = z;
  }
  public double magnitude(){
    return Math.sqrt(x*x + y*y + z*z);
  }
  public Vec3 mult_(double t){
    this.x *= t;
    this.y *= t;
    this.z *= t;
    return this;
  }
  public Vec3 diff_(Vec3 v){
    this.x -= v.x;
    this.y -= v.y;
    this.z -= v.z;
    return this;
  }
  public Vec3 add_(Vec3 v){
    this.x += v.x;
    this.y += v.y;
    this.z += v.z;
    return this;
  }
  public Vec3 div_(double t){
    this.x /= t;
    this.y /= t;
    this.z /= t;
    return this;
  }
  public Vec3 mult(double t){
    return new Vec3(Math.round(this.x * t * 10000.0)/10000.0,Math.round(this.y * t * 100.0)/100.0, Math.round(this.z * t * 10000.0)/10000.0);
  }
  public Vec3 diff(Vec3 v){
    return new Vec3(this.x - v.x,this.y - v.y,this.z - v.z);
  }
  public Vec3 add(Vec3 v){
    return new Vec3(this.x + v.x,this.y + v.y,this.z + v.z);
  }
  public Vec3 div(double t){
    return new Vec3(this.x/t,this.y/t,this.z/t);
  }
  public Vec3 unit_v(){
    double t = this.magnitude();
    return new Vec3(this.x/t,this.y/t,this.z/t);
  }

  public double dot(Vec3 v){
    return (x*v.x + y*v.y + z*v.z);
  }

  public Vec3 cross(Vec3 v){
    return new Vec3(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
  }

  public void writecolor(){
    System.out.println((int)(x*255.99)%255 + " " + (int)(y*255.99)%255 + " " + (int)(z*255.99)%255);
  }
  public void printerr(){
    // System.err.println(x + " " + y + " " + z);
    System.err.println((int)(x*255.99)%256 + " " + (int)(y*255.99)%256 + " " + (int)(z*255.99)%256);
  }
  public double x() {return this.x;}
  public double y() {return this.y;}
  public double z() {return this.z;}

}