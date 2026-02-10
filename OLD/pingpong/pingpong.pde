Player player;
Player com;
Ball ball;

void setup(){
 size(1000, 1000);
 background(0);
 frameRate(60.0);
 
 player = new Player();
 com = new Player();
 ball = new Ball();
}

void draw(){
  background(0);
  
  ball.update(com.position);
  ball.update(player.position);
  com.playerCom(ball.position);
  player.playerUpt();
  
  player.draw();
  com.draw();
  ball.draw();
}
