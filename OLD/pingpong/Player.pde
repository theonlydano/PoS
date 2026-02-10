class Player{
  public Vector position;
  
  public Player(){
    position = new Vector(mouseX, mouseY);
  }
  
  public void draw(){
    stroke(255, 255, 255);
    line(position.x, position.y - 20, position.x, position.y + 20);
    noStroke(); 
  }
  
  public void playerUpt(){
    position.x = width - 20;
    position.y = mouseY;
  }
  
  public void playerCom(Vector v){
   position.x = 20;
   position.y = v.y; 
  }
}
