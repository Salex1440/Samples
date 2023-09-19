package com.salex.equals;

/**
 * Hello world!
 */
public class EqualsMain {
    public static void main(String[] args) {
        Point x = new Point(0, 0);
        ColoredPoint y = new ColoredPoint(0, 0, "BLACK");
        Point z = new ColoredPoint(0, 0, "BLUE");

        System.out.println("Рефлексивность");
        System.out.println("x == x: " + x.equals(x));
        System.out.println("y == y: " + y.equals(y));
        System.out.println("z == z: " + z.equals(z));
        System.out.println();

        System.out.println("Симметрия");
        System.out.println("x == y: " + x.equals(y));
        System.out.println("y == x: " + y.equals(x));
        System.out.println("y == z: " + y.equals(z));
        System.out.println("z == y: " + z.equals(y));
        System.out.println();

        System.out.println("Транзитивность");
        System.out.println("x == y: " + x.equals(y));
        System.out.println("x == z: " + x.equals(z));
        System.out.println("y == z: " + y.equals(z));
        System.out.println();

//        printPoint(x);
//        printPoint(y);
//        printPoint(z);
    }

    public static void printPoint(Point point) {
        System.out.println(point);
    }
    public static void printPoint(ColoredPoint point) {
        System.out.println(point);
    }
}
