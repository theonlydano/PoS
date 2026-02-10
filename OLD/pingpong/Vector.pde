class Vector{
 public float x;
 public float y;
 
 public Vector(float x, float y){
  this.x = x;
  this.y = y;
 }
 
 public void addVector(Vector v){
  this.x += v.x;
  this.y += v.y;
 }
}
