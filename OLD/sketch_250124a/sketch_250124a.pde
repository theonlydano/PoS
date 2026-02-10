Block[][] b1;
Ball ball;
int space;
int space2;
int ballSize = 10;
Player player;
int counter; // Game Counter

void setup(){
 counter = 0;
 player = new Player();
 ball = new Ball(ballSize);
 space2 = 0;
 space = 0;
 b1 = new Block[10][50];
 
 size(600, 400); 
 frameRate(120.0);
 background(0, 0, 0);
 
 for(int j = 0; j < 10; j++){
   for(int i = 0; i < 50; i++){
     Vector fillV = new Vector(space, space2);
     b1[j][i] = new Block(fillV);
     space += width/50;
   }
   space = 0;
   space2 += 10 + 2;
 }
}

void draw(){
  background(0, 0, 0);
  
  for(int j = 0; j < 10; j++){
    for(int i = 0; i < 50; i++){ 
      if(b1[j][i] == null){
       continue; 
      }
      // Working Area-Bounce-If condition
      // But the player can stay on one position, so it is no fun
      if(ball.position.x + ballSize/2 >= b1[j][i].position.x && ball.position.x - ballSize/2 <= b1[j][i].position.x){
        if(ball.position.y + ballSize/2 >= b1[j][i].position.y && ball.position.y - ballSize/2 == b1[j][i].position.y){
          Vector del = new Vector(-10, -10);
          b1[j][i] = new Block(del);
          int back = 0;
          ball.update(back);
          counter++; // Adding +1 to game counter
        }
      }
     
     // Test to make the borders make it bounce back
      /*
     if(ball.position.x + ballSize/2 >= b1[j][i].position.x && ball.position.x - ballSize/2 <= b1[j][i].position.x && (ball.position.y + ballSize/2 == b1[j][i].position.y)){
       Vector del = new Vector(-10, 10);
       b1[j][i] = new Block(del);
       Vector xBounce = new Vector(-1, 1);
       ball.update(xBounce);
     }
     if(ball.position.y + ballSize/2 >= b1[j][i].position.y && ball.position.y - ballSize/2 <= b1[j][i].position.y && (ball.position.x + ballSize/2 == b1[j][i].position.x)){
       Vector del = new Vector(-10, 10);
       b1[j][i] = new Block(del);
       Vector yBounce = new Vector(1, -1);
       ball.update(yBounce);
     }
     */
     b1[j][i].draw();
    }
  }
  
  // Checking pos of player and ball -> making the Ball bounce of the player
  // if no bounce than the ball dropps through the ground
  if(ball.position.x >= player.position.x - 20 && ball.position.x <= player.position.x + 20){
    if(ball.position.y == height - 20){
     int back = 0;
     ball.update(back, back);
    }
  }
  
  ball.update();
  player.update();
  
  ball.draw();
  player.draw();
  
  // here the counter of score should be displayed but doesn´t work
  /*
  stroke(255, 255, 255);
  text(0, 200, counter);
  stroke(0);
  */
}
