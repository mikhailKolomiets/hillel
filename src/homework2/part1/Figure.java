package homework2.part1;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Mihail Kolomiets on 27.05.18.
 */
public abstract class Figure {

    /**
     * Extended class may count area and perimeter of figure
     */
    public abstract double area();

    public abstract double perimeter();

    /**
     *format double result
     */
    public double format(double digit) {
        digit = Math.floor(digit * 100);
        return digit / 100;
    }

}
