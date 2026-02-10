Chessboard cb;
color fc;
color sc;

void setup(){
  size(600, 800);
  background(0);
  frameRate(20.0);
  
  fc = color(100, 100, 100);
  sc = color(100, 150, 200);
  cb = new Chessboard(fc, sc);
}

void draw(){
  cb.draw();
}
