class Player{
 private Vector position; 
 private float size;
 
 public Player(){
  this.position = new Vector(mouseX, height-10); 
  this.size = 20;
 }
 
 public void update(){
  position.x = mouseX;
 }
 
 public void draw(){
  stroke(255, 255, 255);
  line(position.x - size, 380, position.x + size, 380);
  stroke(0, 0, 0);
 }
 
}
