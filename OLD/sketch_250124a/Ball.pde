class Ball{
  private int r;
  private int g;
  private int b;
  public Vector position;
  private Vector speed;
  private float size;
  
  public Ball(float s){
   this.size = s;
   this.position = new Vector(width/2, height/2);
   speed = new Vector(1 , 1);
   
   this.r = 255;
   this.g = 255;
   this.b = 255;
  }
  
  public void update(){
    if(position.x + size/2 >= width || position.x - size/2 <= 0){
      speed.x *= -1;
    }
    if(position.y - size/2 <= 0){
      speed.y *= -1;
    }
    position.addVector(speed);
  }
  public void update(int back){
    //Problem was here
    speed.x *= 1;
    speed.y *= -1;
    
    this.r = (int) random(0, 255);
    this.g = (int) random(0, 255);
    this.b = (int) random(0, 255);
    
  }
  public void update(int back, int bakc){
    speed.y *= (int) random(-1, -1);
  }
  public void update(Vector v){
    speed = v;
  }
  
  public void draw(){
    fill(r, g, b);
    circle(position.x, position.y, size);
    noFill();
  }
}
