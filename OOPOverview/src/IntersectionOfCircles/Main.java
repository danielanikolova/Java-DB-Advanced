package IntersectionOfCircles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Circle circle1 = CreateCircle(scan.nextLine());
        Circle circle2 = CreateCircle(scan.nextLine());
        int deltaX = circle1.getCenter().getX() - circle2.getCenter().getX();
        int deltaY = circle1.getCenter().getY() - circle2.getCenter().getY();

        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        if (distance > circle1.getRadius() + circle2.getRadius()) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    public static Circle CreateCircle(String input) {
        String[] tokens = input.split(" ");
        Point p = new Point(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        Circle circle = new Circle(p, Integer.parseInt(tokens[2]));
        return circle;
    }

}
