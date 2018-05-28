package homework2.part1;

/**
 * Created by Mihail Kolomiets on 27.05.18.
 *
 */
public class Rectangle extends Figure{

    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    //create square
    public Rectangle(double oneSide) {
        sideA = sideB = oneSide;
    }

    @Override
    public double area() {
        return format(sideA * sideB);
    }

    @Override
    public double perimeter() {
        return format(2 * (sideA + sideB));
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
}
