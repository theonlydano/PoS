class Ellipse extends DrawableObject{
  public float sideLengthX;
  public float sideLengthY;
  private color myColor;
  private float wobber;
  
  public Ellipse(float sideLength){
    this.sideLengthX = sideLength; 
    this.sideLengthY = sideLength;
    myColor = color(255, 255, 0);
    wobber = sideLength/20;
  }
  
  @Override // überschreiben
  public void update(){
    // your turn: Change randomly Color every 100 Frames
    if(frameCount % 100 == 0){
      myColor = color(random(0, 255), random(0, 255), random(0, 255)); 
    }
    
    super.update(); // call the update within DrawableObject
    
    if(frameCount % 10 == 0){
      wobber *= -1;
    }
    
    sideLengthX += wobber; 
    sideLengthY -= wobber;
  }
  
    public void paint() {
        fill(myColor);
        ellipse(getLocation().getX(), getLocation().getY(), sideLengthX, sideLengthY);
    } 
}
