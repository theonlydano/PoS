Game game;

void setup() {
    size(400, 400);
    game = new Game();
    game.init();
    rectMode(CENTER);
    ellipseMode(CENTER);
}

void draw() {
    game.update();
}
