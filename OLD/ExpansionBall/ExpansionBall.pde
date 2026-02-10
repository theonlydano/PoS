void setup(){
  size(1000, 1000); 
  background(0);
  frameRate(164.5);
}

void draw(){
  if(frameCount % 26 == 0){ fill(random(0, 80), random(0, 80), random(0, 80)); }
  circle(width/2, height/2, frameCount/1.645);
}
