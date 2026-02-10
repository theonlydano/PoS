class Player{
  private color farbe;
  public Vector position;
  private Vector speed;
  private float size;
  
  
  public Player(float size, int r, int g, int b){
    this.size = size;
    this.position = new Vector(0, height - size);
    this.speed = new Vector(0, 0);
    farbe = color(r, g, b);
  }
  
  public void update(){
    if(keyPressed){
      if(key == 'w'){
        speed.y = -1;
      }
      if(key == 's'){
        speed.y = 1;
      }
      if(key == 'a'){
        speed.x = -1;
      }
      if(key == 'd'){
        speed.x = 1;
      }
    }else{
     speed.x = 0;
     speed.y = 0;
    }
    
    position.addVector(speed);
  }
  
  public void draw(){
    fill(farbe);
    rect(position.x, position.y, size, size); 
    noFill();
  }
}
