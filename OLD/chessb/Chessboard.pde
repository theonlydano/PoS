class Chessboard{
  private color firstColor;
  private color secondColor;
  // private float x;
  // private float y;
  private int count;
  private int countY;
  private int countX;
  
  public Chessboard(color fc, color sc){
    this.firstColor = fc;
    this.secondColor = sc;
    // x = 0;
    // y = 0;
    count = 0;
  }
  
  public void draw(){
    /*
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j ++){
        if(count % 2 == 0){
          fill(firstColor);
          rect(x, y, width/8, height/8);
          noFill();
        }else{
          fill(secondColor);
          rect(x, y, width/8, height/8);
          noFill();
        }
        count++;
        x+= width/8;
      }
      count++;
      x = 0;
      y += height/8;
    }
    */
    // background(0);
    if(countX == width){
     countX = 0;
     countY+= height/8;
     count++;
    }
    
    if(count % 2 == 0){
      fill(firstColor);
      rect(countX, countY, width/8, height/8);
      noFill();
    }else{
      fill(secondColor);
      rect(countX, countY, width/8, height/8);
      noFill();
    }
    countX+= width/8;
    count++;
    
  }
  
}
