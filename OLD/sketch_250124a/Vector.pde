class Vector{
 public float x;
 public float y;
 
 public Vector(float x, float y){
  this.x = x;
  this.y = y;
 }
 
 public void addVector(Vector vector){
   x += vector.x;
   y += vector.y;
 }
 
}
