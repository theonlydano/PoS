Background wallpaper;
Triangle triangle;

void setup(){
  size(600, 400);
  background(0);
  
  wallpaper = new Background(116, 121, 131, 200, 200, 200);
  triangle = new Triangle(0, 0, 20);
}

void draw(){
  wallpaper.draw();
  // triangle.draw();
  
  fill(0);
  text(frameRate, 0, 10);
  noFill();
}
