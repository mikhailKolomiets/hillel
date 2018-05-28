package homework2.part1;

/**
 * Created by Mihail Kolomiets on 27.05.18.
 */
public class Main {
    public static void main(String[] args) {

        //create any figure
        Rectangle rectangle = new Rectangle(4, 5);
        Rectangle square = new Rectangle(4.1);

        Elips elips = new Elips(4, 8);
        Elips circle = new Elips(4);
        System.out.println("Rectangle area: " + rectangle.area() + " perimeter: " + rectangle.perimeter());
        System.out.println("Square area: " + square.area() + " perimeter: " + square.perimeter());
        System.out.println("Elips area: " + elips.area() + " perimeter: " + elips.perimeter());
        System.out.println("Circle area: " + circle.area() + " perimeter: " + circle.perimeter());

        //make elipse from eectangle and square from circle and view his paramethers
        Figure unknownFigure;
        for (int i = 1; i <= 2; i++) {
            String figure;
            if (i == 1) {
                elips.setRadiusA(rectangle.getSideA());
                elips.setRadiusB(rectangle.getSideB());
                unknownFigure = elips;
                figure = "elips";
            } else {
                square.setSideA(circle.getRadiusA());
                unknownFigure = square;
                figure = "square";
            }

            System.out.println("New " + figure + " area: " + unknownFigure.area() + " and perimeter: " + unknownFigure.perimeter());

        }


    }
}
