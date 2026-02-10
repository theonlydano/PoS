class Vector{
  public float x;
  public float y;
  
  public Vector(float x, float y){
    this.x = x;
    this.y = y;
  }
  
  public void addVector(Vector addedVector){
    this.x += addedVector.x;
    this.y += addedVector.y;
  }
  
}
