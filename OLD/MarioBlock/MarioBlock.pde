Player player;
void setup(){
  size(600, 400, FX2D);
  background(0);
  
  player = new Player(20, 200, 100, 50);
}

void draw(){
  background(player.position.x / 3, player.position.x / 4, player.position.x / 2);
  //background(0);
  
  text(frameRate, 0, 10);
  
  player.update();
  
  player.draw();
}
