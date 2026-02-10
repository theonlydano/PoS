class Box extends DrawableObject{
  public float sideLength;
  private int wobberDirection;
  
  public Box(float sideLength){
    this.sideLength = sideLength; 
    this.wobberDirection = 1;
  }
  
  public void update(){
    if(frameCount % 10 == 0){
      wobberDirection *= -1;
    } 
    
    sideLength += wobberDirection;
    
    super.update();
  }
  
  public void paint() {
    fill(0);
    rect(getLocation().getX(), getLocation().getY(), sideLength, sideLength);
  } 
}
