class Background{
  private color firstColor;
  private color secondColor;
  private float boxSize;
  
  public Background(int r1, int r2, int g1, int g2, int b1, int b2){
    firstColor = color(r1, g1, b1);
    secondColor = color(r2, g2, b2);
    boxSize = 1.1;
  }
  
  public void draw(){
    background(firstColor);
    fill(secondColor);
    for(int i = 0; i < height/boxSize; i++){
      if(i%2 == 0){
        rect(0, boxSize * i, width, boxSize); 
      }else{
        rect(boxSize * i, 0, boxSize, height); 
      }
    }
  }
}
