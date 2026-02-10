class Ball{
  public Vector position;
  private Vector speed;
  
  public Ball(){
   position = new Vector(width/2, height/2);
   speed = new Vector(2, 2);
  }
  
  public void update(Vector v){
   position.addVector(speed); 
   
   /*
   if(position.x == v.x && position.y >= v.y - 200 && position.y <= v.y + 200){
     speed.x *= -1;
     speed.x *= 1.1;
   }
   */
   
   if(position.x >= v.x - 10 && position.x < v.x + 10 && position.y >= v.y - 20 && position.y <= v.y + 20){
     speed.x *= -1;
     speed.x *= 1.1;
   }
   
   if(position.y >= height - 10 || position.y <= 0 + 10){
     speed.y *= -1;
     speed.y *= 1;
   }
  }
  
  public void draw(){
   circle(position.x, position.y, 20); 
  }
}
