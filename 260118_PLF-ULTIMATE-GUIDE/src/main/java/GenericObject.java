public abstract class GenericObject {

    protected Vector location;
    protected Vector acceleration;

    abstract public void update(int width, int height);
    abstract public void draw(int width, int height);
}