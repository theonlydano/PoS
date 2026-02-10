class Block{
 public Vector position;
 private float lenght;
 
 public Block(Vector v){
  this.position = v;
  lenght = width/50;
 }
 
 public void draw(){
  fill(random(250, 255), random(250, 100), random(250, 255));
  square(position.x, position.y, lenght); 
  noFill();
 }
 
}
