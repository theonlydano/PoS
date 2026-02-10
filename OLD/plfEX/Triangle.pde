class Triangle{
  private float size;
  private float x;
  private float y;
  
  public Triangle(float x, float y, float size){
    this.x = x;
    this.y = y;
    this.size = size;
  }
  
  public void draw(){
    triangle(x - size, y, x, y + size, x + size, y); 
  }
}
