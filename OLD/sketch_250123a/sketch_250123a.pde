Square sq;
GravitationalBall gb;

void setup(){
  size(640, 480);
  background(0, 0, 0);
  frameRate(60.0);
  
  sq = new Square(200);
  gb = new GravitationalBall(2.0, 20);
}

void draw(){
  background(0, 0, 0);
  sq.update();
  gb.update();
  
  sq.draw();
  gb.draw();
}
