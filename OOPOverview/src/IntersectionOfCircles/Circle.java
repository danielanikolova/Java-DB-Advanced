package IntersectionOfCircles;

public class Circle {
    private Point Center;
    private int Radius;

    public Circle(Point Center, int Radius){
        this.Center = Center;
        this.Radius = Radius;
    }

    public Point getCenter() {
        return Center;
    }

    public void setCenter(Point Center) {
        this.Center = Center;
    }

    public int getRadius() {
        return Radius;
    }

    public void setRadius(int Radius) {
        this.Radius = Radius;
    }
}
