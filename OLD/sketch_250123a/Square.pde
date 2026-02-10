class Square{
 float x;
 float y;
 float speed;
 float degree;
 float lenght;
 
 public Square(float l){
   y = height/2;
   x = width/2;
   this.lenght = l;
   speed = 2.0;
   degree = 1700.0;
 }
 
 public void update(){
   x += cos(radians(degree)) * speed;
   y += sin(radians(degree)) * speed;
   
   if(y + lenght >= height || y <= 0){
    degree *= -1; 
   }
   if(x + lenght >= width || x <= 0){
    degree += 90; 
   }
 }
 
 public void draw(){
   fill(random(0, 255), random(0, 255), random(0, 255));
   square(x, y, lenght); 
 }
}
