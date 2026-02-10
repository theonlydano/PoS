class GravitationalBall{
 float x;
 float y;
 float speed;
 float degree;
 float radius;
 float gravity = 5;
 
  public GravitationalBall(float speed, float radius){
   y = height/2;
   x = width/2;
   this.speed = speed;
   this.radius = radius;
   degree = 45.0;
   }
   
   public void update(){
     x += cos(radians(degree)) * speed;
     y += sin(radians(degree)) * speed;
     y += gravity;
     
     if(y + radius/2 >= height || y - radius/2 <= 0){
      degree *= -1; 
      gravity = 5;
     }else{
      gravity -= 0.1; 
     }
     if(x + radius/2 >= width || x - radius/2 <= 0){
      degree += 90; 
     }
   }
   
   public void draw(){
     fill(255, 255, 255);
     circle(x, y, radius);
     noFill();
   }
     
}
