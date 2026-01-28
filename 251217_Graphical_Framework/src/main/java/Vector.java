public class Vector {
    private float x;
    private float y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector(){
        this.x = 0;
        this.y = 0;
    }

    public float getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void add(Vector v) {
        this.x += v.getX();
        this.y += v.getY();
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void subtract(Vector v) {
        this.x -= v.getX();
        this.y -= v.getY();
    }

    public void subtract(int x, int y) {
        this.x -= x;
        this.y -= y;
    }

    public void multiply(Vector v) {
        this.x *= v.getX();
        this.y *= v.getY();
    }
}
