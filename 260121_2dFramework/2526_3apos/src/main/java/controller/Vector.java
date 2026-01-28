package controller;

public class Vector {
    private float x;
    private float y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void add(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
    }

    public void multiply(Vector vector) {
        this.x *= vector.x;
        this.y *= vector.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Vector [x=" + x + ", y=" + y + "]";
    }
}
