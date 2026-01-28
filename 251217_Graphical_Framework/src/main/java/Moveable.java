public class Moveable {
    protected Vector location; // x, y
    protected Vector velocity; // current speed
    protected Vector acceleration; // current acceleration

    public Moveable() {
        location = new Vector();
        velocity = new Vector(1,1);
        acceleration = new Vector();
    }

    public Moveable(Vector location, Vector velocity, Vector acceleration) {
        this.location = location;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public void setLocation(Vector location) {
        this.location = location;
    }
    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }
    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }
}
