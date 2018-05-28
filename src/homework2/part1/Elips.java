package homework2.part1;

/**
 * Created by Mihail Kolomiets on 27.05.18.
 */
public class Elips extends Figure {

    private double radiusA;
    private double radiusB;

    /**
     * flag itsCircle need only from count methods
     */
    private boolean itsCircle = false;

    //create circle
    public Elips (double radiusA) {
        this.radiusA = radiusA;
        itsCircle = true;
    }

    public Elips (double radiusA, double radiusB) {
        this.radiusA = radiusA;
        this.radiusB = radiusB;
    }

    @Override
    public double area() {
        if (itsCircle)
            return format(Math.PI * Math.pow(radiusA, 2));
        else
            return format(Math.PI * radiusA * radiusB);
    }

    @Override
    public double perimeter() {
        if (itsCircle)
            return format(2 * Math.PI * radiusA);
        else
        //sampling formula from count perimeter of elips from site wikipedia
            return format(4 * (Math.PI * radiusA * radiusB +
                    Math.pow(radiusA - radiusB, 2)) / (radiusA + radiusB));
    }

    public double getRadiusA() {
        return radiusA;
    }

    public void setRadiusA(double radiusA) {
        this.radiusA = radiusA;
    }

    public double getRadiusB() {
        return radiusB;
    }

    public void setRadiusB(double radiusB) {
        this.radiusB = radiusB;
    }
}
